package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.web.service.*;
import com.sist.web.vo.*;
import com.sist.web.entity.*;
@RestController
public class BusanFoodRestController {
   @Autowired
   private BusanFoodService bService;
   
   @GetMapping("/main_react")
   public Map main_data()
   {
	   Map map=new HashMap();
	   
	   return map;
   }
}
