package top.mollysu.leetcode.generate.model;

import lombok.Getter;

/**
 * @author zmh
 * @date 2019-04-11 13:51
 */
@Getter
public enum ProblemStatusEnum {
    /**
     * 题目状态
     */
    TODO(null, "未做"),
    SOLVED("ac", "已解答"),
    ATTEMPTED("notac", "尝试过");
    private String status;

    private String description;

    ProblemStatusEnum(String status, String description) {
        this.status = status;
        this.description = description;
    }
}
