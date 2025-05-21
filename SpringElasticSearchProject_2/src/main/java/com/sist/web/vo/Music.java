package com.sist.web.vo;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Document(indexName = "music")
@Getter
@Setter
public class Music {
   @Id
   private String id;
   @Field(name = "title", type = FieldType.Text)
   private String title;
   @Field(name = "singer", type = FieldType.Text)
   private String singer;
   @Field(name = "album", type = FieldType.Text)
   private String album;
   @Field(name = "poster", type = FieldType.Text)
   private String poster;
   @Field(name = "state", type = FieldType.Text)
   private String state;
   @Field(name = "idcrement", type = FieldType.Integer)
   private Integer idcrement;
}
