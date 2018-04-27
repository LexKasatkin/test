package lists;

public class CicleList {
    CicleLink current;

    CicleList(int id, long data){
        current=new CicleLink(id,data,current);
        current.next=current;
    }

    public CicleList() {
        current=null;
    }

    public void add(int id, long data){
        if(current==null) {
            current = new CicleLink(id,data);
            current.next=current;
        }
        else {
            CicleLink newCicleLink=new CicleLink(id,data,current.next);
            current.next = newCicleLink;
        }
    }

    public CicleLink step(){
        current=current.next;
        return current;
    }

    public void displayList(){
        CicleLink first=current;
        do{
            current.displayCicleLink();
            step();
        }while(!first.equals(current));
        System.out.println();
    }

    public long delete(){
        long deletElem=current.next.data;
        current.next=current.next.next;
        return deletElem;
    }


    public CicleLink search(CicleLink cicleLink){
        CicleLink first=current;
        do{
            if(cicleLink.equals(current.next)) {
                cicleLink.displayCicleLink();
                System.out.println("was found");
                return cicleLink;
            }
            step();
        }while(!first.equals(current));
        System.out.println("Element  was not found");
        return  cicleLink;
    }
}

class CicleLink {
    int id;
    long data;
    CicleLink next;

    CicleLink(int id,long data,CicleLink next){
        this.id=id;
        this.data=data;
        this.next=next;
    }

    CicleLink(int id,long data){
        this.id=id;
        this.data=data;
    }

    public void displayCicleLink(){
        System.out.println("{"+id+", "+data+"}");
    }

    @Override
    public boolean equals(Object o) {
        CicleLink cicleLink=(CicleLink)o;
        return cicleLink.id==id&&cicleLink.data==data;
    }
}

class MainCycleList{
    public static void main(String [] args){
        CicleList cicleList=new CicleList(1,2);
        cicleList.add(2,5);
        cicleList.add(3,4);
        cicleList.delete();
        cicleList.add(4,105);
        cicleList.displayList();
        cicleList.add(5,4);
        cicleList.add(6,4);
        cicleList.search(new CicleLink(6,4));
        cicleList.displayList();

    }
}
