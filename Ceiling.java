public class Ceiling {

    public static void main(String[] args) {
        int[] arr = {12, 17, 18, 23, 27, 33,56};
        System.out.println(searchCeiling(arr, 1));
    }

    public static int searchCeiling(int[] elements, int  target){

        int start = 0;
        int end  = elements.length - 1;

        while(start <= end){
            int mid = (start + end)/2;

            if(elements[mid] == target)
                return elements[mid];

            if(target > elements[mid])
                start = mid + 1;

            if(target < elements[mid])
                end = mid - 1;
        }

        if(start >= elements.length)
            return -1;

        return elements[start];


    }
}
