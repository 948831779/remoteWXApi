package com.tianlong.asystem.weixin.web.jdk8.test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @program: asystem
 * @description: 并发队列
 * @author: tianlong@cdtiansheng.com
 * @create: 2019-08-30 12:46
 **/

public class ConcurrentLinkedDequeTest {
    public static void main(String[] args) {
        ConcurrentLinkedDeque q = new ConcurrentLinkedDeque();
        q.offer("余胜军");
        q.offer("码云");
        q.offer("蚂蚁课堂");
        q.offer("张杰");
        q.offer("艾姐");
        //从头获取元素,删除该元素
        System.out.println(q.poll());
        //从头获取元素,不刪除该元素
        System.out.println(q.peek());
        //获取总长度
        System.out.println(q.size());



        Deque<String> deque = new LinkedList<String>();
        deque.push("a");
        deque.push("b");
        deque.push("c");
        System.out.println(deque);
        //获取栈首元素后，元素不会出栈
        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);
        while(deque.size() > 0) {
            //获取栈首元素后，元素将会出栈
            System.out.println(deque.pop());
        }
        System.out.println(deque);

    }
}
