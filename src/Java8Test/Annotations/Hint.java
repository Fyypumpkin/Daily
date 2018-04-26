package Java8Test.Annotations;

import java.lang.annotation.Repeatable;

/**
 * @author fyypumpkin on 2018/4/26.
 */
@Repeatable(Hints.class)
public @interface Hint {
    String value();
}
