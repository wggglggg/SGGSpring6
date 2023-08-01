package com.sgg.spring6.validator.two.bean;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * ClassName: Person
 * Description:
 * 常用注解
 * @NotNull 限制必须不为null
 * @NotEmpty 只作用于字符串类型，字符串不为空，并且长度不为0
 * @NotBlank 只作用于字符串类型，字符串不为空，并且trim()后不为空串
 * @DecimalMax(value) 限制必须为一个不大于指定值的数字
 * @DecimalMin(value) 限制必须为一个不小于指定值的数字
 * @Max(value) 限制必须为一个不大于指定值的数字
 * @Min(value) 限制必须为一个不小于指定值的数字
 * @Pattern(value) 限制必须符合指定的正则表达式
 * @Size(max,min) 限制字符长度必须在min到max之间
 * @Email 验证注解的元素值是Email，也可以通过正则表达式和flag指定自定义的email格式
 *
 * @Author wggglggg
 * @Create 2023/8/1 9:46
 * @Version 1.0
 */
public class Person {
    @NotNull
    private String name;

    @Min(0)
    @Max(120)
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
