package com.sgg.spring6.validator.three.test;

import com.sgg.spring6.validator.three.bean.Person;
import com.sgg.spring6.validator.three.config.ValidationConfig;
import com.sgg.spring6.validator.three.validator.MyValidator;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ClassName: TestMethod3
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/1 13:23
 * @Version 1.0
 */
public class TestMethod3 {
    @Test
    public void testMyValidator(){
        ApplicationContext context = new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyValidator myValidator = context.getBean(MyValidator.class);

        Person person = new Person();
        person.setAge(-1);

        // 校验结果
        // jakarta.validation.ConstraintViolationException: ValidateParams.arg0.age: 最小不能小于0, ValidateParams.arg0.phone: 手机号码不能为空, ValidateParams.arg0.name: 不能为null
        myValidator.ValidateParams(person);
    }
}
