package Task4;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class HighMulti {
    public static void main(final String[] args) {
        final ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(() -> Operations.sum(10, 7));
        executor.submit(() -> Operations.difference(18, 8));
        executor.submit(() -> Operations.multiply(2,5));
        try {
            executor.shutdown();
        } catch (final Exception e) {
            executor.shutdown();
        } finally {
            executor.shutdownNow();
        }
    }
}