package com.sist.web.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.sist.web.entity.RecipeEntity;
import com.sist.web.entity.RecipeVO;
// cookie / session 
public interface RecipeService {
	public List<RecipeVO> recipeListData(int start,int end);
    public RecipeEntity recipeDetailData(int no);
    public int recipeTotalPage();
}
