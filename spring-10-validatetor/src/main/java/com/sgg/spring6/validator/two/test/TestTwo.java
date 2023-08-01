package com.sgg.spring6.validator.two.test;

import com.sgg.spring6.validator.two.bean.Person;
import com.sgg.spring6.validator.two.config.ValidationConfig;
import com.sgg.spring6.validator.two.validator.MyValidator1;
import com.sgg.spring6.validator.two.validator.MyValidator2;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ClassName: TestTwo
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/1 10:26
 * @Version 1.0
 */
public class TestTwo {
    @Test
    public void testMyValidator1(){
        ApplicationContext context = new AnnotationConfigApplicationContext(ValidationConfig.class);

        MyValidator1 myValidator1 = context.getBean(MyValidator1.class);

        Person person = new Person();

        person.setName("caixingjuan");
        person.setAge(60);

        // 没有输入姓名,或者无效年龄  validator = false
        // 输入有效的数据 validator = true
        boolean validator = myValidator1.validator(person);
        System.out.println("validator = " + validator);
    }

    @Test
    public void testMyValidator2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyValidator2 validator2 = context.getBean(MyValidator2.class);

        Person person = new Person();

        person.setAge(240);

        boolean result = validator2.validator2(person);
        // [Field error in object 'caicande' on field 'age': rejected value [240];
        // codes [Max.caicande.age,Max.age,Max.int,Max];
        // arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [caicande.age,age];
        // arguments []; default message [age],120]; default message [最大不能超过120]]

        System.out.println("result = " + result);
    }
}
