package com.kodnest.tunehub.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.tunehub.Service.PlaylistService;
import com.kodnest.tunehub.Service.SongService;
import com.kodnest.tunehub.entity.Playlist;
import com.kodnest.tunehub.entity.Song;


@Controller
public class PlaylistController {
	@Autowired
	SongService songService;
	@Autowired
	PlaylistService playlistService;

	@GetMapping("/createplaylists")
	public String createPlaylists(Model model) {
		List<Song> songList=songService.fetchAllSongs();
		model.addAttribute("songs", songList);
		return "createplaylists";
	}
	
	@PostMapping("/addplaylist")
	public String addplaylist(@ModelAttribute Playlist playlist) {
		//updating the playlisttable
		playlistService.addplaylist(playlist);
		
		//updating the song table
		List<Song> songList=playlist.getSongs();
		for(Song s:songList)
		{
			s.getPlaylists().add(playlist);
			songService.updateSong(s);
		}
		return "AdminHome";
	}
//	@PostMapping("/addplaylist")
//	public String updateplaylist(@ModelAttribute Playlist playlist) {
//		//updating the playlisttable
//		playlistService.updateplaylist(playlist);
//		
//		//updating the song table
//		List<Song> songList=playlist.getSongs();
//		for(Song s:songList)
//		{
//			s.getPlaylists().add(playlist);
//		}
//		return "AdminHome";
//	}
	
	@GetMapping("/viewplaylists")
	public String viewplaylists(Model model) {
		List<Playlist> playList=playlistService.fetchPlaylist();
		model.addAttribute("playlist", playList);
		return "viewplaylists";
	}

}
