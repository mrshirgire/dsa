package google;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class GFG {

  /*
  using min heap DS
 
  how data are stored in min Heap DS
         1
       2   3
  if k==3 , then top element of heap
  itself the kth largest largest element
 
  */
  static PriorityQueue<Integer> min;
  static int k;

  static List<Integer> getAllKthNumber(int arr[]) {

    List<Integer> list = new ArrayList<>();
    for (int val : arr) {
      if (min.size() < k)
        min.add(val);
      else {
        if (val > min.peek()) {
          min.poll();
          min.add(val);
        }
      }
      if (min.size() >= k)
        list.add(min.peek());
      else
        list.add(-1);
    }
    return list;
  }
}