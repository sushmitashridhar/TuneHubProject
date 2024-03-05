package com.kodnest.tunehub.Service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.Song; 

 
@Service 

public interface SongService {
	
	 
	 public String addSong(Song song); 
	 
	 public boolean nameExists(String name);

	public List<Song> fetchAllSongs();

	public List<Song> fetchAllPlaylist();

	public void updateSong(Song s);

	 
	 
	}
