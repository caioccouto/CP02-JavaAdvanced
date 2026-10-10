package br.com.rm563452.cp2.sistema_cursos.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = MultipleOfValidator.class)
@Target({FIELD, PARAMETER, ANNOTATION_TYPE, RECORD_COMPONENT})
@Retention(RUNTIME)
public @interface MultipleOf {

    String message() default "o valor deve ser múltiplo do número definido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int value();
}
