package com.route21.ws.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.ws.rs.NameBinding;

import com.route21.ws.types.Role;

/**
 * 
 * @author Viswanath
 * Custom annotation to implement JWTtoken authentication for methods
 *
 */

@NameBinding
@Retention(RUNTIME)
@Target({TYPE, METHOD})
public @interface JWTSecured {
    Role[] value() default {};

}
