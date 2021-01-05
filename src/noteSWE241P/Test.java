package noteSWE241P;
import noteSWE241P.insertionSort;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import noteSWE241P.LinkedList;

public class Test {
    public static void main(String[] args) {
//        int[] a = {3,2,4,5,1};
//        insertionSort.sort(a);
//        for (int i=0;i<a.length;i++) {
//            System.out.print(a[i]+" ");
//        }
//        int i =6;
//        System.out.println(~i);
//        System.out.println(Integer.toString(i,2));
//        System.out.println(Integer.toString(i&1,2));
//        System.out.println(Math.ceil(Math.sqrt(2*100+0.25)-0.5));
//        System.out.println((double)1/2);
        LinkedList ll = new LinkedList();
        ll.insert(2);
        ll.insert(5);
        ll.insert(4);
        ll.insert(3);
        ll.insert(9);
        ll.insert(6);
        System.out.println(ll.toString());
        ll.delete(2);
        ll.delete(5);
        System.out.println(ll.toString());
    }
}
