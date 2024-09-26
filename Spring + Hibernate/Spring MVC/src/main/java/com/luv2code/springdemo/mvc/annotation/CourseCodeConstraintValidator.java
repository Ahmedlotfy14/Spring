package com.luv2code.springdemo.mvc.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class CourseCodeConstraintValidator implements ConstraintValidator <CourseCode ,String>{

    private String codePrefix;
    @Override
    public void initialize(CourseCode theCode) {
        codePrefix = theCode.value();
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext theConstraintValidatorContext) {
        boolean result ;
                if (code != null){
                    result = code.startsWith(codePrefix);
                }
                else {
                    result = true;
                }
        return result;

    }
}
