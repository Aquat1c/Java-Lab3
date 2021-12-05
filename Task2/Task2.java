package Task2;

public class Task2 {
    public static void main(String[] args){
        try (Calculations calc = new Calculations()){
            calc.getCalc();
        } catch(Exception e){
            System.out.println("Exception block");
        }
    }
}
