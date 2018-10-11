import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


/**
 * TestEquals
 */
public class MeiTuan_Test2 {

    public static void main(String [] args) {
        f();
    }

    public static int f() {
        Scanner sc = new Scanner(System.in);
        int result=0;
        int n,k,t;
        n=sc.nextInt();
        k=sc.nextInt();
        t=sc.nextInt();

        ArrayList<Integer> nums=new ArrayList<>();
        for(int i=0;i<n;++i){
            nums.add(sc.nextInt());
        }

        for(int l=0;l+k-1<n;++l){
            if(count(nums,l,k+l-1,t))
                ++result;
        }
        System.out.println(result);
        return result;
    }

    public static boolean count(ArrayList<Integer> nums,int l,int r,int t) {
        HashMap<Integer,Integer> numToCount=new HashMap<>();

        for(int i=l;i<=r;++i){
            if(numToCount.containsKey(nums.get(i)))
                numToCount.put(nums.get(i), numToCount.get(nums.get(i))+1);
            else
                numToCount.put(nums.get(i), 1);
        }

        for(Integer key:numToCount.keySet()){
            if(numToCount.get(key)>=t)
                return true;
        }

        return false;
    }
}