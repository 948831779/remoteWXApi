package com.tianlong.asystem.weixin.web.service.impl;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianlong.asystem.weixin.web.service.CommdityService;
import com.tianlong.asystem.weixin.web.simulatedpersistenceLayer.CommditySvc;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @program: asystem
 * @description: 歌曲服务接口实现类
 * @author: tianlong@cdtiansheng.com
 * @create: 2019-10-10 08:50
 **/
@Service
public class CommdityServiceImpl implements CommdityService {

    @Autowired
    private CommditySvc commditySvc;

    class Request{
        String code;
        CompletableFuture<Object> future;
        public Request() {

        }
        public Request(String code, CompletableFuture<Object> future) {
            this.code = code;
            this.future = future;
        }
    }

    BlockingQueue<Request> queue = new LinkedBlockingDeque();


    @Override
    public Object queryByCode(String code) {

        return commditySvc.queryByCode(code);
    }

    @Override
    public Object queryByCodeBatch(String code) {
        //1、拦截请求并放到缓存

        CompletableFuture<Object> future = new CompletableFuture<>();
        Request request =  new Request(code,future);
        queue.add(request);
        Object obj =null ;
        try {
            obj  =  future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return obj;
    }
    @PostConstruct
    public void init(){

        ExecutorService executorService =   Executors.newScheduledThreadPool(1);
         ((ScheduledExecutorService) executorService).scheduleAtFixedRate(() ->{
            int size  =  queue.size();
            if(size == 0){
                return;
            }

             ArrayList<Request> list = new ArrayList<>(size);
            for (int i = 0 ;i<size;i++){
                Request req = queue.poll();
                list.add(req);
            }
             System.out.println("批量处理数据数:" +size);
             ArrayList<String> listStr = new ArrayList<>(size);
             for(Request req : list){
                 listStr.add(req.code);
             }
             //获取批量结果集  如果返回的是list的话需要手动处理下
             Map<String, Object>  responseMap =   queryBatchByCodes(listStr);

             //将相应的结构发给对应的请求
             for(Request req : list){

                 req.future.complete(responseMap.get(req.code));
             }


         },0,10,TimeUnit.MILLISECONDS);
    }

    @Override
    public Map<String, Object> queryBatchByCodes(List<String> listCodes) {

        return commditySvc.queryBatchByCodes(listCodes);
    }


}
