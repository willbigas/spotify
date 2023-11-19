package br.com.willbigas.spotify.controller;

import br.com.willbigas.spotify.controller.client.AlbumSpotifyClient;
import br.com.willbigas.spotify.controller.client.AuthSpotifyClient;
import br.com.willbigas.spotify.controller.client.GoogleClient;
import br.com.willbigas.spotify.controller.client.dto.Album;
import br.com.willbigas.spotify.controller.client.dto.AlbumResponse;
import br.com.willbigas.spotify.controller.client.dto.LoginRequest;
import br.com.willbigas.spotify.controller.client.dto.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spotify/api")
@RequiredArgsConstructor
public class AlbumController {

	private final AuthSpotifyClient authSpotifyClient;
	private final AlbumSpotifyClient albumSpotifyClient;

	@GetMapping("/albums")
	public ResponseEntity<List<Album>> helloWorld() {

		var request = new LoginRequest(
				"client_credentials",
				"76c50972acdd4be99f03fce54a7523a2",
				"83ba9fa2d49b4e5e998138b6c16d0947"
		);

		String accessToken = authSpotifyClient.login(request).getAccessToken();

		var response = albumSpotifyClient.getReleases("Bearer " + accessToken);

		return ResponseEntity.ok(response.getAlbums().getItems());
	}
}
