package com.sist.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.repository.query.Param;

import com.sist.web.vo.RecipeVO;

public interface RecipeService {
	public List<RecipeVO> recipeMainData();
	public Map recipeListData(int page);
}
