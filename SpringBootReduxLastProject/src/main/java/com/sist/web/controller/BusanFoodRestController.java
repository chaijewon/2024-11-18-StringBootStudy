package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.web.service.*;
import com.sist.web.vo.*;
import com.sist.web.entity.*;
@RestController
@CrossOrigin(origins = "*")
public class BusanFoodRestController {
   @Autowired
   private BusanFoodService bService;
   
   @GetMapping("/main_react")
   public Map main_data()
   {
	   Map map=new HashMap();
	   List<BusanFoodVO> list=bService.busanMainData();
	   BusanFoodVO vo=list.get(0);
	   List<BusanFoodVO> mList=new ArrayList<BusanFoodVO>();
	   List<BusanFoodVO> lList=new ArrayList<BusanFoodVO>();
	   for(int i=1;i<=4;i++)
	   {
		   mList.add(list.get(i));
	   }
	   for(int i=5;i<list.size();i++)
	   {
		   lList.add(list.get(i));
	   }
	   
	   List<BusanInfoEntity> iList=bService.busanInfoMainData();
	   
	   map.put("mp", vo);
	   map.put("mList", mList);
	   map.put("lList", lList);
	   map.put("iList", iList);
	   
	   return map;
   }
}
