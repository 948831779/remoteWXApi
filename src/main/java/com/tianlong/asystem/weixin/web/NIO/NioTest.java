package com.tianlong.asystem.weixin.web.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @program: asystem
 * @description: 测试nio
 * @author: tianlong@cdtiansheng.com
 * @create: 2019-10-20 20:59
 **/

public class NioTest {


    public static void main(String[] args) {
        //<editor-fold desc="Description">
        int port = 10000;
        try {
            Selector selector = Selector.open();
            try(ServerSocketChannel channel= ServerSocketChannel.open()){
                channel.bind(new InetSocketAddress(port));
                channel.configureBlocking(false);
                channel.register(selector, SelectionKey.OP_ACCEPT);
            }catch(Exception e){

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //</editor-fold>
    }
}
