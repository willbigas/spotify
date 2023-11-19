package br.com.willbigas.spotify.service;

import br.com.willbigas.spotify.client.AlbumSpotifyClient;
import br.com.willbigas.spotify.client.dto.album.Album;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumService {

	private final AlbumSpotifyClient albumSpotifyClient;
	private final LoginService loginService;

	public List<Album> getAlbums() {
		var response = albumSpotifyClient.getReleases(this.loginService.getBearerAuthorizationToken());
		return response.getAlbums().getItems();
	}
}
