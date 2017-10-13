package com.liujinjin.book.hexinjishu.d14;

import javax.swing.*;
import java.awt.*;

/**
 * Created by liuxin on 2017/8/9.
 */
public class Bounce {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new BounceFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
