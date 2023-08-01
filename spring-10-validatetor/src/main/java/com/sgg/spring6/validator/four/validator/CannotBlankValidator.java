package com.sgg.spring6.validator.four.validator;


import com.sgg.spring6.validator.four.anno.SelfAnno;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * ClassName: CannotBlankValicator
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/1 13:37
 * @Version 1.0
 */
public class CannotBlankValidator implements ConstraintValidator<SelfAnno, String> {
    @Override
    public void initialize(SelfAnno constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {
        //null时直接返回在true,有异常有问题, s 就是person属性的值
        if (s != null && s.contains(" ")){
            //获取默认提示信息
            String defaultConstraintMessageTemplate = context.getDefaultConstraintMessageTemplate();
            System.out.println("default message :" + defaultConstraintMessageTemplate);
            //禁用默认提示信息
            context.disableDefaultConstraintViolation();
            //设置提示语
            context.buildConstraintViolationWithTemplate("Can not Contains blank").addConstraintViolation();
            return false;
        }
        return true;
    }
}
