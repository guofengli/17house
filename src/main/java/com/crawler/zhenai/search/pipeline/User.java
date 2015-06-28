package com.crawler.zhenai.search.pipeline;


import com.jfinal.plugin.activerecord.Model;

public class User  extends Model<User> { 
	public static final User me = new User();
}
