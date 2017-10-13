package com.liujinjin.book.javaer.t5;

/**
 * Created by liuxin on 2017/8/21.
 */
public class Client {

    public void methodA(String str, Integer... is){

    }

    public void methodA(String str, String... strs){

    }

    public static void main(String[] args) {
        Client client = new Client();
        client.methodA("China", 0);
        client.methodA("C", "P");
        /*client.methodA("China");
        client.methodA("china", null);*/
    }
}
