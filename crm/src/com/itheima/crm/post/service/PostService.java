package com.itheima.crm.post.service;

import java.util.List;

import com.itheima.crm.post.domain.CrmPost;

public interface PostService {

	/**
	 * 通过id查询职务
	 * @param depId
	 * @return
	 */
	public List<CrmPost> findAll(String depId);
}
