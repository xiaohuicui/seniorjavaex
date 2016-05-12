package ex2;

import java.lang.annotation.*;

/**
 * Created by cuixiaohui on 16/5/12.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Entity {
    String tablename();

}
