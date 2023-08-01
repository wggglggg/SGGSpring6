package com.sgg.spring6.validator.one.valida;

import com.sgg.spring6.validator.one.bean.Person;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * ClassName: PersonValidator
 * Description:
 *      Validator类，其实就是校验接口
 * @Author wggglggg
 * @Create 2023/8/1 9:48
 * @Version 1.0
 */
public class PersonValidator implements Validator {
    // supports方法用来表示此校验用在哪个类型上
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    // validate是设置校验逻辑的地点，其中ValidationUtils，是Spring封装的校验工具类，帮助快速实现校验。
    @Override
    public void validate(Object target, Errors errors) {
        // 给name属性校验
        ValidationUtils.rejectIfEmpty(errors, "name", "name is empty");

        // target 就是person,
        Person person = (Person) target;

        if (person.getAge() > 120){
            errors.rejectValue("age", "age is greater then 120");
        } else if (person.getAge() < 0) {
            errors.rejectValue("age", "age is invalid");
        }
    }
}
