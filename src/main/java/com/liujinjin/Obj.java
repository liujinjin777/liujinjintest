package com.liujinjin;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import lombok.Data;
import org.junit.Test;

import java.util.Map;

/**
 * @author liuxin
 * @date 2018/11/21
 */
@Data
public class Obj {

    private Map<String, Object> data;
    // private String data;

    @Test
    public void test(){
        Joiner SEGMENT = Joiner.on(";");
        String join = SEGMENT.join(Lists.newArrayList());
        System.out.println(join + "  123123");
    }
}
