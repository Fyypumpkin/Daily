package Thread.Container;

/**
 * @author fyypumpkin on 2018/7/29
 */
public class algorithm {
    /**
     * hash中，计算指定绒料最接近的2次幂值
     * @param cap
     */
    private static void tableSizeFor(int cap){
        int temp = cap - 1;
        temp |= temp >>> 1;
        temp |= temp >>> 2;
        temp |= temp >>> 4;
        temp |= temp >>> 8;
        temp |= temp >>> 16;
        temp += 1;

        System.out.println(temp);
    }

    public static void main(String[] args) {
        algorithm.tableSizeFor(19888);
    }
}
