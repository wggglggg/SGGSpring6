package com.sgg.spring6.validator.four.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * ClassName: ValidationConfig
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/1 13:58
 * @Version 1.0
 */
@Configuration
@ComponentScan("com.sgg.spring6.validator.four")
public class ValidationConfig {

    @Bean
    public MethodValidationPostProcessor validationPostProcessor(){
        return new MethodValidationPostProcessor();
    }
}
