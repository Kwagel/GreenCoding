public class FizzBuzz {
    public static void main(String[] args) {
        fizzBuzz(10000);
    }
    
    public static void fizzBuzz(int num) {
        StringBuilder sb = new StringBuilder();
    
        for (int i = 1; i <= num; i++) {
            if (((i % 5) == 0) && ((i % 7) == 0)) // Is it a multiple of 5 & 7?
                sb.append("fizzbuzz\n");
            else if ((i % 5) == 0) // Is it a multiple of 5?
                sb.append("fizz\n");
            else if ((i % 7) == 0) // Is it a multiple of 7?
                sb.append("buzz\n");
            else
                sb.append(i).append("\n"); // Not a multiple of 5 or 7
        }
        System.out.println(sb);
    }
    
}
