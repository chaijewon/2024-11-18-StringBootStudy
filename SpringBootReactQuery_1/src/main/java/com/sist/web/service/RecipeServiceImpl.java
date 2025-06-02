package com.sist.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.entity.RecipeEntity;
import com.sist.web.entity.RecipeVO;
import com.sist.web.dao.*;

@Service
public class RecipeServiceImpl implements RecipeService{
    @Autowired
    private RecipeRepository rDao;
    
	@Override
	public List<RecipeVO> recipeListData(int start, int end) {
		// TODO Auto-generated method stub
		return rDao.recipeListData(start,end);
	}

	@Override
	public RecipeEntity recipeDetailData(int no) {
		// TODO Auto-generated method stub
		return rDao.findByNo(no);
	}

	@Override
	public int recipeTotalPage() {
		// TODO Auto-generated method stub
		return rDao.recipeTotalPage();
	}

}
