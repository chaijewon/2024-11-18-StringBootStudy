package com.sist.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.vo.FoodVO;
import com.sist.web.dao.*;

/*
 *                             | 제어 => 페이지 나누기 ... (데이터 변경이 필요)
 *     DAO(Repository) ======= Service ======= Controller
 *        |                                       |
 *      데이터베이스 연결                           클라이언트 요청한 데이터만 전송 
 */

@Service
public class FoodServiceImpl implements FoodService{

	@Autowired
	private FoodRepository fDao;
	@Override
	public List<FoodVO> foodMainData() {
		// TODO Auto-generated method stub
		return fDao.foodMainData();
	}

}
