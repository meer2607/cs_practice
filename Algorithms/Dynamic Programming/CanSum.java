/*
Given an array and a value, determine if it is possible to combine the
array items such that they to the value.
Array elements can be used multiple times

3rd January 2022:
*/

import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class CanSum{
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter sum: ");
    int sum = input.nextInt();
    System.out.print("Enter size of array: ");
    int size = input.nextInt();
    System.out.print("Enter array: ");
    int[] array = new int[size];

    for(int i=0; i<array.length; i++)
      array[i] = input.nextInt();

    System.out.println(canSum(sum, array));
  }

  private static List<Integer> canSum(int sum, int[] arr){
    return canSum(sum, arr, null);
  }

  private static List<Integer> canSum(int sum, int[] arr,
    HashMap<Integer, List<Integer>> canSumMap){

    if(canSumMap == null){
      canSumMap = new HashMap<>();
    }

    List<Integer> values = new ArrayList<>();

    if(sum<0)
      return null;
    if(sum==0)
      return ;

    if(canSumMap.containsKey(sum))
      return canSumMap.get(sum);

    boolean returnValue = false;
    int i=0;

    while(i<arr.length && !returnValue){
      if(arr[i]>0)
        returnValue |= canSum(sum-arr[i], arr, canSumMap);
      i++;
    }

    canSumMap.put(sum, returnValue);

    return returnValue;
  }
}
