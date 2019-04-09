package top.mollysu.leetcode.generate;


import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.mollysu.leetcode.generate.model.AllProblemsModel;
import top.mollysu.leetcode.generate.model.LeetCodeLoginModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zmh
 * @date 2019-04-08 11:37
 */
public class ReadMeGenerate {
    private static final Logger log = LogManager.getLogger(ReadMeGenerate.class);

    private static final String BASE_URL = "https://leetcode-cn.com";

    private static final String BASE_SOLUTION_URL = "https://leetcode-cn.com/problems/";

    private static LeetCodeLoginModel loginModel = new LeetCodeLoginModel();

    private static HashMap<String, List<Cookie>> cookieStore = new HashMap<>();

    private static OkHttpClient client = new OkHttpClient.Builder().cookieJar(new CookieJar() {
        @Override
        public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
            boolean containsKey = cookieStore.containsKey(httpUrl.host());
            if (containsKey) {
                List<Cookie> cookies = new ArrayList<>(cookieStore.get(httpUrl.host()));
                list.forEach(e -> {
                    boolean anyMatch = cookies.stream().anyMatch(cookie -> cookie.name().equals(e.name()));
                    if (!anyMatch) {
                        cookies.add(e);
                    }
                });
                cookieStore.put(httpUrl.host(), cookies);
            } else {
                cookieStore.put(httpUrl.host(), list);
            }
            list.forEach(e -> {
                if ("csrftoken".equals(e.name())) {
                    loginModel.setCsrfToken(e.value());
                }
                if ("LEETCODE_SESSION".equals(e.name())) {
                    loginModel.setSession(e.value());
                }
            });
        }

        @Override
        public List<Cookie> loadForRequest(HttpUrl httpUrl) {
            List<Cookie> cookies = cookieStore.get(httpUrl.host());
            return cookies != null ? cookies : new ArrayList<>();
        }
    }).build();

    private static void setCsrfToken() {
        Request indexRequest = new Request.Builder()
                .url(BASE_URL)
                .build();
        try (Response response = client.newCall(indexRequest).execute()) {
            log.info("response: {}", response.toString());
        } catch (IOException e) {
            log.error("请求失败: {}", e.getMessage());
        }
    }

    public static void login(String username, String password) {
        setCsrfToken();
        loginModel.setLogin(username);
        loginModel.setPassword(password);
        RequestBody loginBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("login", loginModel.getLogin())
                .addFormDataPart("password", loginModel.getPassword())
                .addFormDataPart("csrfmiddlewaretoken", loginModel.getCsrfToken())
                .build();
        Request loginRequest = new Request.Builder()
                .url(BASE_URL + "/accounts/login/")
                .post(loginBody)
                .addHeader("referer", "https://leetcode-cn.com/accounts/login/")
                .build();
        try (Response response = client.newCall(loginRequest).execute()) {
            log.info("response: {}", response.toString());
        } catch (IOException e) {
            log.error("请求失败: {}", e.getMessage());
        }
    }

    public static void getAll() {
        Request allRequest = new Request.Builder().url(BASE_URL + "/api/problems/all/").build();
        try (Response response = client.newCall(allRequest).execute()) {
            log.info("response: {}", response);
            String json = response.body().string();
            AllProblemsModel allProblemsModel = JSON.parseObject(json, AllProblemsModel.class);
            List<AllProblemsModel.Pairs> statStatusPairs = allProblemsModel.getStatStatusPairs()
                    .stream()
                    .sorted(AllProblemsModel.Pairs::compareTo)
                    .filter(e -> e.getStatus() != null)
                    .collect(Collectors.toList());
            ;
            StringBuilder middleBuilder = new StringBuilder();
            middleBuilder
                    .append("| 总题数 | 已解决 | 简单 | 中等 | 困难 |").append('\n')
                    .append("| :----: | :----: | :--: | :--: | :----: |").append('\n')
                    .append("|  ").append(allProblemsModel.getNumTotal())
                    .append("  |  ").append(allProblemsModel.getNumSolved())
                    .append("  |  ").append(allProblemsModel.getAcEasy())
                    .append("  |  ").append(allProblemsModel.getAcMedium())
                    .append("  |  ").append(allProblemsModel.getAcHard()).append("  |  ").append('\n');
            String middle = middleBuilder.toString();
            StringBuilder contentBuilder = new StringBuilder();
            contentBuilder
                    .append("|#|Title|Solution|Difficulty|").append('\n')
                    .append("|:--:|:------:|:---------:|:---------: | :--------: |").append('\n');
            statStatusPairs.forEach(e -> {
                AllProblemsModel.Stat stat = e.getStat();
                contentBuilder.append("|").append(stat.getFrontendQuestionId())
                        .append("|[").append(stat.getQuestionTitle()).append("]")
                        .append("(").append(BASE_SOLUTION_URL).append(stat.getQuestionTitleSlug()).append("/)");
            });
            System.out.println(middle);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        login("null", "null");
        getAll();
       /* File file = new File("src/main/java/top.mollysu.leetcode.solutions");
        String[] fileNames = file.list();
        List<String> collect = Arrays.stream(fileNames)
                .sorted(Comparator.comparingInt(e -> Integer.valueOf(e.substring(e.length() - 3))))
                .collect(Collectors.toList());
        System.out.println(file);*/
    }
}
