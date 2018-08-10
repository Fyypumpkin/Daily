package other.test1;

public abstract class Super {
    protected abstract String excute();

    public String handle(){
        return excute();
    }

    public void print() {
        System.out.println("super,print");
    }
}
