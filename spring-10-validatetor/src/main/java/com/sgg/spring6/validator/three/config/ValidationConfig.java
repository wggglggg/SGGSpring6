package com.sgg.spring6.validator.three.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * ClassName: ValidationConfig
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/1 13:09
 * @Version 1.0
 */
@ComponentScan("com.sgg.spring6.validator.three")
@Configuration
public class ValidationConfig {
    //第一步 创建配置类，配置MethodValidationPostProcessor
    @Bean
    public MethodValidationPostProcessor validationPostProcessor(){
        return new MethodValidationPostProcessor();
    }
}
