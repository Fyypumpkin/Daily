package ClassTest;

/**
 * @author fyypumpkin on 2018/7/13
 */

public class Person {
    private String name;
    private int age;
    private double height;
    private double weight;

    Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.height = builder.height;
        this.weight = builder.weight;
    }

    Person(Builder2 builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.height = builder.height;
        this.weight = builder.weight;
    }

    Person(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

      class Builder {
        private String name;
        private int age;
        private double height;
        private double weight;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder height(double height) {
            this.height = height;
            return this;
        }

        public Builder weight(double weight) {
            this.weight = weight;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }


    static class Builder2 {
        private String name;
        private int age;
        private double height;
        private double weight;

        public Builder2 name(String name) {
            this.name = name;
            return this;
        }

        public Builder2 age(int age) {
            this.age = age;
            return this;
        }

        public Builder2 height(double height) {
            this.height = height;
            return this;
        }

        public Builder2 weight(double weight) {
            this.weight = weight;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}

class Main{
    public static void main(String[] args) {
        /**
         * 非静态内部类， 要依赖于外部实例
         */
        Person person1 = new Person();
        Person.Builder builder = person1.new Builder();
        Person person = builder.age(10).height(11).name("hello").weight(10).build();
        System.out.println(person);

        Person person2 = new Person.Builder2().age(10).height(11).name("hello").weight(10).build();
        System.out.println(person2);
    }
}