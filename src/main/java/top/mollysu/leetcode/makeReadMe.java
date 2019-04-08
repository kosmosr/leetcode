package top.mollysu.leetcode;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zmh
 * @date 2019-04-08 11:37
 */
public class makeReadMe {
    public static void main(String[] args) {
        File file = new File("src/main/java/top.mollysu.leetcode.solutions");
        String[] fileNames = file.list();
        List<String> collect = Arrays.stream(fileNames)
                .sorted(Comparator.comparingInt(e -> Integer.valueOf(e.substring(e.length() - 3))))
                .collect(Collectors.toList());
        System.out.println(file);
    }
}
