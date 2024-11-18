package com.cesur.splinterio.models.utils.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = StrongPasswordValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER }) // Valida que entra un campo de tipo String
@Retention(RetentionPolicy.RUNTIME)
public @interface StrongPassword {
    String message() default "La contraseña debe tener al menos 8 caracteres, una mayúscula, una minúscula, un número y un caracter especial";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}