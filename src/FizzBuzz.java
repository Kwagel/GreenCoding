public class FizzBuzz {
    public static void main(String[] args) {
        fizzBuzz(10000);
        
    }
    
    public static void fizzBuzz(int num) {
        int i = 0;
        do {
            i++;
            if (((i % 5) == 0) && ((i % 7) == 0)) // Is it a multiple of 5 & 7?
                System.out.println("fizzbuzz");
            else if ((i % 5) == 0) // Is it a multiple of 5?
                System.out.println("fizz");
            else if ((i % 7) == 0) // Is it a multiple of 7?
                System.out.println("buzz");
            else
                System.out.println(i); // Not a multiple of 5 or 7
        } while (i < num);
        
        
    }
    
}
