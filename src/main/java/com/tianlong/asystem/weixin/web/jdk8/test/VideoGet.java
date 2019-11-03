package com.tianlong.asystem.weixin.web.jdk8.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @program: asystem
 * @description:
 * @author: tianlong@cdtiansheng.com
 * @create: 2019-08-30 12:38
 **/

public class VideoGet {


    private static String sign = "mp4";

    private static String getFileID(String fileid, double seed){//vid
        //System.out.println("正在分析fileid(vid)....");
        String mixed = getFileIDMixString(seed);
        //System.out.println("fileid: "+fileid);
        String[] ids = fileid.split("\\*");
        StringBuilder realId = new StringBuilder();
        int idx;
        for (int i = 0; i < ids.length; i++) {
            idx = Integer.parseInt(ids[i]);//string to int
            realId.append(mixed.charAt(idx));
        }
        //System.out.println("vid分析完成，值为: "+realId.toString());
        return realId.toString();
    }

    private static String getFileIDMixString(double seed){ //mixed
        //System.out.println("正在分析mixed...........");
        StringBuilder mixed = new StringBuilder();
        StringBuilder source = new StringBuilder("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ/\\:._-1234567890");
        int index, len = source.length();
        for (int i = 0; i < len; ++i)
        {
            seed = (seed * 211 + 30031) % 65536;
            index = (int) Math.floor(seed / 65536 * source.length());//向下取整
            mixed.append(source.charAt(index));
            source.deleteCharAt(index);
        }
        //System.out.println("mixed分析完成，值为: "+mixed.toString());
        return mixed.toString();
    }

    public static String getSid(){ //sid
        int i1 = (int) (1000 + Math.floor(Math.random() * 999));
        int i2 = (int) (1000 + Math.floor(Math.random() * 9000));
        return System.currentTimeMillis() + "" + i1 + "" + i2;
    }
    private static String UrlConnection(String strUrl){
        try {
            URL url = new URL(strUrl);
            URLConnection uc = url.openConnection();// 生成连接对象
            uc.setConnectTimeout(5000);
            uc.connect(); // 发出连接
            StringBuffer sb = new StringBuffer();
            String temp;
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(), "gbk"));// 读取网页全部内容
            while ((temp = in.readLine()) != null) {
                sb.append(temp);
            }
            return sb.toString();
        }
        catch (Exception e) {

        }
        return null;
    }
    public static void main(String[] args) {
        String strUrl = "http://v.youku.com/player/getPlayList/VideoIDS/XNzg5Mjk1MzAw";
        String strJson = null;
        try {
            strJson = UrlConnection(strUrl);
        } catch (Exception e) {
        }
        if(strJson == null){
            return;
        }
        System.out.println(strJson);
        JSONObject jsobj =   JSONObject.parseObject(strJson);
        JSONArray jsonarr = jsobj.getJSONArray("data");//jsobj为获取的json
        JSONObject obj1 = jsonarr.getJSONObject(0);
        double seed = obj1.getDouble("seed");
        JSONObject obj2 = obj1.getJSONObject("streamfileids");
        String mp4id = obj2.getString("mp4");
        String realfileid = getFileID(mp4id, seed);
        String idLeft = realfileid.substring(0, 8);
        String idRight = realfileid.substring(10);
        JSONObject obj3 = obj1.getJSONObject("segs");
        JSONArray aaa = obj3.getJSONArray(sign);
        JSONObject o = aaa.getJSONObject(0);
        String k = o.getString("k");
        String seconds =k;
        int i = 0;
        String sid = getSid();
        String format = "mp4";
        String url = "http://k.youku.com/player/getFlvPath/sid/" + sid + "_"
                + "" + String.format("%1$02X", i) + "/st/"
                + "" + format + "/fileid/" + idLeft + String.format("%1$02X", i) + idRight + "?K="
                + "" + k+"&ts="+seconds;
        //System.out.println(k);
        System.out.println(url);
    }

}
