package com.liujinjin.momo20221024.bean;

import java.util.List;
import java.util.Map;
import lombok.Data;

/**
 * Created by liuxin on 2022/10/21.
 */
@Data
public class RoundInfo {
  private int id;
  // 2022-10-21T13:33:38.000+08:00
  private String startTime;
  private String endTime;
  private List<String> groupNames;

  // key=齐宇
  private Map<String, List<Integer>> perCardInfo;
  // 提交的顺序
  private Map<String, List<Integer>> finalCardInfo;
  private String winnerGroup;
}
