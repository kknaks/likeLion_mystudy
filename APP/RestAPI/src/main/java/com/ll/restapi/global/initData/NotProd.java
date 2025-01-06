package com.ll.restapi.global.initData;

import com.ll.restapi.domain.service.ArticleService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.stream.IntStream;

@Configuration
@Profile("!prod")
public class NotProd {
  @Bean
  public ApplicationRunner initNotProd(ArticleService articleService){
    return args -> {
      IntStream.rangeClosed(1, 10).forEach(num -> {
        articleService.write("subject" + num, "content" + num);
      });
    };
  }
}
