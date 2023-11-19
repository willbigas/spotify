package br.com.willbigas.spotify.service;

import br.com.willbigas.spotify.client.AuthSpotifyClient;
import br.com.willbigas.spotify.client.dto.login.LoginRequest;
import br.com.willbigas.spotify.config.SpotifyConfigMap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

	private final AuthSpotifyClient authSpotifyClient;
	private final SpotifyConfigMap configMap;

	public String getBearerAuthorizationToken() {
		return "Bearer " + getAuthorizationToken();
	}

	private String getAuthorizationToken() {
		return authSpotifyClient.login(createAlbumRequestDTO()).getAccessToken();
	}

	private LoginRequest createAlbumRequestDTO() {
		return new LoginRequest(
				configMap.getSpotifyClientCredentials(),
				configMap.spotifyClientId,
				configMap.getSpotifyClientSecret()
		);
	}
}
