package com.sgg.spring6.validator.one.test;

import com.sgg.spring6.validator.one.bean.Person;
import com.sgg.spring6.validator.one.valida.PersonValidator;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

/**
 * ClassName: TestOne
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/1 9:53
 * @Version 1.0
 */
public class TestOne {
    public static void main(String[] args) {
        //创建person对象
        Person person = new Person();
//        person.setName("COCO");
        person.setAge(123);

        // 创建Person对应的DataBinder, 将person与dataBinder绑定
        DataBinder dataBinder = new DataBinder(person);

        // 设置校验, 将PersonValidator.class校验规则 放入
        dataBinder.setValidator(new PersonValidator());

        // 进行校验
        dataBinder.validate();

        //输出结果
        // 没有给person.name设置值时,会报错 result = org.springframework.validation.BeanPropertyBindingResult: 1 errors
        // Field error in object 'target' on field 'name': rejected value [null];
        // codes [name is empty.target.name,name is empty.name,name is empty.java.lang.String,name is empty];
        // arguments []; default message [null]
        // age > 120 , 0 < age  报错
        // Field error in object 'target' on field 'age': rejected value [123];
        // codes [age is greater then 120.target.age,age is greater then 120.age,age is greater then 120.int,age is greater then 120];
        // arguments []; default message [null]


        // 给Person.name设置值后输出校验  result = org.springframework.validation.BeanPropertyBindingResult: 0 errors
        BindingResult result = dataBinder.getBindingResult();
        System.out.println("result = " + result);


    }
}
