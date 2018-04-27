package lists;

public class StackCycleList {
    CicleList cicleList;

    StackCycleList(){
        cicleList=new CicleList();
    }

    public void push(int id, long data){
        cicleList.add(id,data);
    }

    public long pop(){
        return cicleList.delete();
    }

    public long peek(){
        cicleList.step();
        return cicleList.current.data;
    }
}

class MainStackList{
    public static void main(String[] args){
        StackCycleList stackCycleList=new StackCycleList();
        stackCycleList.push(2,5);
        stackCycleList.push(3,5);
        stackCycleList.push(1,5);
        stackCycleList.push(4,502);
        long cicleLink=stackCycleList.peek();
        stackCycleList.pop();
        stackCycleList.push(1,2);
        stackCycleList.pop();
        stackCycleList.push(1,2);
        long cicleLink2=stackCycleList.peek();

    }
}
