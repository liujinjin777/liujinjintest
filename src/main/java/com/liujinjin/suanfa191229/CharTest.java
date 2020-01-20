package com.liujinjin.suanfa191229;

/**
 * @author liuxin23
 * @date 2020/01/12
 */
public class CharTest {

        public static void main(String[] args) {
        /*char和int类型能够相互转换，相信大家都明白
          什么？不明白？？？那只能怪你大一c语言老师死的早 */

            //为什么是0～128的取值范围？其实这只是个大概范围，具体看看编码表就一目了然了
            int count = 0;
            for (char c = 65; c <= 122; c++) {
                //java里边包装类的一个静态方法，确定c是字母还是小写！！！）
                if(Character.isLetter(c)) {
                    System.out.printf("value: %3d  char: %c\n", (int) c, c);

                }
                count++;
            }

            System.out.println(count);
        }
}
