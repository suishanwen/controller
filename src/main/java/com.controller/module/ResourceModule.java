package com.controller.module;


import com.controller.CorsFilter;
import com.controller.api.BlackListResource;
import com.controller.api.LinkLogResource;
import com.controller.domain.entity.BlackList;
import com.controller.domain.facade.BaseFacade;
import com.controller.domain.facade.BlackListFacade;
import com.controller.domain.facade.LinkLogFacade;
import com.google.inject.Singleton;
import com.google.inject.servlet.GuiceFilter;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

import java.util.HashMap;
import java.util.Map;

import static com.sun.jersey.api.core.PackagesResourceConfig.PROPERTY_PACKAGES;

public class ResourceModule extends JerseyServletModule {
    @Override
    protected void configureServlets() {

        bind(GuiceContainer.class);
        binder().requireExplicitBindings();
        bind(GuiceFilter.class);
        bind(InvalidRequestServlet.class);
        bind(LinkLogFacade.class);
        bind(BlackListFacade.class);
        install(new DbModule());
        bind(LinkLogResource.class);
        bind(BlackListResource.class);
        bind(CorsFilter.class).in(Singleton.class);
        Map<String, String> params = new HashMap<String, String>();
        params.put(PROPERTY_PACKAGES, "com.controller.api.*");
        filter("/api/*").through(CorsFilter.class);
        serve("/api/*").with(GuiceContainer.class, params);
    }
}
