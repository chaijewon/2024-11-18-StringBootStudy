package com.sist.web.service;

import java.util.*;

import org.springframework.data.repository.query.Param;

import com.sist.web.vo.FoodListVO;
import com.sist.web.vo.FoodVO;

public interface FoodService {
	public List<FoodVO> foodMainData();
	public Map foodListData(int page);
}
