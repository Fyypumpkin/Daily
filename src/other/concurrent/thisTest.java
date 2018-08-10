package other.concurrent;

import java.util.Arrays;

/**
 * this逸出
 */
public class thisTest {
    private String a = null;

    //当前thisTest对象还未初始化完成，而inner就已经拥有了thisTest中this的引用，引用了a这个变量导致了空指针
    private thisTest(){
        inner inner = new inner();
        inner.test();
        a="aaa";
    }
    public class inner{
        public void test(){
            System.out.println(a.toString());
        }
    }

    public static void main(String[] args) {
        thisTest thisTest = new thisTest();
    }
}
