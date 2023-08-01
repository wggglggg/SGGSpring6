package com.sgg.spring6.validator.two.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * ClassName: ValidationConfig
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/1 10:09
 * @Version 1.0
 */
@ComponentScan("com.sgg.spring6.validator.two")
@Configuration
public class ValidationConfig {

    @Bean
    public LocalValidatorFactoryBean validator(){
        return new LocalValidatorFactoryBean();
    }
}
