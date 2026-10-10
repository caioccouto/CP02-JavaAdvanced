package br.com.rm563452.cp2.sistema_cursos.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MultipleOfValidator implements ConstraintValidator<MultipleOf, Integer> {

    private int divisor;

    @Override
    public void initialize(MultipleOf annotation) {
        this.divisor = annotation.value();
    }

    @Override
    public boolean isValid(
            Integer valor,
            ConstraintValidatorContext context) {

        if (valor == null) {
            return true;
        }

        if (divisor <= 0) {
            throw new IllegalArgumentException(
                    "O divisor deve ser maior que zero"
            );
        }

        return valor % divisor == 0;
    }
}
