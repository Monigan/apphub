package ru.apphub.storage.configuration;

import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Component
@ConfigurationProperties(prefix = "application.storage", ignoreUnknownFields = false)
public class ApplicationProperties {

  private MimeTypesFilter mimeTypesFilter;
  private String webChatUrl;
  private boolean securedViaToken;

  @Data
  public static class MimeTypesFilter {
    private List<String> allowed;
  }
}
