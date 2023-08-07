package segtree;

public class SegmentTree {

    int n = 5;
    int[] seg =  new int[n * 4];
    int[] input = new int[n];
    public void buildSegTree(int start, int end, int ind){

        if(start == end ){
            seg[ind] = input[ind];
            return;
        }

        int mid = start + (end - start)/2;
        buildSegTree(start, end, 2 * ind + 1);
        buildSegTree(mid + 1, end, 2 * ind + 1);

        seg[ind] = Math.min(seg[2 * ind + 1], seg[2 * ind + 2]);
    }


    public int rangeQuery(int start, int end, int rLeft, int rRight, int index){

        if(end < rLeft || start > rRight) return Integer.MAX_VALUE;

        if(start >= rLeft && end <= rRight) return seg[index];

        int mid = start + (end - start)/2;
        int leftAns = rangeQuery(start, mid, rLeft, rRight, 2 * index + 1);
        int rightAns = rangeQuery(mid + 1, end , rLeft, rRight, 2 * index + 2);

        return Math.min(leftAns, rightAns);


    }

    public void updateSegTree(int val, int updateIndex, int start, int end, int index){

        if(start == end){
            seg[updateIndex] = val;
            return;
        }

        int mid = start + (end - start)/2;
        if(updateIndex <=mid){
            updateSegTree(val, updateIndex, start, mid, 2 * index + 1);
        }else{
            updateSegTree(val, updateIndex, mid + 1, end, 2 * index + 2);
        }

        seg[index] = Math.min(seg[ 2 * index + 1], seg[2 * index + 2]);

    }

    public static void main(String[] args) {

    }
}
