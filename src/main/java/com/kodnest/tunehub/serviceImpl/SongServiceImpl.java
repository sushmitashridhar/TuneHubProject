package com.kodnest.tunehub.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.Service.SongService;
import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.repository.SongRepository; 
 
@Service 

public class SongServiceImpl  implements SongService{ 
	 @Autowired 
	 SongRepository songRepository; 
	  
	 @Override 
	 public String addSong(Song song) { 
	  songRepository.save(song); 
	  return "song Added"; 
	   
	 } 
	 @Override
	 public boolean nameExists(String name) { 
	  if(songRepository.findByName(name)!=null) { 
	   return true; 
	  }else { 
	   return false; 
	  } 
	 } 
	 @Override
	 public List<Song> fetchAllSongs()
	 {
		 List<Song> songs=songRepository.findAll();
		 return songs;
	 }
	@Override
	public List<Song> fetchAllPlaylist() {
		List<Song> songs=songRepository.findAll();
		return songs;
	}
	@Override
	public void updateSong(Song s) {
		songRepository.save(s);
		
	}
	}

