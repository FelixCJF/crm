package com.itheima;

import java.util.ArrayList;
import java.util.List;

import com.itheima.crm.post.domain.CrmPost;

import net.sf.json.JSONArray;

public class TestJson {
	
	public static void main(String[] args) {
		
		CrmPost post = new CrmPost();
		post.setPostId("xxx");
		post.setPostName("yyy");
		
		List<CrmPost> allPost = new ArrayList<CrmPost>();
		allPost.add(post);
		
		String json = JSONArray.fromObject(allPost).toString();
		System.out.println(json);
		
	}

}
