package top.mollysu.leetcode.generate.model;

import lombok.Data;

/**
 * @author zmh
 * @date 2019-04-08 21:25
 */
@Data
public class LeetCodeLoginModel {
    private String csrfToken;

    private String login;

    private String password;

    private String session;
}
