import java.util.Arrays;

public class PQueue {
    private int[] arr;
    PQueue(int[] arr){
        this.arr=arr;
    }


    public String toString(){
        return Arrays.toString(this.arr);
    }

    public boolean isEmpty(){
        return this.arr.length==0;
    }

    public int size(){
        return this.arr.length;
    }

    public int peek(){
        return this.arr[0];
    }

    private boolean compare(int a, int b){
        return this.arr[a]>this.arr[b];
    }

    private int parent(int idx){
        return Math.floorDiv((idx-1),2);
    }

    private int getRight(int idx){
        return (idx*2) + 2;
    }

    private int getLeft(int idx){
        return (idx*2) + 1;
    }

    private void swap(int idx1,int idx2){
        int temp = this.arr[idx1];
        this.arr[idx1] = this.arr[idx2];
        this.arr[idx2] = temp;
    }

    public void push(int a){
        this.arr= Arrays.copyOf(this.arr,this.arr.length+1);
        final int arl = this.arr.length;
        this.arr[arl-1] = a;

        int idx=arl-1;
        int parent = parent(idx);

        while(parent> -1 && compare(idx,parent)){
            swap(idx,parent);
            idx=parent;
            parent=parent(idx);
        }

    }


    public int pop(int idx){
        int last = this.arr[this.arr.length-1];
        int popped = this.arr[idx];

        this.arr =Arrays.copyOf(this.arr,this.arr.length-1);
        this.arr[idx]= last;

        int lidx = getLeft(idx);
        int ridx = getRight(idx);
        final int siz =size();

        int idx2swap=-1;

        if(lidx<siz)
            if(ridx<siz)
                idx2swap = (compare(lidx,ridx)?lidx:ridx);
            else
                idx2swap = lidx;

        while(idx2swap>-1 && !compare(idx,idx2swap)){
            swap(idx,idx2swap);
            idx=idx2swap;
            idx2swap=-1;
            lidx = getLeft(idx);
            ridx = getRight(idx);
            if(lidx<siz)
                if(ridx<siz)
                    idx2swap = (compare(lidx,ridx)?lidx:ridx);
                else
                    idx2swap = lidx;

        }

        return popped;
    }

}


