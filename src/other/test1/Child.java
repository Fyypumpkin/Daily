package other.test1;

public class Child extends middle {
    @Override
    protected String excute() {
        return "child";
    }

    @Override
    public void print() {
        System.out.println("print");
    }
}
