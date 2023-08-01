package com.sgg.spring6.validator.two.validator;

import com.sgg.spring6.validator.two.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.Validator;


/**
 * ClassName: MyValidator2
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/1 10:32
 * @Version 1.0
 */
@Service
public class MyValidator2 {
    @Autowired
    private Validator validator;        // spring6中的validator

    public boolean validator2(Person person){
        BindException bindException = new BindException(person, person.getName());
        validator.validate(person, bindException);
        System.out.println(bindException.getAllErrors().toString());
        return bindException.hasErrors();
    }
}
