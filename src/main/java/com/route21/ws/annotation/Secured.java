package com.route21.ws.annotation;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.ws.rs.NameBinding;
/** 
 * @author Viswanath
 * Custom annotation to secure methods
 */
@NameBinding
@Retention(RUNTIME)
@Target({TYPE, METHOD})//use at method level only
public @interface Secured {

}
