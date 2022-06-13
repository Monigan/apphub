package ru.apphub.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableConfigurationProperties
@EnableAspectJAutoProxy
@EnableTransactionManagement
@EntityScan("ru.apphub.storage.model")
@EnableJpaRepositories(basePackages = {"ru.apphub.storage.repository"})
@SpringBootApplication
public class StorageApp {
  public static void main(final String[] args) {
    SpringApplication.run(StorageApp.class, args);
  }
}
