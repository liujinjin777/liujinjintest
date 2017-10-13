package com.liujinjin.temp;

/**
 * Created by liuxin on 2017/9/15.
 */
public class T10 {

    public static void main(String[] args) {
        String ip = "192.168.4.152";

        String[] split = ip.split("\\.");

        long score = 0;
        for(String s : split){
            /**
             * 作者很6
             *
             * 按。分割，共分为4个部分，每个部分占8位，最左占最高位。
             * 192.168.4.152
             *
             * 0000000.00000000.00000000.00000000
             * 192      168         4       152
             *
             * 192 << 8 == 192 * 2^8 == 192 * 256
             */
            score = score * 256 + Long.valueOf(s);
        }

        System.out.println(score);

    }
}
