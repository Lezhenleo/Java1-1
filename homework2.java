package ru.homework.lesson2;

public class homework2 {
    public static void main(String[] args){
        //invertArray();

        //fillArray();

        //changeArray();

        //findMaxMin();
    }
    //Задание 1
    public static void invertArray() {
        int[] arr = new int[] {1, 1, 0, 0, 1, 0, 1, 1, 0, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) arr[i] = 1;
            else arr[i] = 0;
        }
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }
    //Задание2
    public static  void fillArray(){
        int[] arr1 = new int[8];
        for (int y = 0, j = 1; y < arr1.length; y++, j += 3) {
            arr1[y] = j;
            System.out.print(arr1[y] + "\n");}
    }
    //Задание3
    public static  void changeArray(){
        int[] w = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int h = 0; h < w.length; h++) {
            if (w[h] < 6) w[h] *=2;
            System.out.print(w[h] + "\n");
        }
    }
    //Задание4
    public  static  void findMaxMin() {
        int [] arr2 = {2, 5, 7, 11, 9, 2, 6, 12, -1};
        int min = arr2[0];
        int max = arr2[0];
        for (int p : arr2) {
            System.out.print(p + "\t");
        }
        for (int p = 0; p < arr2.length; p++) {
            min = (min < arr2 [p]) ? min : arr2[p];
            max = (max > arr2 [p]) ? max : arr2[p];
        }
        System.out.println("\n minimal is: " + min + "\n maximal is: " + max );


            }

}
