package com.tianlong.asystem.weixin.web.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @program: asystem
 *
 *
 * thread.join()与CountDownLatch
 * @description: JoinCountDownLatchTest
 * @author: tianlong@cdtiansheng.com
 * @create: 2019-08-30 16:51
 **/

public class JoinCountDownLatchTest {
    static CountDownLatch c = new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException {
        Thread parser1 = new Thread(new Runnable() {
            @Override public void run() {
                System.out.println("parser1 running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("parser1 finish");
            }
        });
        Thread parser2 = new Thread(new Runnable() {
            @Override public void run() {
                System.out.println("parser2 running");
                 try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("parser2 finish");
            }
        });
        parser1.start();
        parser2.start();
        parser1.join();
        parser2.join();
        System.out.println("all parser finish");


        System.out.println(",......................................................");


        new Thread(new Runnable() {
            @Override public void run() {
            System.out.println(1);
            c.countDown();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(2);
            c.countDown();} }).start();

        /**
         * c.await(1500, TimeUnit.MILLISECONDS);
         * 等待时间、等待单位（秒、毫秒）
         */
        c.await(1500, TimeUnit.MILLISECONDS);
        System.out.println("3");

    }


}
