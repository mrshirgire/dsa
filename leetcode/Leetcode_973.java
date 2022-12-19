package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode_973 {

    static class PointDist {
        int[] points;
        double dist;

        PointDist(int[] points, double dist){
            this.points = points;
            this.dist = dist;
        }

        public int[] getPoints() {
            return points;
        }

        public double getDist() {
            return dist;
        }
    }
    public static int[][] kClosest(int[][] points, int k) {

        PointDist[] pointDistList = new PointDist[points.length];

        for(int i = 0; i < points.length; i++){

            int x1 = 0;
            int x2 =  points[i][0];
            int y1 = 0;
            int y2 = points[i][1];

            double dist = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));

            PointDist pointDist = new PointDist(points[i], dist);
            pointDistList[i] = pointDist;
        }

        for(int i = pointDistList.length/2; i>0; i--){
            pointDistList = hipify(pointDistList, i, pointDistList.length);
        }
        int[][] ans = new int[k][];

        for(int idx = 0; idx < k; idx++){
            ans[idx] = pointDistList[0].getPoints();
            pointDistList = remove(pointDistList, 1, pointDistList.length - idx);
        }

        return ans;
    }

    public static PointDist[] hipify(PointDist[] pointDists, int currIndex, int length){

        int minIndex = currIndex;
        int leftIndex = 2 * currIndex;
        int rightIndex = 2 * currIndex + 1;

        if(leftIndex <= length && pointDists[leftIndex-1].dist < pointDists[minIndex-1].dist){
            minIndex = leftIndex;
        }

        if(rightIndex<=length && pointDists[rightIndex-1].dist < pointDists[minIndex-1].dist){
            minIndex = rightIndex;
        }

        if(minIndex != currIndex){
            pointDists = swap(pointDists, minIndex-1, currIndex-1);
            return hipify(pointDists, minIndex, length);
        }

        return pointDists;
    }

    public static PointDist[] swap(PointDist[] maxHeap, int parentIndex, int j) {

        PointDist temp = maxHeap[parentIndex];
        maxHeap[parentIndex] = maxHeap[j];
        maxHeap[j] = temp;

        return maxHeap;
    }

    private static PointDist[] remove(PointDist[] heap, int noOfElementsToRemove, int len){

        for(int i = 0; i < noOfElementsToRemove; i++){

            len--;
            heap = swap(heap, 0, len);

            for(int j = len/2; j>0; j--){
                heap = hipify(heap, j, len);
            }
        }

        return heap;
    }


    public static void main(String[] args) {
        /*int[][] points = {{1,3},{-2,2}};
        int k = 1;*/

        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;

        System.out.println(Arrays.toString(kClosest(points, k)));
    }
}
