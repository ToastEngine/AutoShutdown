/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.toastengine.autoshutdown;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Andy
 */
public class UptimeTask{
    long startTime;
    public UptimeTask(){
        startTime = System.nanoTime();
    }
    public int getUptime(){
        long Upt = System.nanoTime()-startTime;
        return (int)TimeUnit.SECONDS.convert(Upt, TimeUnit.NANOSECONDS);
    }
}
