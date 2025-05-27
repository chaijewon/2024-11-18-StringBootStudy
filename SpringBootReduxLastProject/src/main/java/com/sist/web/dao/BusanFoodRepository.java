package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.BusanFoodEntity;
import com.sist.web.vo.BusanFoodVO;

import java.util.*;
/*
 *   public int getNo();
   public String getPoster();
   public String getName();
   public int getHit();
   public int getJjimcount();
   public int getLikecount();
   public double getScore();
   public String getType();
 */
@Repository
public interface BusanFoodRepository extends JpaRepository<BusanFoodEntity, Integer>{
    @Query("SELECT no,poster,name,hit,jjimcount,likecount,score,type "
    	  +"FROM busan_food ORDER BY no ASC "
    	  +"LIMIT 0,9")
    public List<BusanFoodVO> busanMainData();
}
