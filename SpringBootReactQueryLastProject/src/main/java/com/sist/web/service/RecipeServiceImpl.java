package com.sist.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.vo.RecipeVO;
import com.sist.web.dao.*;
@Service
public class RecipeServiceImpl implements RecipeService{

	@Autowired
	private RecipeRepository rDao;
	@Override
	public List<RecipeVO> recipeMainData() {
		// TODO Auto-generated method stub
		return rDao.recipeMainData();
	}

}
