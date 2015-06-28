package com.crawler.zhenai.search.pipeline;

import java.util.HashMap;
import java.util.Map;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class MyPipeline implements Pipeline{

	public void process(ResultItems resultItems, Task task) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap();
  	  	for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            if (entry.getValue() instanceof String) {
          	  String value = (String) entry.getValue();
                String key=(String) entry.getKey();
                map.put(key, value);
            } else {
              //logger.info(entry.getKey()+"�����ַ���");
            }
        }
  	  Object uid = map.get("uid");
	  	  if(uid != null){
	  		new User().setAttrs(map).save();
	  	  }
//  	  	new User().setAttrs(map).save();
//  	  ((User)new User().setAttrs(map)).update();
//      this.logger.info("�Ѹ��£�" + map.get("uid"));
	}

}
