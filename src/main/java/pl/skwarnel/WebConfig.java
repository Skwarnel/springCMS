package pl.skwarnel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
//import pl.coderslab.springhibernate.converter.AuthorConverter;
//import pl.coderslab.springhibernate.converter.PublisherConverter;

import java.util.Locale;

@Configuration
public class WebConfig implements WebMvcConfigurer {

//    private final PublisherConverter publisherConverter;
//    private final AuthorConverter authorConverter;

//    public WebConfig(PublisherConverter publisherConverter, AuthorConverter authorConverter) {
//        this.publisherConverter = publisherConverter;
//        this.authorConverter = authorConverter;
//    }

    @Bean
    public LocaleContextResolver localeResolver() {
        SessionLocaleResolver resolver = new SessionLocaleResolver();
        resolver.setDefaultLocale(Locale.forLanguageTag("pl"));
        return resolver;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
//        /WEB-INF/views//create-person.jsp
    }

//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(publisherConverter);
//    }
}