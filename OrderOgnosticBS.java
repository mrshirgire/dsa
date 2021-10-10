public class OrderOgnosticBS {

    public static void main(String[] args) {

        int[] elements = {10, 8, 6, 4, 1};
        System.out.println(search(elements, 60));
    }

    public static  int search(int elements[], int target){

        int start = 0;
        int end = elements.length - 1;

        while(start <= end){

            int mid = start + end;

            if(target == elements[mid]) return mid;

            if(target > elements[mid]) end = mid - 1;

            if(target < elements[mid]) start = mid + 1;

        }

        return -1;
    }
}
