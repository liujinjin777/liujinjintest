package com.liujinjin.momo20221024.bean;

import java.util.List;
import lombok.Data;

/**
 * Created by liuxin on 2022/10/21.
 */
@Data
public class CardInfo {

  // 获胜得分
  private List<GroupRank> groupRank;
  // 队列信息
  private List<String> queueInfo;
  // 轮次信息
  private List<CardRoundInfo> roundInfos;

  @Data
  public static class GroupRank {
    private String groupName;
    private int score;
  }

  @Data
  public static class CardRoundInfo {
    private int roundNum;
    // 2022-10-21 14:41:36
    private String startTime;
    private List<String> groupNames;
    private String winnerGroup;
  }


}
