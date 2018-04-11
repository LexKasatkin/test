package lists;

public class Link {
    public int iData;
    public double dData;
    public Link next;

    public Link(int id, double dd)
    {
        iData=id;
        dData=dd;
    }

    public void displayLink()
    {
        System.out.print("{"+iData+". "+dData+"} ");
    }
}

class LinkList
{
    private Link first;

    public LinkList()
    {
        first=null;
    }

    public boolean isEmpty()
    {
        return(first==null);
    }

    public void insertFirst(int dd, double dd)
    {
        
    }
}
