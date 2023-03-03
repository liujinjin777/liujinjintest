package com.liujinjin.momo20221024;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.liujinjin.momo20221024.bean.CardInfo;
import com.liujinjin.momo20221024.bean.CardInfo.CardRoundInfo;
import com.liujinjin.momo20221024.bean.RoundInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javax.smartcardio.Card;
import jdk.internal.org.objectweb.asm.tree.FrameNode;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * Created by liuxin on 2022/10/21.
 */
public class Main {

  private static final String name = "刘鑫";
  private static final Joiner joiner = Joiner.on(",");
  // 其他选手历史排序
  private static final Map<String, List<Integer>> otherSortMap = new HashMap<>();

  public static void main(String[] args) {
    while (true) {
      execute();
      sleep(1000);
    }
  }

  public static void execute() {
    // 报名
    boolean success = Momo1024HttpService.cardReady();
    System.out.println("报名：" + success);
    if (!success) {
      return;
    }

    // 等待匹配
    CardRoundInfo cardRoundInfo;
    List<CardRoundInfo> cardRoundInfos;
    while (true) {
      CardInfo cardInfo = Momo1024HttpService.cardInfo();
      if (cardInfo == null) {
        sleep(1000);
        continue;
      }
      cardRoundInfos = cardInfo.getRoundInfos();
      cardRoundInfo = cardRoundInfos.stream()
          .filter(r -> StringUtils.isBlank(r.getWinnerGroup()))
          .filter(r -> r.getGroupNames().contains(name))
          .findFirst().orElse(null);
      if (cardRoundInfo != null) {
        break;
      }
      System.out.println("排队中");
      sleep(1000);
    }
    System.out.println("匹配信息：" + cardRoundInfo.getRoundNum() + " "
        + cardRoundInfo.getStartTime() + " " + cardRoundInfo.getGroupNames());

    // 收集其他选手信息
    collectOtherData(cardRoundInfo.getGroupNames(), cardRoundInfos);

    // 查询
    int roundNum = cardRoundInfo.getRoundNum();
    String startTimeStr = cardRoundInfo.getStartTime();
    long startTime = JodaDateUtil.yyyyMMddHHmmss.parseMillis(startTimeStr);
    while (true) {
      if (System.currentTimeMillis() <= startTime) {
        sleep(1000);
        continue;
      }

      RoundInfo roundInfo = Momo1024HttpService.roundInfo(roundNum);
      if (roundInfo == null) {
        sleep(1000);
        continue;
      }

      Map<String, List<Integer>> perCardInfo = roundInfo.getPerCardInfo();
      List<Integer> cards = perCardInfo.get(name);
      // 出牌策略
      // cards = calStrategy(cards, cardRoundInfo.getGroupNames());
      if (cardRoundInfo.getGroupNames().contains("齐宇")) {
        cards = calStrategyRandomQiyu(cards);
      } else if (cardRoundInfo.getGroupNames().contains("发际线总是在和我作队")) {
        cards = calStrategyRandomFajixian(cards);
      } else {
        cards = calStrategyRandom(cards);
      }

      boolean ready = Momo1024HttpService.operate(roundNum, joiner.join(cards));
      if (ready) {
        System.out.println("ready：" + ready + " cards：" + cards);
        break;
      }
      if (System.currentTimeMillis() >= (startTime + TimeUnit.SECONDS.toMillis(30))) {
        break;
      }
      sleep(1000);

    }

  }

