package com.liujinjin.book.pattern.proxy;

/**
 * @author liuxin
 * @date 2018/5/4
 */
public class GamePlayer implements IGamePlayer {

    @Override
    public void login(String user, String password) {
        System.out.println("已登录" + user + " " + password);
    }

    @Override
    public void killBoss() {
        System.out.println("kill boss");
    }

    @Override
    public void upgrade() {
        System.out.println(" ");
    }
}
