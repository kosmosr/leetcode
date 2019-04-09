package top.mollysu.leetcode.generate.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * @author zmh
 * @date 2019-04-09 21:40
 */
@Data
public class AllProblemsModel {
    private String userName;

    private Integer numSolved;

    private Integer numTotal;

    private Integer acEasy;

    private Integer acMedium;

    private Integer acHard;

    private List<Pairs> statStatusPairs;

    @Data
    public static class Pairs implements Comparable<Pairs> {
        private Stat stat;

        private String status;

        private DifficultyLevel difficulty;


        @Override
        public int compareTo(Pairs o) {
            return this.getStat().getFrontendQuestionId() - o.getStat().getFrontendQuestionId();
        }
    }

    @Data
    public static class Stat {
        private Integer frontendQuestionId;

        private Integer totalAcs;

        private Integer totalSubmitted;

        @JSONField(name = "question__hide")
        private Boolean questionHide;

        @JSONField(name = "question__title")
        private String questionTitle;

        @JSONField(name = "question__title_slug")
        private String questionTitleSlug;
    }

    @Data
    public static class DifficultyLevel {
        private Integer level;
    }
}
