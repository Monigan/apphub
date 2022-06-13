package ru.apphub.storage.service;

public interface ValidationService {

  /**
   * Обращается к webchat сервису, и проверяет, актуален ли токен
   *
   * @param token токен
   * @return true - если актуален, иначе - false
   */
  boolean isTokenValid(String token);
}
