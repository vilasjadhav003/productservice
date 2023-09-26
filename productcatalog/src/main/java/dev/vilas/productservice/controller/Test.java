package dev.vilas.productservice.controller;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        /*Integer[] arr1 = {1,2,3,4,5};
        Integer[] arr2 = {1,2,3,7,8};
        Integer[] result = mergeArrays2(arr1,arr2);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }*/
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(9);
        list.add(5);
        list.add(4);
        arrange(list).stream().forEach(System.out::println);

    }

    private static int[] mergeArrays(Integer[] arr1, int[] arr2) {
        List<Integer> l1 = Arrays.stream(arr1).collect(Collectors.toList());
       // List<Integer> list1 = Arrays.stream(arr1).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(arr2).boxed().collect(Collectors.toList());
        l1.addAll(list2);
        List<Integer> list3 = l1.stream().distinct().sorted(Collections.reverseOrder()).collect(Collectors.toList());
       // List<Integer> list3 = l1.stream().distinct().sorted().collect(Collectors.toList());
        int[] result = new int[list3.size()];
        for(int i=0;i<list3.size();i++){
            result[i] = list3.get(i);
        }
        return result;
    }

    private static Integer[] mergeArrays2(Integer[] arr1, Integer[] arr2) {
        Set<Integer> numberSet1 = new HashSet<Integer>(Arrays.asList(arr1));
        Set<Integer> numberSet2 = new HashSet<Integer>();
        numberSet2.addAll(Arrays.asList(arr2));
        numberSet1.addAll(numberSet2);

        return numberSet1.toArray(new Integer[numberSet1.size()]);



    }

    public static ArrayList<Integer> arrange(ArrayList<Integer> A) {
        int n = A.size();
        for (int i = 0; i < n; i++) A.set(i, A.get(i) + (A.get(A.get(i)) % n) * n );
        for (int i = 0; i < n; i++) A.set(i, A.get(i) / n);
        return A;
    }


}
