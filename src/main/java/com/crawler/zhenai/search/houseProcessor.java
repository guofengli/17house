package com.crawler.zhenai.search;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public class houseProcessor
  implements PageProcessor
{

    private Site site = Site.me().setDomain("www.17house.com") .addStartUrl("http://bbs.17house.com/forum.php");

    public void process(Page page) {
    	String url = page.getUrl().get();
        List<String> links = page.getHtml().links().regex("http://bbs.17house.com/.*").all();
        page.addTargetRequests(links);
        if(url.matches("http://bbs.17house.com/home.php?mod=space&uid=[0-9]{5,}.*")||url.matches("http://bbs.17house.com/space-username-.*")) {
//        	System.out.println("path--->"+page.getHtml().xpath("/html/body/article[@class='myhome-wrap frameW clearfix']/section[@class='mod-brief-info mt20 bgff radius-3 bord']/div[@class='photo-album fl']/div[@class='u-ablums-player']/div[@id='AblumsPlayID']/div[@id='AblumsDisplayImgID']/img[@class='img']/@src").toString());
//            page.putField("head_img", page.getHtml().xpath("/html/body/section[@class='mod-top-ceiling bord ceiling-js hide']/div[@class='ceiling-box clearfix']/div[@class='ceiling-photo fl']/a/img/@src").toString());
           System.out.println(url);
            Pattern pattern = Pattern.compile("[0-9]{5,}");
            Matcher matcher = pattern.matcher(url);
            String  uid = null;
            if(matcher.find()){
            	uid = matcher.group();
            }
            page.putField("uid", uid);
//            System.out.println(url);
        }
    }
    public Site getSite() {
        return site;

    }

}
