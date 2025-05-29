package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sist.web.entity.*;
import com.sist.web.dao.*;

import java.text.SimpleDateFormat;
import java.util.*;
@RestController
// => Restful => GET(읽기) SELECT , POST(쓰기) INSERT , PUT(수정) UPDATE , DELETE(삭제)
@CrossOrigin(origins = "*") // 모든 port 허용 
// 1521 / 8080 => aws는 0~1023까지 port를 접근 거부 
public class BoardRestController {
   @Autowired
   private BoardRepository bDao;
   // http://localhost/board/list_react/${page}
   // ResponseEntity<Map> 
   @GetMapping("/board/list_react/{page}")
   public Map board_list(@PathVariable("page") int page)
   {
	   // 2025-05-21 00:00:00
	   Map map=new HashMap();
	   int rowSize=10;
	   int start=(page-1)*rowSize;
	   List<BoardEntity> list=bDao.boardListData(start);
	   for(BoardEntity vo:list)
	   {
		   String day=vo.getRegdate();
		   day=day.substring(0,day.indexOf(" "));
		   vo.setRegdate(day.trim());
	   }
	   int count=(int)bDao.count();
	   int totalpage=(int)(Math.ceil(count/(double)rowSize));
	   String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	   
	   map.put("today", today);
	   map.put("curpage",page);
	   map.put("totalpage", totalpage);
	   map.put("list", list);
	   
	   return map;
   }
   @PostMapping("/board/insert_react")
   public Map board_insert(@RequestBody BoardEntity vo)
   {
	   Map map=new HashMap();
	   try
	   {
	     vo.setHit(0);
	     BoardEntity _vo=bDao.save(vo);
	     map.put("vo", _vo);
	     map.put("msg", "yes");
	   }catch(Exception ex)
	   {
		   map.put("msg", ex.getMessage());
	   }
	   return map;
   }
   
   
}
