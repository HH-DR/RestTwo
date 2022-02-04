package de.reipka.resttwo.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class AppConfiguration {

    Logger logger = LoggerFactory.getLogger(AppConfiguration.class);

    // 2 Beans from original code example
//    @Bean
//    public MessageSource messageSource() {
//        ReloadableResourceBundleMessageSource messageSource
//                = new ReloadableResourceBundleMessageSource();
//
//        messageSource.setBasename("classpath:messages");
//        messageSource.setDefaultEncoding("UTF-8");
//        return messageSource;
//    }
//
//    @Bean
//    public LocalValidatorFactoryBean validator(MessageSource messageSource) {
//        LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
//        validatorFactoryBean.setValidationMessageSource(messageSource);
//        return validatorFactoryBean;
//    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:messages");
        logger.info(messageSource.getBasenameSet().toString());
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }


}
