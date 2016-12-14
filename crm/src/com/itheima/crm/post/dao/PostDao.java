package com.itheima.crm.post.dao;

import java.util.List;

import com.itheima.crm.post.domain.CrmPost;

public interface PostDao {
	
	/**
	 * 通过部门id查询所有的职务
	 * @param depId
	 * @return
	 */
	public List<CrmPost> findAll(String depId);

}
