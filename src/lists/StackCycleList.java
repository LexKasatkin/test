package lists;

public class StackCycleList {
    CicleList cicleList;

    StackCycleList(){
        cicleList=new CicleList(0,0);
    }

    public void push(int id, long data){
        cicleList.add(id,data);
    }

    public CicleLink pop(){
        return cicleList.delete();
    }

    public CicleLink peek(){
        return cicleList.current;
    }
}

class MainStackList{
    public static void main(String[] args){
        StackCycleList stackCycleList=new StackCycleList();
        stackCycleList.push(2,5);
        stackCycleList.push(3,5);
        stackCycleList.push(1,5);
        stackCycleList.pop();
        stackCycleList.push(1,2);
    }
}
