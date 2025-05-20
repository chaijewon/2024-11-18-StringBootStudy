package com.sist.web.sevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.client.elc.NativeQueryBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHitSupport;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.SearchPage;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilterBuilder;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.stereotype.Service;

import com.sist.web.dao.*;
import com.sist.web.vo.*;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;

import java.util.*;
import java.util.stream.Collectors;
@Service
public class MusicService {
   @Autowired
   private MusicRepository mRepository;
   
   @Autowired
   private ElasticsearchClient esClient;
   
   public void saveMusic(Music music)
   {
	   mRepository.save(music);
   }
   // 페이지를 나눠서 처리 
   public List<Music> getAllMusics(int page)
   {
	   int rowSize=12;
	   // 페이지 나누기 
	   Pageable pg=PageRequest.of(page-1,rowSize);
	   // 나눈 페이지 읽기 
	   Page<Music> pList=mRepository.findAll(pg);
	   List<Music> list=new ArrayList<Music>();
	   // List로 변환 
	   if(pList!=null && pList.hasContent())
	   {
		   list=pList.getContent();
	   }
	   return list;
   }
   public int getTotalPage()
   {
	   int count=(int)mRepository.count();// SELECT COUNT(*) FROM music 
	   int totalpage=(int)(Math.ceil(count/12.0));
	   return totalpage;
   }
   public Music getMusicId(String id)
   {
	   return mRepository.findById(id).orElse(null);
   }
   public List<Music> getMusicFind(String title)
   {
	   return mRepository.findByTitleContaining(title);
   }
   public List<Music> search(String title)
   {


	   List<Music> list=new ArrayList<Music>();
	   try
	   {
		   Query byName = MatchQuery.of(m -> m
				    .field("title")
				    .query(title)
				)._toQuery();
		   SearchResponse<Music> response = esClient.search(s -> s
				    .index("music")
				    .query(q -> q
				        .bool(b -> b
				            .must(byName)
				            
				        )
				    ),
				    Music.class
				);

				List<Hit<Music>> hits = response.hits().hits();
				for (Hit<Music> hit: hits) {
				    Music music = hit.source();
				    System.out.println("Find Title " + music.getTitle());
				}
	   }catch (Exception e) {
		// TODO: handle exception
		   System.out.println(e.getMessage());
	   }
	   return list;
   }
}
