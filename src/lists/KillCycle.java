package lists;

public class KillCycle {
    CicleList cicleList;
    int nElems;

    KillCycle(int nElems){
        cicleList=new CicleList();
        this.nElems=nElems;
        for(int i=0;i<nElems;i++){
            cicleList.add(nElems-i,nElems-i);
        }
    }

    public void killEverybody(int begin, int interval){
        for(int i=0;i<begin-1;i++){
            cicleList.step();
        }
        while (nElems>1){
            for(int i=0;i<interval;i++){
                cicleList.step();
            }
            long deleteElem=cicleList.delete();
            System.out.println(deleteElem);
            nElems--;
        }
        System.out.println("Last element " +cicleList.current.data);
    }


}


class MainKillCycle{
    public static void main(String[]args){
        KillCycle killCycle=new KillCycle(7);
        killCycle.killEverybody(2,3);
    }
}
