package ClassTest;

/**
 * @author fyypumpkin on 2018/7/15
 */
public class FinalizeGuardian {

}

class Parent {

    public static void main(final String[] args) throws Exception {
        doIt();
        System.gc();
        Thread.sleep(5000); //  5 sec sleep
    }

    @SuppressWarnings("unused")
    private final Object guardian = new Object() {
        @Override protected void finalize() {
            doFinalize();
        }
    };

    private void doFinalize() {
        System.out.println("Finalize of class Parent");
    }

    public static void doIt() {
        Child c = Child.getInstance();
        System.out.println(c);
    }

}

class Child extends Parent {

    // Note, Child class does not call super.finalize() but the resources held by the
    // parent class will still get cleaned up, thanks to the guardian pattern
    @Override protected void finalize() {
        System.out.println("Finalize of class Child");
    }

    private Child(){}

    public static Child getInstance(){
        return new Child();
    }

    @Override
    public boolean equals(Object obj) {
        try {
            throw new IllegalAccessException();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return false;
    }
}