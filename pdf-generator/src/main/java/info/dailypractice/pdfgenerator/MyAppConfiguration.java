package info.dailypractice.pdfgenerator;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@AutoConfiguration
public class MyAppConfiguration {

    @Bean
    @ConditionalOnMissingBean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ObjectMapper getObejectMapper() {
       return new ObjectMapper();
    }

    @Bean
    @ConditionalOnMissingBean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public PageConfigurationProvider pageConfigurationProvider() {
        return new PageConfigurationProvider();
    }

    @Bean
    @ConditionalOnMissingBean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public BookConfigurationProvider bookConfigurationProvider() {
        return new BookConfigurationProvider();
    }

}
