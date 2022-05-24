import java.util.stream.IntStream;

public class FizzBuzz {
    public static void main(String[] args) {
        fizzBuzz(10000);
        
    }
    
    public static void fizzBuzz(int num) {
        IntStream.rangeClosed(1, num).mapToObj(i -> i % 5 == 0 ? (i % 7 == 0 ? "FizzBuzz" : "Fizz") : (
                i % 7 == 0 ? "Buzz" : i)).forEach(System.out::println);
        
    }
    
}
