package com.liujinjin.temp.testData;

import lombok.Data;
import lombok.ToString;

/**
 * @author liuxin
 * @date 2017/11/30
 */
@Data
@ToString(callSuper = true)
public class S extends F {

    int b = 2;
}
