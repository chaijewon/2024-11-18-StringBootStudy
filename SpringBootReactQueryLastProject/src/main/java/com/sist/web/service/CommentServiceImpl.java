package com.sist.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.sist.web.entity.MemberEntity;
import com.sist.web.dao.*;
// DAO VS Service : 
@Service
public class CommentServiceImpl implements CommentService{
    
	@Autowired 
	private MemberRepository mDao;
	
	// => id 존재여부 확인 
	@Override
	public int idCount(String id) {
		// TODO Auto-generated method stub
		return mDao.idCount(id);
	}
    // => 비밀번호 =>  데이터 전송 => react 
	@Override
	public MemberEntity memberDetailData(String id) {
		// TODO Auto-generated method stub
		return mDao.memberDetailData(id);
	}
	
	
}
