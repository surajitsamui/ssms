package com.mycompany.ssms.config;

import java.io.IOException;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 *
 * @author srini
 */
@Configuration
@ComponentScan(basePackages = "com.mycompany.ssms", excludeFilters = {
    @ComponentScan.Filter(Configuration.class)})
@Import({DataConfig.class, MvcConfig.class})
// uncomment if required
//@ImportResource("classpath:properties-config.xml")
public class AppConfig {

    // uncomment if required
    //@Bean
    public PropertyPlaceholderConfigurer propertyConfigurer() throws IOException {
        PropertyPlaceholderConfigurer props = new PropertyPlaceholderConfigurer();
        props.setLocations(new Resource[]{new ClassPathResource("instance.properties")});
        return props;
    }
}
