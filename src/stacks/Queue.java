package stacks;

public class Queue {
    private int maxSize;
    private long[]queArray;
    private int front;
    private int rear;

    public Queue(int s){
        maxSize=s+1;
        queArray=new long[maxSize];
        front=0;
        rear=-1;
    }

    public void insert(long j){
        if(rear==maxSize-1)
            rear=-1;
        queArray[++rear]=j;
    }

    public long remove(){
        long temp=queArray[front++];
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

    public void displayQueue(){
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

class QueueApp{

    public static void main(String []args){
        Queue theQueue=new Queue(5);
        theQueue.insert(10);
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);
        theQueue.insert(50);
        theQueue.remove();
        theQueue.remove();
        theQueue.insert(60);
        theQueue.insert(70);

        theQueue.insert(80);

        theQueue.displayQueue();
        theQueue.remove();
        theQueue.remove();
        theQueue.insert(90);

        theQueue.displayQueue();

        while(!theQueue.isEmpty())
        {
            long n=theQueue.remove();
            System.out.print(n);
            System.out.print(" ");
        }
        System.out.println();
    }
}
