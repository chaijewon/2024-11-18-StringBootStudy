package com.sist.web.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.sist.web.entity.MemberEntity;
import com.sist.web.vo.CommentVO;

public interface CommentService {
	public int idCount(String id);
	public MemberEntity memberDetailData(String id);
	// comment => CRUD 
	public List<CommentVO> commentListData(int fno);
}
