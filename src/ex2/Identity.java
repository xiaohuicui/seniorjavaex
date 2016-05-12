package ex2;

import java.lang.annotation.*;

/**
 * Created by cuixiaohui on 16/5/12.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Identity {
    String columnName();
    String columnType();
    String generator();
}
