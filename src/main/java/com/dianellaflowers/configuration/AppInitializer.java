package com.dianellaflowers.configuration;

import com.dianellaflowers.configuration.security.SessionListner;
import com.dianellaflowers.utilities.Utilities;
import java.io.File;
import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new HiddenHttpMethodFilter(), new MultipartFilter()};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
//
//        // upload temp file will put here
//        File uploadDirectory = new File(Utilities.getCatalinaHome() + "/work/DianellaFlowers");
//        int maxUploadSizeInMb = 999999999;
//
//        // register a MultipartConfigElement
//        MultipartConfigElement multipartConfigElement
//                = new MultipartConfigElement(uploadDirectory.getAbsolutePath(),
//                        maxUploadSizeInMb, maxUploadSizeInMb * 2, maxUploadSizeInMb / 2);
//
//        registration.setMultipartConfig(multipartConfigElement);
        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");

    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        servletContext.addListener(new SessionListner());
    }

}
