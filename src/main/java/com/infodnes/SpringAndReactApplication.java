package com.infodnes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

@EnableCaching
@EnableScheduling
@EnableJpaRepositories
@SpringBootApplication
@EnableAutoConfiguration
public class SpringAndReactApplication {

  @Value("${rest.api.base.path}")
  private String restApiBasePath;
  @Value("${cors.allowed.origins}")
  private String[] corsAllowedOrigins;

  public static void main(String[] args) {
    SpringApplication.run(SpringAndReactApplication.class, args);
  }

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("*").allowedOrigins(corsAllowedOrigins);
      }
    };
  }

  @Bean
  public WebMvcRegistrations webMvcRegistrationsHandlerMapping() {
    SpringAndReactApplication application = this;
    return new WebMvcRegistrations() {
      @Override
      public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new RequestMappingHandlerMapping() {

          @Override
          protected void registerHandlerMethod(Object handler, Method method, RequestMappingInfo mapping) {
            Class<?> beanType = method.getDeclaringClass();
            RestController restApiController = beanType.getAnnotation(RestController.class);
            if (restApiController != null) {
              PatternsRequestCondition apiPattern = new PatternsRequestCondition(application.restApiBasePath).combine(mapping.getPatternsCondition());

              mapping = new RequestMappingInfo(mapping.getName(), apiPattern, mapping.getMethodsCondition(), mapping.getParamsCondition(),
                  mapping.getHeadersCondition(), mapping.getConsumesCondition(), mapping.getProducesCondition(), mapping.getCustomCondition());
            }

            super.registerHandlerMethod(handler, method, mapping);
          }
        };
      }
    };
  }
}
