package com.liujinjin.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.ClusterRuleConstant;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.ClusterFlowConfig;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

/**
 * Created by liuxin on 2022/8/9.
 */
public class SentinelTest {

  @Test
  public void test() {
    // 配置规则.
    initFlowRules();

    while (true) {
      // 1.5.0 版本开始可以直接利用 try-with-resources 特性
      try (Entry ignored = SphU.entry("HelloWorld")) {
        // 被保护的逻辑
        System.out.print("hello world");
      } catch (BlockException ex) {
        // 处理被流控的逻辑
        System.out.println("blocked!");
      }
    }
  }

  private static void initFlowRules(){

  }


}
