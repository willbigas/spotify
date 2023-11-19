package br.com.willbigas.spotify.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class SpotifyConfigMap {

	@Value("${spotify-client-credentials}")
	public String spotifyClientCredentials;

	@Value("${spotify-client-id}")
	public String spotifyClientId;

	@Value("${spotify-client-secret}")
	public String spotifyClientSecret;

}
