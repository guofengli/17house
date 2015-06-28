package com.crawler.zhenai.search;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
//佳缘搜索接口获取数据
public class MySpider {
    public static void main(String[] args) {
//    	C3p0Plugin c3p0Plugin = new C3p0Plugin("jdbc:mysql://172.16.254.100:3306/netspider?characterEncoding=utf-8&useUnicode=true&", "sa", "abc/123");
//        c3p0Plugin.start();
//        ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(c3p0Plugin);
//        activeRecordPlugin.addMapping("zhenai","uid", User.class);
//        activeRecordPlugin.start();
//        Request request = new Request("http://www.youyuan.com/lover/");
//        request.setMethod(HttpConstant.Method.POST);
        Spider mySpider = Spider.create(new houseProcessor());
        mySpider.addPipeline(new ConsolePipeline()).thread(10).run();;
    }
}
