package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import com.sist.web.dao.*;
import com.sist.web.vo.*;
@Controller
public class EmpController {
  @Autowired
  private EmpRepository eDao;
  
  @GetMapping("/emp/list")
  public String emp_list(Model model)
  {
	  //List<Emp> list=eDao.empAllData();
	  List<Emp> list=eDao.findAll(Sort.by(Sort.Direction.DESC,"sal"));
	  // Page<Emp> => 페이지를 나눠서 처리 
	  // 사용자 정의 @Query
	  model.addAttribute("list", list);
	  return "emp/list";
  }
  @GetMapping("/emp/detail")
  public String emp_detail(@RequestParam("empno") int empno,Model model)
  {
	  Emp emp=eDao.findByEmpno(empno);
	  model.addAttribute("vo", emp);
	  return "emp/detail";
  }
}
