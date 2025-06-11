package com.sist.web.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.entity.*;
import com.sist.web.service.*;
@RestController
@CrossOrigin(origins = "*")
public class CommentRestController {
   @Autowired
   private CommentService cService;
   
   @GetMapping("/member/login/{id}/{pwd}")
   public ResponseEntity<Map> memberLogin(@PathVariable("id") String id,
		   @PathVariable("pwd") String pwd)
   {
	   Map map=new HashMap();
	   try
	   {
		   // id존재여부 확인 
		   int count=cService.idCount(id);
		   if(count==0) //id가 없는 경우
		   {
			   map.put("msg", "NOID");
		   }
		   else // id가 있는 경우 
		   {
			   MemberEntity vo=cService.memberDetailData(id);
			   if(pwd.equals(vo.getPwd())) // login
			   {
				   map.put("msg", "OK");
				   map.put("name", vo.getName());
				   map.put("id", vo.getId());
			   }
			   else
			   {
				   map.put("msg", "NOPWD");
			   }
		   }
	   }catch(Exception ex)
	   {
		   return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		                                    // 500
	   }
	   return new ResponseEntity<>(map,HttpStatus.OK);
	                                        // 200
   }
   // 댓글 작업 
   // => 글쓰기 / 수정하기 / 삭제하기 / 목록 
   //    -----  -------> JQuery 
}
