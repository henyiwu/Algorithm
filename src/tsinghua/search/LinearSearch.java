package tsinghua.search;

import java.util.ArrayList;

/**
 * 顺序查找
 * 也叫线性查找，从列表第一个元素开始顺序进行搜索，
 * 直到找到元素或者搜索到列表最后一个元素为止
 *
 * 时间复杂度O(n)
 */
public class LinearSearch {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(4);
        int i = linearSearch(arrayList, 3);
        System.out.println(i);
    }

    public static int linearSearch(ArrayList<Integer> arrayList, int target) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == target) {
                return i;
            }
        }
        return -1;
    }
}
