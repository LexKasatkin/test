public class ArrayBub {
    private long[]a;
    private int nElems;

    public ArrayBub(int max){
        a=new long[max];
        nElems=0;
    }

    public void insert(long value)
    {
        a[nElems]=value;
        nElems++;
    }

    public void display()
    {
        for (int j=0; j<nElems; j++){
            System.out.print(a[j]+" ");
        }
        System.out.println();
    }

    public void bublSort()
    {
       int out,in, outLeft;
       for(out=nElems-1;out>1;out--)
       {
           outLeft=nElems-1-out;
           for(in=0; in<out;in++)
           {
               if(a[in]>a[in+1])
                   swap(in, in+1);
           }
           for(in=outLeft; in>1;in--)
           {
               if(a[in]>a[in+1])
                   swap(in, in+1);
           }
       }
    }

    private void swap(int one, int two)
    {
        long temp=a[one];
        a[one]=a[two];
        a[two]=temp;
    }
}



class BubbleSortApp
{
    public static void main(String[]args)
    {
        int maxSize=100;
        ArrayBub arr;
        arr=new ArrayBub(maxSize);
        arr.insert(66);
        arr.insert(33);
        arr.insert(66);
        arr.insert(99);
        arr.insert(11);
        arr.insert(22);
        arr.insert(33);
        arr.insert(77);

        arr.display();
        arr.bublSort();
        arr.display();
    }
}
