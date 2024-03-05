package com.kodnest.tunehub.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.Service.PlaylistService;
import com.kodnest.tunehub.entity.Playlist;
import com.kodnest.tunehub.repository.PlaylistRepository;

@Service
public class PlaylistServiceImpl implements PlaylistService{
	@Autowired
	PlaylistRepository playlistRepository;

	@Override
	public void addplaylist(Playlist playlist) {
		playlistRepository.save(playlist);
	}
	public List<Playlist> fetchPlaylist() {
		List<Playlist> playlists=playlistRepository.findAll();
		return playlists;
		}
//
//	@Override
//	public void updateplaylist(Playlist playlist) {
//		playlistRepository.save(playlist);
//	}

}
