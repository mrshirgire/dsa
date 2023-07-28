package graph;

import java.util.ArrayList;
import java.util.List;

public class LC2477 {

    public long minimumFuelCost(int[][] roads, int seats) {

        int n = roads.length + 1;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] road: roads){
            adjList.get(road[0]).add(road[1]);
            adjList.get(road[1]).add(road[0]);
        }

        int[] vis = new int[n];
        vis[0] = 1;

        int count = 0;
        for(int node: adjList.get(0)){
            if(vis[node] == 0){
                Car car = new Car(2);
                List<Car> carList = new ArrayList<>();
                count+= dfs(node, carList, 0, seats, vis, adjList);
            }
        }

        return count;
    }

    int dfs(int node, List<Car> carList, int fuel, int seats, int[] vis, List<List<Integer>> adjList){
        vis[node] = 1;
        boolean seatsLeft = false;
        for(Car car: carList){
            if(car.seats >= 0) {
                seatsLeft = true;
                car.seats--;
                break;
            }
        }

        if(!seatsLeft) carList.add(new Car(seats--));
        fuel+=carList.size();
        for(int adjNode: adjList.get(node)){
            if(vis[adjNode] == 0){
                return dfs(adjNode, carList, fuel, seats, vis, adjList);
            }
        }

        return fuel;
    }
    class Car{

        int seats;
        Car(int seats){
            this.seats = seats;
        }
    }

    public static void main(String[] args) {
        LC2477 lc2477 = new LC2477();
        int[][] roads =  {{3,1},{3,2},{1,0},{0,4},{0,5},{4,6}};
        //int[][] roads = {{0,1},{0,2},{0,3}};
        int seats = 5;
        System.out.println(lc2477.minimumFuelCost(roads,seats));;
    }
}
