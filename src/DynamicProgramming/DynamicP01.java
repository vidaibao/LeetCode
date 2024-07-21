package DynamicProgramming;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicP01 {
    public static void main(String[] args) {
        PascalTriangle2_119();
    }

    private static void PascalTriangle2_119() {
        List<Integer> re = GetRow(33);
    }

    private static List<Integer> GetRow(int rowIndex) {
        List<Integer> li = new ArrayList<>(List.of(1));
        if (rowIndex == 0) return li;
        li.add(1);
        if (rowIndex == 1) return li;
        for (int row = 2; row <= rowIndex; row++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int i = 0; i < row - 1; i++) {
                temp.add(li.get(i) + li.get(i + 1));
            }
            temp.add(1);
            li = temp;
        }
        return li;
    }


}
