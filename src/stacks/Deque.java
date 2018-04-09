package stacks;

public class Deque {
    private int maxSize;
    private long[]queArray;
    private int front;
    private int rear;

    public Deque(int s){
        maxSize=s+1;
        queArray=new long[maxSize];
        front=0;
        rear=-1;
    }

    public void insertLeft(long j){
        if(front==0)
            front=maxSize;
        queArray[--front]=j;
    }

    public void insertRight(long j){
        if(rear==maxSize-1)
            rear=-1;
        queArray[++rear]=j;
    }

    public long removeLeft(){
        long temp=queArray[front++];
        if(front==maxSize)
            front=0;
        return temp;
    }

    public long removeRight(){
        long temp=queArray[rear--];
        if(front==maxSize)
            front=0;
        return temp;
    }

    public long peek(){
        return queArray[front];
    }

    public boolean isEmpty(){
        return (rear+1==front ||(front+maxSize-1==rear));
    }

    public boolean isFull(){
        return (rear+2==front || (front+maxSize-2==rear));
    }

    public int size(){
        if(rear>=front)
            return rear-front+1;
        else
            return (maxSize-front)+(rear+1);
    }

    public void displayDeque(){
        if(rear>front)
            for(int i=front;i<rear+1;i++)
                System.out.print(queArray[i]+" ");
        else {
            for (int i = front; i < maxSize - 1; i++) {
                System.out.print(queArray[i] + " ");
            }
            for (int i = 0; i < rear + 1; i++) {
                System.out.print(queArray[i] + " ");
            }
        }

        System.out.println();
    }
}
