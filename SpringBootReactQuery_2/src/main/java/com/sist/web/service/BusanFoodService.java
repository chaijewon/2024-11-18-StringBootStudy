package com.sist.web.service;

import java.util.*;

import org.springframework.data.repository.query.Param;

import com.sist.web.entity.BusanFoodEntity;
import com.sist.web.entity.BusanFoodVO;

public interface BusanFoodService {
	public Map busanFoodListData(int page);
    public BusanFoodEntity busanFoodDetailData(int fno);
    public int busanFoodTotalPage();
}
