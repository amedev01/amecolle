package jp.co.amedev.amecolle.config;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
	}

	@Override
	protected void registerContextLoaderListener(ServletContext servletContext) {
		super.registerContextLoaderListener(servletContext);
	}

	@Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {ApplicationConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected Filter[] getServletFilters() {
        DelegatingFilterProxy securityFilterChain = new DelegatingFilterProxy("springSecurityFilterChain");
        return new Filter[] {/*securityFilterChain*/};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setInitParameter("defaultHtmlEscape", "true");
        registration.setInitParameter("spring.profiles.active", "default");
    }
}