  // 发际线总是在和我作队 [6,7,8,9,10,11,12,5,4,3,2,1,0]
  // [9,10,11,12,0,1,2,8,7,6,5,4,3]
  private static List<Integer> calStrategyRandomFajixian(List<Integer> cards) {
    List<Integer> sub1 = cards.subList(0, 4);
    List<Integer> sub2 = cards.subList(4, 9);
    List<Integer> sub3 = cards.subList(9, 13);
    /*Collections.shuffle(sub1);*/
    Collections.reverse(sub2);
    //Collections.shuffle(sub3);*/
    List<Integer> all = new ArrayList<>();
    all.addAll(sub3);
    all.addAll(sub1);
    all.addAll(sub2);

    // 打印
    List<Integer> sortedCards = all.stream().sorted().collect(Collectors.toList());
    // 排几
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < sortedCards.size(); i++) {
      map.put(sortedCards.get(i), i);
    }
    List<Integer> sCards = all.stream().map(map::get).collect(Collectors.toList());
    System.out.println("提交: " + sCards);
    return all;
  }

  // "齐宇":[6,7,8,9,10,11,12,0,1,2,3,4,5]
  //       [9,10,11,12,0,1,2,3,4,5,6,7,8]
  private static List<Integer> calStrategyRandomQiyu(List<Integer> cards) {
    List<Integer> sub1 = cards.subList(0, 9);
    List<Integer> sub2 = cards.subList(9, 13);
    /*Collections.shuffle(sub1);
    Collections.reverse(sub2);*/
    //Collections.shuffle(sub3);
    List<Integer> all = new ArrayList<>();
    all.addAll(sub2);
    all.addAll(sub1);

    // 打印
    List<Integer> sortedCards = all.stream().sorted().collect(Collectors.toList());
    // 排几
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < sortedCards.size(); i++) {
      map.put(sortedCards.get(i), i);
    }
    List<Integer> sCards = all.stream().map(map::get).collect(Collectors.toList());
    System.out.println("提交: " + sCards);
    return all;
  }

  private static List<Integer> calStrategyRandom(List<Integer> cards) {
    List<Integer> sub1 = cards.subList(0, 3);
    List<Integer> sub2 = cards.subList(3, 11);
    List<Integer> sub3 = cards.subList(11, 13);
    /*Collections.shuffle(sub1);
    Collections.reverse(sub2);*/
    //Collections.shuffle(sub3);
    List<Integer> all = new ArrayList<>();
    all.addAll(sub2);
    all.addAll(sub3);
    all.addAll(sub1);

    // 打印
    List<Integer> sortedCards = all.stream().sorted().collect(Collectors.toList());
    // 排几
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < sortedCards.size(); i++) {
      map.put(sortedCards.get(i), i);
    }
    List<Integer> sCards = all.stream().map(map::get).collect(Collectors.toList());
    System.out.println("提交: " + sCards);
    return all;
  }

  private static List<Integer> calStrategy(List<Integer> cards, List<String> groupNames) {
    groupNames.remove(name);

    String name1 = Iterables.get(groupNames, 0);
    String name2 = Iterables.get(groupNames, 1);
    String name3 = Iterables.get(groupNames, 2);

    List<Integer> cards1 = otherSortMap.get(name1);
    List<Integer> cards2 = otherSortMap.get(name2);
    List<Integer> cards3 = otherSortMap.get(name3);

    if (CollectionUtils.isEmpty(cards1) || CollectionUtils.isEmpty(cards2)
        || CollectionUtils.isEmpty(cards3)) {
      Collections.shuffle(cards);
      return cards;
    }

    List<Integer> newCards = new ArrayList<>();
    for (int i = 0 ; i < cards.size(); i++) {
      // 从0开始
      int card1 = cards1.get(i);
      int card2 = cards2.get(i);
      int card3 = cards3.get(i);
      int winCard = Math.max(Math.max(card1, card2), card3);
      if (winCard >= 10) {
        for (Integer card : cards) {
          if (!newCards.contains(card)) {
            newCards.add(card);
          }
        }
      } else {
        for (int j = winCard + 2; j < cards.size(); j++) {
          if (!newCards.contains(cards.get(j))) {
            newCards.add(cards.get(j));
          }
        }
      }
    }

    // 兜底
    Collections.shuffle(cards);
    for (int card : cards) {
      if (!newCards.contains(card)) {
        newCards.add(card);
      }
    }

    List<Integer> sortedCards = newCards.stream().sorted().collect(Collectors.toList());
    // 排几
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < sortedCards.size(); i++) {
      map.put(sortedCards.get(i), i);
    }
    List<Integer> sCards = newCards.stream().map(map::get).collect(Collectors.toList());
    System.out.println("提交: " + sCards);

    return newCards;
  }

  private static void collectOtherData(List<String> groupNames,
      List<CardRoundInfo> cardRoundInfos) {
    if (CollectionUtils.isEmpty(cardRoundInfos)) {
      return;
    }

    List<String> newGroupNames = new ArrayList<>(groupNames);
    // 对手
    a : for (String groupName : newGroupNames) {
      if (Objects.equals(name, groupName)) {
        continue;
      }

      // 历史
      for (CardRoundInfo cardRoundInfo : cardRoundInfos) {
        if (cardRoundInfo.getGroupNames().contains(groupName)) {
          int roundNum = cardRoundInfo.getRoundNum();
          RoundInfo roundInfo = Momo1024HttpService.roundInfo(roundNum);
          if (roundInfo == null || roundInfo.getFinalCardInfo() == null) {
            continue;
          }
          List<Integer> cards = roundInfo.getFinalCardInfo().get(groupName);
          List<Integer> sortedCards = cards.stream().sorted().collect(Collectors.toList());
          // 排几
          Map<Integer, Integer> map = new HashMap<>();
          for (int i = 0; i < sortedCards.size(); i++) {
            map.put(sortedCards.get(i), i);
          }

          List<Integer> newCards = cards.stream()
              .map(map::get)
              .collect(Collectors.toList());
          if (newCards.size() >= 13) {
            otherSortMap.put(groupName, newCards);
            continue a;
          }
        }
      }
    }
    System.out.println("历史数据排名：" + JSON.toJSONString(otherSortMap));
  }

  public static void sleep(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
