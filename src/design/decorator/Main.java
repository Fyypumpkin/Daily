package design.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author fyypumpkin on 2018/7/25
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        FileInputStream fileInputStream;
//        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(""));
        Shoes shoes = new Shoes(new Hat(new Me()));
        shoes.show();
        System.out.println(Integer.toBinaryString(5 & 0xFF));
    }
}
