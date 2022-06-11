package priscila.api.priscila.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigWeb implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("forward:/login.html");
        registry.addViewController("/cadastro").setViewName("forward:/cadastro.html");

        registry.addViewController("/home").setViewName("forward:/home.html");
    }

}
