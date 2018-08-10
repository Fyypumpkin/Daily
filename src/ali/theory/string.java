package ali.theory;

/**
 * @author fyypumpkin on 2018/7/19
 */
public class string {
    public static void main(String[] args) {
        String a = new String("aa");// 生成了常量池中的“aa” 和堆空间中的字符串对象
        a.intern(); // 该操作发现常量池中已经有了，所以无效，intern方法会返回常量池的引用
        String b = "aa";
        System.out.println(a == b); // 所以一个是常量池的，一个是堆的，返回false
        a = a.intern();
        System.out.println(a == b);
        String c = new String("cc") + new String ("dd"); // ccdd串在常量池中没有通过c.intern在常量池中生成了ccdd（8直接在常量池中存了堆中ccdd的引用）
        c.intern();
        String d = "ccdd";// 所以这个就返回了c的引用
        System.out.println(c == d);
    }
}
// jdk7之后，若发现常量池中没有相关的对象，会直接在常量池使用堆中的对象引用,如下的a，先在对中生成了一个对象，
// 并且在常量池中也生成了一份，此时两个引用为不同的引用，所以a.intern和a是不一样的，a.intern返回的是常量池中的引用，a是堆中的引用
// 而b由于是转化成了Stringbuilder来进行假发运算在队中和常量池中会生成"a" 和 "b" 但不会生成 "ab"，所以在执行b.intern的时候，
// 发现常量池中没有相关的元素，则直接将堆中的引用放到常量池中所以b.intern == b是返回true的


class Test2 {
    public static void main(String[] args) {
        String a = new String("1");
        System.out.println(a.intern() == a);
        String b = new String("a") + new String("b");
        System.out.println(b.intern() == b);
    }
}