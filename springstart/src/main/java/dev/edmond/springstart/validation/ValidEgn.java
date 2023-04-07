package dev.edmond.springstart.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = ValidEgnConstraint.class)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEgn {
    String message() default ("EGN should be exactly 10 digits!");
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};
    
}
