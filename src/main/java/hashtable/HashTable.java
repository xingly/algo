package hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashTable {

    /**
     * 散列碰撞测试数据
     */
    private static List<String> list = Arrays.asList("1", "12", "23", "34", "45", "56", "67", "78", "89");


    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        for (String str : list) {
            System.out.println("即将放入散列表数据：" + str);
            map.put(str, str);
        }
    }
}
