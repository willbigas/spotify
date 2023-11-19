package br.com.willbigas.spotify.controller;

import br.com.willbigas.spotify.client.dto.album.Album;
import br.com.willbigas.spotify.service.AlbumService;
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

	private final AlbumService albumService;

	@GetMapping("/albums")
	public ResponseEntity<List<Album>> helloWorld() {
		return ResponseEntity.ok(albumService.getAlbums());
	}
}
