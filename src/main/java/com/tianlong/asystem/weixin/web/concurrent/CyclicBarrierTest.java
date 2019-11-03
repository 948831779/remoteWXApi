package com.tianlong.asystem.weixin.web.concurrent;

import java.util.concurrent.CyclicBarrier;

/**
 * @program: asystem
 * <p>
 * CyclicBarrier可以使一定数量的线程反复地在栅栏位置处汇集。
 * 当线程到达栅栏位置时将调用await方法，这个方法将阻塞直到所有线程都到达栅栏位置。
 * 如果所有线程都到达栅栏位置，那么栅栏将打开，此时所有的线程都将被释放，而栅栏将被重置以便下次使用。
 *
 *
 *
 * CyclicBarrier还提供一个更高级的构造函数
 * CyclicBarrier（int parties，Runnable barrier- Action），
 * 用于在线程到达屏障时，优先执行barrierAction，方便处理更复杂的业务场景，如代码 清单8-4所示。
 *
 *
 * @description: CyclicBarrierTest
 * @author: tianlong@cdtiansheng.com
 * @create: 2019-08-30 17:01
 **/

public class CyclicBarrierTest {
    static CyclicBarrier c = new CyclicBarrier(2, new A());

    public static void main(String[] args) {
       Thread t =  new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    c.await();

                } catch (Exception e) {
                }
                System.out.println(1);
            }
        });
        System.out.println(1+"   "+t.isInterrupted());
        t.start();
        try {
            c.await();
        } catch (Exception e) {
        }
        System.out.println(2+"   "+t.isInterrupted());
    }

    static class A implements Runnable {
        @Override
        public void run() {
            System.out.println(3);
        }
    }
}
