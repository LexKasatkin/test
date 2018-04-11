package stacks;

public class PriorityQ {
    private int maxSize;
    private long[]queArray;
    private int nItems;

    public PriorityQ(int s)
    {
        maxSize=s;
        queArray=new long[maxSize];
        nItems=0;
    }

    public void insert(long item)
    {
        if(nItems<maxSize)
            queArray[nItems++]=item;
    }

    public long remove(){
        int i, minindex=0;
        long remove;
        if(nItems>0)
            for(i=0;i<nItems;i++){
                if(queArray[i]<queArray[minindex]){
                    minindex=i;
                }
            }
            remove=queArray[minindex];
            for(i=minindex;i<nItems;i++)
                queArray[i]=queArray[i+1];
            queArray[nItems]=0;
            nItems--;
            return remove;
    }
}

class PriorityApp
{
    public static void main(String[]args)
    {
        PriorityQ priorityQ=new PriorityQ(4);
        priorityQ.insert(3);
        priorityQ.insert(5);
        priorityQ.insert(45);
        priorityQ.remove();
        priorityQ.remove();
    }
}
