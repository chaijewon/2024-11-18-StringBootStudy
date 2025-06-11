package com.sist.web.entity;
/*
 *   NO      NOT NULL NUMBER         
FNO              NUMBER         
ID               VARCHAR2(20)   
NAME    NOT NULL VARCHAR2(50)   
MSG     NOT NULL VARCHAR2(4000) 
REGDATE          DATE 
 */
import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Entity(name="reactcomment")
@Data
public class CommentEntity {
  @Id
  private int no;
  private int fno;
  private String id,name,msg;
  private Date regdate;
}
