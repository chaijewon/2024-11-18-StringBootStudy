package com.sist.web.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sist.web.dao.*;
import com.sist.web.vo.*;
import java.util.*;
@Service
public class MusicService {
   @Autowired
   private MusicRepository mRepository;
   
   public void saveMusic(Music music)
   {
	   mRepository.save(music);
   }
   public Iterable<Music> getAllMusics()
   {
	   return mRepository.findAll();
   }
   public Music getMusicId(String id)
   {
	   return mRepository.findById(id).orElse(null);
   }
   public List<Music> musicFindData(String title)
   {
	   List<Music> list=new ArrayList<Music>();
	   return list;
   }
}
