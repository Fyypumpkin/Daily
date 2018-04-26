package Java8Test.Annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;

/**
 * @author fyypumpkin on 2018/4/26.
 */

// 新方式
@Hint("hint1")
@Hint("hint2")
public class RepetableAnn {
    public static void main(String[] args) {
        Annotation[] annotations = RepetableAnn.class.getAnnotations();
        System.out.println(annotations.length);
    }
}

// 老方式
@Hints({@Hint("hint1"), @Hint("hint2")})
class OldRepetableAnn {

}
