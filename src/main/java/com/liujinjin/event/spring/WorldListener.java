package com.liujinjin.event.spring;

import org.springframework.context.ApplicationListener;

import java.io.PrintStream;

public class WorldListener implements ApplicationListener<ConsolerEvent>{
    private final PrintStream out;

    public WorldListener(PrintStream out) {

        this.out = out;
    }


    @Override
    public void onApplicationEvent(ConsolerEvent event) {
        String source = (String) event.getSource();
        if (source.toLowerCase().contains("world")){
            out.println("WorldListener: " + source + " - " + Thread.currentThread().getName());
        }
    }
}
