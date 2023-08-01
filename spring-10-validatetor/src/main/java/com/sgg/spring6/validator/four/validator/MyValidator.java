package com.sgg.spring6.validator.four.validator;

import com.sgg.spring6.validator.four.anno.SelfAnno;
import com.sgg.spring6.validator.four.bean.Person;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * ClassName: MyValidator
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/1 13:55
 * @Version 1.0
 */

@Service
@Validated
public class MyValidator {

    public String Params(@NotNull @Valid Person person){
        return person.toString();
    }
}
