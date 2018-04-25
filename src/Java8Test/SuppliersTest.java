package Java8Test;

import java.util.function.Supplier;

/**
 * 相比Function，无入参，直接返回指定类型
 *
 * @author fyypumpkin on 2018/4/25.
 */

public class SuppliersTest {
    public static void main(String[] args) {
        Supplier<Double> genRandom = Math::random;

        System.out.println(genRandom.get());

        Supplier<Person> personSupplier = Person::new;

        personSupplier.get();
    }
}

class Person {
    private String name;

    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public String toString() {
        return "name: " + this.name + ", sex: " + this.sex;
    }
}