//An implementation of Fibonacci using DP / memoization
//2 January 2022

import java.util.ArrayList;

class Fibonacci{
  public static void main(String[] args) {
    System.out.println(getFibonacci(Integer.parseInt(args[0])));
  }

  private static Long getFibonacci(int index){
    return getFibonacci(index, null);
  }

  private static Long getFibonacci(int index, ArrayList<Long> fibonacciSeq){
    if(fibonacciSeq==null || index<=2){
      fibonacciSeq = new ArrayList<Long>();
      fibonacciSeq.add(new Long(0));
      fibonacciSeq.add(new Long(1));
      fibonacciSeq.add(new Long(1));
    }

    if(index<fibonacciSeq.size())
      return fibonacciSeq.get(index);

    fibonacciSeq.add(getFibonacci(index-1, fibonacciSeq) +
      getFibonacci(index-2, fibonacciSeq));
    return fibonacciSeq.get(index);
  }
}
