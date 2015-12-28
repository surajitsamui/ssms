
package com.mycompany.ssms.config;

import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author srini
 */
@Configurable
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter{
   // @Autowired
    //private ApplicationInfoController applicationInfoController; // Used to provide version information on all JSP's.
    private List<HttpMessageConverter<?>> messageConverters; // Cached: this is not a bean.

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
 
        // Note: this overwrites the default message converters.
        converters.addAll(getMessageConverters());
    }
 
 
    /**
     * The message converters for the content types we support.
     *
     * @return the message converters; returns the same list on subsequent calls
     */
    private List<HttpMessageConverter<?>> getMessageConverters() {
 
        if (messageConverters == null) {
            messageConverters = new ArrayList<HttpMessageConverter<?>>();
            ObjectMapper o = new ObjectMapper();
            o.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);            
            MappingJacksonHttpMessageConverter mappingJacksonHttpMessageConverter = new MappingJacksonHttpMessageConverter();
            mappingJacksonHttpMessageConverter.setObjectMapper(o);            
            messageConverters.add(mappingJacksonHttpMessageConverter);
        }
        return messageConverters;
    }
 
 
    @Bean
    public MultipartResolver multipartResolver(){
        return new CommonsMultipartResolver();        
    }

 
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
 
        // Extra argument resolvers (the default ones are added as well).
        // user it to insert user object etc as arguments
        
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
        registry.addResourceHandler("/images/**").addResourceLocations("/resources/images/");
        registry.addResourceHandler("/scripts/**").addResourceLocations("/resources/scripts/");
    }
 
    

 
    @Bean
    public InternalResourceViewResolver viewResolver() {
 
        // Location of our JSP pages, and to expose the bean with version information
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setViewClass(JstlView.class);
        internalResourceViewResolver.setPrefix("/WEB-INF/views/");
        internalResourceViewResolver.setSuffix(".jsp");
      //  internalResourceViewResolver.setExposedContextBeanNames(new String[]{});
        return internalResourceViewResolver;
    }
 

   
}
