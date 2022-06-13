package ru.apphub.storage.service;

import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ValidationServiceImpl implements ValidationService {

  private WebClient webClient;

  @Autowired
  public ValidationServiceImpl(WebClient webClient) {
    this.webClient = webClient;
  }

  @Override
  public boolean isTokenValid(String token) {
    ResponseEntity<Boolean> response = webClient
        .get()
        .uri(token)
        .retrieve()
        .toEntity(Boolean.class)
        .doOnSuccess(apiResponse -> {
          log.debug("Request successfully send, status: {}", apiResponse.getStatusCode());
        })
        .doOnError(
            ex -> {
              log.error("Error happened while sending request. Error: {}, cause: {}",
                  ex.getMessage(), ex.getCause());
            })
        .onErrorResume(e -> Mono.empty())
        .block();
    return Objects.nonNull(response) && response.getStatusCode().equals(HttpStatus.OK) &&
        response.getBody();
  }
}
