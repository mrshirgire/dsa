package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DetectSquares_2013 {
    Map<Integer, List<Pair>> map = new HashMap<>();
    int[][] matrix = new int[1001][1001];

    public void add(int[] point) {

        int x = point[0];
        int y = point[1];
        if(matrix[x][y] == 0){
            map.putIfAbsent(x, new ArrayList<>());
            map.get(x).add(new Pair(x, y));
        }
        matrix[x][y]++;
    }

    public int count(int[] points) {
        int x = points[0];
        int y = points[1];

        int count = 0;
        for(Pair pair: map.getOrDefault(x, new ArrayList<>())){
            int tempX = pair.x;
            int tempY = pair.y;

            if(x== tempX && y == tempY) continue;
            int len = Math.abs(y - tempY);

            if(x + len <=1001){
                count = count + matrix[x+len][y] * matrix[x][tempY] * matrix[x + len][tempY];
            }

            if(x - len>=0){
                count = count + matrix[x-len][y] * matrix[x-len][tempY] * matrix[x][tempY];
            }
        }

        return count;
    }

    public static void main(String[] args) {

        DetectSquares_2013 detectSquares = new DetectSquares_2013();
        detectSquares.add(new int[] {3, 10});
        detectSquares.add(new int[] {11, 2});
        detectSquares.add(new int[] {3, 2});

        System.out.println(detectSquares.count(new int[] {11, 10}));;
        System.out.println(detectSquares.count(new int[] {14, 8}));;

        detectSquares.add(new int[] {11, 2});
        System.out.println(detectSquares.count(new int[] {11, 10}));;
    }

    static class Pair {
        int x; int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}