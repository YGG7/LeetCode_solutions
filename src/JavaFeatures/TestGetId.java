package JavaFeatures;

public class TestGetId {

    public static void main(String[] args) {
        long currentThreadId = Thread.currentThread().getId();
        System.out.println(String.format("Current thread id: %d", currentThreadId));
    }

}

