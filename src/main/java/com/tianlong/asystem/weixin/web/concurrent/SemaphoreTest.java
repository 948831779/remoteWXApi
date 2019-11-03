package com.tianlong.asystem.weixin.web.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @program: asystem   信号量
 * @description: SemaphoreTest
 * @author: tianlong@cdtiansheng.com
 * @create: 2019-08-30 17:26
 **/

public class SemaphoreTest {

    private static final int THREAD_COUNT = 30;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore s = new Semaphore(2);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        s.acquire();
                        Thread.sleep(1000);
                        System.out.println("save data    当前线程名称 = " +s.getQueueLength() + "  "+s.availablePermits());
                        s.release();
                    } catch (Exception e) {

                    }
                }
            });
        }
        threadPool.shutdown();
    }
}
