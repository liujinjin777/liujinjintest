package com.liujinjin.temp;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;

/**
 * Created by liuxin on 2017/7/18.
 */
public class GetMacIndess {

    public static void main(String[] args) throws Exception {

        /*InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        System.out.println(getLocalMac(localHost));*/

        String mac = "1C-66-6D-94-36-7D";
        String[] split = mac.split("-");
        System.out.println(split);

        String resp = "";
        for(String s : split){
            int i = Integer.parseInt(s, 16);
            System.out.println(i);
            resp = resp + i;
        }
        System.out.println(Long.parseLong(resp));
    }

    private static String getLocalMac(InetAddress ia) throws SocketException {
        // TODO Auto-generated method stub
        //获取网卡，获取地址
        byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
        System.out.println("mac数组长度："+mac.length);
        StringBuffer sb = new StringBuffer("");
        for(int i=0; i<mac.length; i++) {
            /*iif(i!=0) {
                sb.append("-");
            }*/
            //字节转换为整数
            int temp = mac[i]&0xff;
            String str = Integer.toHexString(temp);
            if(str.length()==1) {
                sb.append("0"+str);
            }else {
                sb.append(str);
            }
        }

        return sb.toString().toUpperCase();
    }
}
