package com.mspapant.example.restVersion.conf.mapping;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class VersionRequestMappingHandlerMapping extends RequestMappingHandlerMapping {

    @Value("${server.apiContext}")
    private String apiContext;

    @Value("${server.versionContext}")
    private String versionContext;

    @Override
    protected HandlerMethod lookupHandlerMethod(String lookupPath, HttpServletRequest request) throws Exception {
        HandlerMethod method = super.lookupHandlerMethod(lookupPath, request);
        if (method == null && lookupPath.contains(getApiAndVersionContext())) {
            String afterAPIURL = lookupPath.substring(lookupPath.indexOf(getApiAndVersionContext()) + getApiAndVersionContext().length());
            String version = afterAPIURL.substring(0, afterAPIURL.indexOf("/"));
            String path = afterAPIURL.substring(version.length() + 1);

            int previousVersion = getPreviousVersion(version);
            if (previousVersion != 0) {
                lookupPath = getApiAndVersionContext() + previousVersion + "/" + path;
                final String lookupFinal = lookupPath;
                return lookupHandlerMethod(lookupPath, new HttpServletRequestWrapper(request) {
                    @Override
                    public String getRequestURI() {
                        return lookupFinal;
                    }

                    @Override
                    public String getServletPath() {
                        return lookupFinal;
                    }});
            }
        }
        return method;
    }

    private String getApiAndVersionContext() {
        return "/" + apiContext + "/" + versionContext;
    }

    private int getPreviousVersion(final String version) {
        return new Integer(version) - 1 ;
    }
}