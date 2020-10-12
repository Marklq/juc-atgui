package com.dd;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Package: com.dd
 * @ClassName: test
 * @Author: 东方不败
 * @CreateTime: 2020-10-09 13:00
 * @Description:
 */
public class test {
    /*
     *//*    a = [
    {time:1},
    {time:5},
    {time:8},
    {time:11},
    {time:16},
    {time:17},
    {time:29},
    {time:34},
    {time:39}
];*//*

    private static int[] time = new int[]{1, 5, 8, 11, 16, 17, 29, 34, 39};
    private static int[] time_line = new int[]{3, 7, 12, 17, 19, 31, 40};

    public static void main(String[] args) {

        for (int i = 0; i < time_line.length; i++) {

            for (int j = 0; j < time.length; j++) {
                int result1 = time_line[j] - time[i];
                int result2 = time_line[j] - time[i + 1];

                if (result1 == result2) {
                    System.out.println(j);
                }

            }

            System.out.println("{[" + "line:" + time + "]}");

        }


    }


}*/

    public static int binarysearchKey(Object[] array, int targetNum) {

//        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        int targetindex = 0;
        int left = 0, right = 0;
        for (right = array.length - 1; left != right; ) {
            int midIndex = (right + left) / 2;
            int mid = (right - left);
            int midValue = (Integer) array[midIndex];
            if (targetNum == midValue) {
                return midIndex;
            }
            if (targetNum > midValue) {
                left = midIndex;
            } else {
                right = midIndex;
            }

            if (mid <= 1) {
                break;
            }
        }
        int rightnum = ((Integer) array[right]).intValue();
        int leftnum = ((Integer) array[left]).intValue();
        int ret = Math.abs((rightnum - leftnum) / 2) > Math.abs(rightnum - targetNum) ? rightnum : leftnum;
        return ret;
    }

    public static void main(String[] args) {
        ArrayList time = new ArrayList();
        time.add(1);
        time.add(5);
        time.add(8);
        time.add(11);
        time.add(16);
        time.add(17);
        time.add(29);
        time.add(34);
        time.add(39);


        int[] time_line = new int[]{3, 7, 12, 17, 19, 31, 40};

        for (int i = 0; i < time_line.length; i++) {
            System.out.println("要查找的数：" + time_line[i] +
                    "最接近的数：" + binarysearchKey(time.toArray(), time_line[i]));

        }
    }
}
