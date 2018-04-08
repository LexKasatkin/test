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


    public void oddEvenSort()
    {
        int out,in;


        for(out=nElems-1;out>1;out-- )
            for(in=1;in<out;in=in+2)
                if(a[in]>a[in+1])
                    swap(in, in+1);

        for(out=nElems-1;out>1;out-- )
            for(in=0;in<out;in=in+2)
                if(a[in]>a[in+1])
                    swap(in, in+1);
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
        arr.oddEvenSort();
        arr.display();
    }
}

class ArrayIns {
    private long[]a;
    private int nElems;

    public ArrayIns(int max){
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

    public void insertionSort()
    {
        int out,in;
        for(out=1;out<nElems;out++)
        {
            long temp=a[out];
            in=out;
            while(in>0&&a[in-1]>=temp)
            {
                a[in]=a[in-1];
                --in;
            }
            a[in]=temp;
        }
    }

    public void noDups()
    {
        int k=0;
        long curvalue=0L;
        for(int i=1;i<nElems;i++)
        {
            if(a[i]==a[i-1]||a[i-1]==0) {
                if(k==0){
                    k=i;
                    curvalue=a[k];
                }else if(curvalue!=a[i]){
                    a[k] = a[i];
                    curvalue=a[k];
                    k++;
                }
                a[i]=0;
            }

        }
        nElems=k;

    }
}

class InsertSortApp
{
    public static void main(String[]args)
    {
        int maxSize=100;
        ArrayIns arr;
        arr=new ArrayIns(maxSize);
        arr.insert(66);
        arr.insert(33);
        arr.insert(66);
        arr.insert(99);
        arr.insert(11);
        arr.insert(22);
        arr.insert(22);
        arr.insert(22);
        arr.insert(22);
        arr.insert(22);
        arr.insert(22);
        arr.insert(22);
        arr.insert(22);
        arr.insert(33);
        arr.insert(77);
        arr.insert(77);
        arr.insert(77);
        arr.insert(77);
        arr.insert(77);
        arr.insert(77);
        arr.display();
        arr.insertionSort();
        arr.display();
        arr.noDups();
        arr.display();
    }
}


class ArraySel {
    private long[]a;
    private int nElems;

    public ArraySel(int max){
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

    public void selectionSort()
    {
        int out,in, min;
        for(out=0;out<nElems-1;out++)
        {
           min=out;
           for(in=out+1;in<nElems; in++)
               if(a[in]<a[min])
                   min=in;
           swap(out,min);
        }
    }

    private void swap(int one, int two)
    {
        long temp=a[one];
        a[one]=a[two];
        a[two]=temp;
    }

    public long median()
    {
        long sum=0, sumMed=0;
        for(int j=0; j<nElems;j++)
            sum+=a[j];
        for(int j=0; j<nElems;j++)
        {
            sumMed+=a[j];
            if(sumMed>=sum/2)
                return a[j-1];
        }
        System.out.println(sum);
        return -1;
    }

}

class SelectSortApp
{
    public static void main(String[]args)
    {
        int maxSize=100;
        ArraySel arr;
        arr=new ArraySel(maxSize);
        arr.insert(14);
        arr.insert(33);
        arr.insert(45);
        arr.insert(17);
        arr.insert(11);
        arr.insert(22);
        arr.insert(44);
        arr.insert(44);
        arr.insert(44);
        arr.insert(44);
        arr.insert(11);

        arr.display();
        arr.selectionSort();
        arr.display();
        arr.display();
        long sum=arr.median();
        System.out.println(sum);

    }
}