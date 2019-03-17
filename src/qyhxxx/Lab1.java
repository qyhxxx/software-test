package qyhxxx;

import java.util.ArrayList;
import java.util.List;

public class Lab1 {
    List<Integer> list = new ArrayList<>();

    public boolean solve(int x) {
        int arr[] = {50, 20, 5, 5, 1, 1, 1};
        list.add(0);
        for (int i = 0; i < arr.length; i++) {
            int len = list.size();
            for (int j = 0; j < len; j++) {
                if (!list.contains(arr[i] + list.get(j))) {
                    list.add(arr[i] + list.get(j));
                }
            }
        }
        return list.contains(x);
    }
}
