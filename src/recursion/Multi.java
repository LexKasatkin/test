package recursion;

public class Multi {
    int x;
    int result;

    Multi(int x){
        this.x=x;
        result=0;
    }

    public int mult(int y){
        if(y==0)
            return result;
        else{
            result=x+mult(y-1);
            System.out.println(result);
            return result;
        }
    }
}


class MultiMain{
    public static void main(String[]args){
        Multi multi=new Multi(7);
        int result=multi.mult(5);
        System.out.println(result);

    }
}