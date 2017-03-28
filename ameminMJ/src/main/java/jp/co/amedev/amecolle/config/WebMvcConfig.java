package jp.co.amedev.amecolle.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.annotation.Order;
import org.springframework.security.web.servlet.support.csrf.CsrfRequestDataValueProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.terasoluna.gfw.web.mvc.support.CompositeRequestDataValueProcessor;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenRequestDataValueProcessor;


@Configuration
class WebMvcConfig extends WebMvcConfigurationSupport {

	private static final String MESSAGE_SOURCE = "/WEB-INF/i18n/messages";
	private static final String VIEWS = "/WEB-INF/view/";

	private static final String IMAGES_LOCATION = "/images/";
	private static final String IMAGES_HANDLER = IMAGES_LOCATION + "**";

	private static final String JAVA_SCRIPT_LOCATION = "/js/";
	private static final String JAVA_SCRIPT_HANDLER = JAVA_SCRIPT_LOCATION + "**";

	private static final String CSS_LOCATION = "/css/";
	private static final String CSS_HANDLER = CSS_LOCATION + "**";


//	@Override
//	protected void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/").setViewName("index");
//	}

	@Override
	protected void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp().prefix(VIEWS).suffix(".jsp");
	}

	@Override
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
		RequestMappingHandlerMapping requestMappingHandlerMapping = super.requestMappingHandlerMapping();
		requestMappingHandlerMapping.setUseSuffixPatternMatch(false);
		requestMappingHandlerMapping.setUseTrailingSlashMatch(false);
		return requestMappingHandlerMapping;
	}

//	@Bean(name = "messageSource")
//	public MessageSource messageSource() {
//		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//		messageSource.setBasename(MESSAGE_SOURCE + "/ApplicationResources");
//		messageSource.setDefaultEncoding("MS932");
//		messageSource.setCacheSeconds(5);
//		return messageSource;
//	}

//	@Override
//	public Validator getValidator() {
//		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
//		validator.setValidationMessageSource(messageSource());
//		return validator;
//	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(IMAGES_HANDLER, JAVA_SCRIPT_HANDLER, CSS_HANDLER).addResourceLocations(IMAGES_LOCATION, JAVA_SCRIPT_LOCATION, CSS_LOCATION);
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/**
	 * Handles favicon.ico requests assuring no <code>404 Not Found</code> error
	 * is returned.
	 */
	@Controller
	static class FaviconController {
		@RequestMapping("favicon.ico")
		String favicon() {
			return "forward:/resources/images/favicon.ico";
		}
	}
}
