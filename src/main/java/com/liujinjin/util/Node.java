package com.liujinjin.util;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author liuxin
 * @date 2018/12/21
 */
@Data
@AllArgsConstructor
public class Node {

    private Object value;
    private AtomicReference<Node> next;
}
