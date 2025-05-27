package com.sist.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.dao.BusanFoodRepository;
import com.sist.web.dao.BusanInfoRepository;
import com.sist.web.entity.BusanInfoEntity;
import com.sist.web.vo.BusanFoodVO;

@Service
public class BuasnFoodServiceImpl implements BusanFoodService{
    @Autowired
    private BusanFoodRepository bDao;
    
    @Autowired
    private BusanInfoRepository iDao;
    
	@Override
	public List<BusanFoodVO> busanMainData() {
		// TODO Auto-generated method stub
		List<BusanFoodVO> list=bDao.busanMainData();
		return list;
	}
	@Override
	public List<BusanInfoEntity> busanInfoMainData() {
		// TODO Auto-generated method stub
		return iDao.busanInfoMainData();
	}

}
