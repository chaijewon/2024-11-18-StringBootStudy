package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.FoodEntity;
import java.util.*;
import com.sist.web.vo.*;
/*
 *    public int getFno();
   public String getName();
   public String getType();
   public String getContent();
   public String getAddress();
   public int getHit();
   public int getLikecount();
   public String getPhone();
   public int getNum();
   public String getPoster();
 */
@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Integer>{
   @Query(value="SELECT fno,name,type,poster,phone,rownum "
		 +"FROM (SELECT fno,name,type,poster,phone FROM project_food ORDER BY fno) "
		 +"WHERE rownum<=10",nativeQuery = true)
   public List<FoodVO> foodMainData();
}
