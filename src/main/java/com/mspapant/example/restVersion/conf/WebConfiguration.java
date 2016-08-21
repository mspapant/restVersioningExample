package com.mspapant.example.restVersion.conf;

import com.mspapant.example.restVersion.conf.mapping.VersionRequestMappingHandlerMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport {

    @Autowired
    private ContentNegotiationManager contentNegotiationManager;

    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        VersionRequestMappingHandlerMapping handlerMapping = new VersionRequestMappingHandlerMapping();
        handlerMapping.setOrder(0);
        handlerMapping.setRemoveSemicolonContent(false);
        handlerMapping.setContentNegotiationManager(contentNegotiationManager);

        return handlerMapping;
    }
}
