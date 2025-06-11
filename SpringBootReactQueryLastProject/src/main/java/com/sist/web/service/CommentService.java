package com.sist.web.service;

import org.springframework.data.repository.query.Param;

import com.sist.web.entity.MemberEntity;

public interface CommentService {
	public int idCount(String id);
	public MemberEntity memberDetailData(String id);
	// comment => CRUD 
}
