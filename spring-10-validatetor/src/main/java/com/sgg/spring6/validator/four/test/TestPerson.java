package com.sgg.spring6.validator.four.test;

import com.sgg.spring6.validator.four.config.ValidationConfig;
import com.sgg.spring6.validator.four.validator.MyValidator;
import com.sgg.spring6.validator.four.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ClassName: TestPerson
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/1 13:57
 * @Version 1.0
 */
public class TestPerson {

    @Test
    public void TestMyValidator(){
        ApplicationContext context = new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyValidator myValidator = context.getBean(MyValidator.class);

        Person person = new Person();
        person.setName("caicande");
        person.setPhone("13912312312");
        person.setMessage("adsfasdfasd  fasdf");


        // jakarta.validation.ConstraintViolationException: Params.arg0.message: Can not Contains blank
        myValidator.Params(person);

    }
}
