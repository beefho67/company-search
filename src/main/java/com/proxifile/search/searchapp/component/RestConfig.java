package com.proxifile.search.searchapp.component;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.proxifile.search.searchapp.entity.Creditor;

@Component
public class RestConfig implements RepositoryRestConfigurer {

	@Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Creditor.class);
    }
}
