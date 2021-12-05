    package Task2;


    public class Calculations implements AutoCloseable {

        public void getCalc() {
            System.out.println(2 + 2);
        }
@Override
        public void close() throws Exception {
            System.out.println("Closed");
        }
    }