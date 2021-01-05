package JavaFeatures;


public class TestPointer {
    public static void main(String[] args) {
        Integer a = new Integer(5);
        test(a);
        System.out.println(a);
        // As a conclusion, Java cannot do any pointer operation (operations on a pointer itself, not its copy)
        // Use JNI to achieve this function if necessary
    }

    private static void test(Integer i) {
        i = new Integer(10);
    }
}
