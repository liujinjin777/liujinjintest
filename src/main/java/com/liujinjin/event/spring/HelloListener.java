package com.liujinjin.event.spring;

import org.springframework.context.ApplicationListener;

import java.io.PrintStream;

public class HelloListener implements ApplicationListener<ConsolerEvent> {
    private final PrintStream out;

    public HelloListener(PrintStream out) {
        this.out = out;
    }


     @Override
     public void onApplicationEvent(ConsolerEvent event) {
         String source = (String) event.getSource();
         if (source.toLowerCase().contains("hello")){
             out.println("HelloListener: " + source + " - " + Thread.currentThread().getName());
         }
     }
}
