package com.kodnest.tunehub.Service;

import java.util.List;

import com.kodnest.tunehub.entity.Playlist;

public interface PlaylistService {

	public void addplaylist(Playlist playlist);

	public List<Playlist> fetchPlaylist();

//	public void updateplaylist(Playlist playlist);

}
