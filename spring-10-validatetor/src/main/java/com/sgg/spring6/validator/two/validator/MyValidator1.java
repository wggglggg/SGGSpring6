package com.sgg.spring6.validator.two.validator;

import com.sgg.spring6.validator.two.bean.Person;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * ClassName: MyValidator1
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/1 10:16
 * @Version 1.0
 */
@Service
public class MyValidator1 {

    @Autowired
    private Validator validator;  // java中的validator校验
    public boolean validator(Person person){
        // 校验person类数据, 如果为空
        Set<ConstraintViolation<Person>> validate = validator.validate(person);
        return validate.isEmpty();
    }
}
