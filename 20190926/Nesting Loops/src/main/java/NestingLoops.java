public class NestingLoops
        // 1. Look at the first set of nested loops ("CN"). Which variable changes faster? Is it the variable
        // controlled by the outer loop (c) or the variable controlled by the inner loop (n)? Answer in a comment.

        // n because it always loops 3 times until going back to the outer loop.

        // 2. Change the order of the loops so that the "c" loop is on the inside and the "n" loop is on the outside.
        // How does the output change?

        // all the outputs are in ascending order and organized by letters and numbers

        //3. Look at the second set of nested loops ("AB"). Change the print() statement to println().
        // How does the output change? (Then change it back to print().)

        // they are now all in a row instead of next to each other.

        //4 .Add a System.out.println() statement after the close brace of the inner loop (the "b" loop),
        // but still inside the outer loop. How does the output change?

        // at the end of each outer loop run it goes to the next line.
{
    public static void main( String[] args )
    {
        // this is #1 - I'll call it "CN"
        for ( int n=1; n <= 3; n++ )
        {
            for ( char c='A'; c <= 'E'; c++ )
            {
                System.out.println( c + " " + n );
            }
        }

        System.out.println("\n");

//         this is #2 - I'll call it "AB"
        for ( int a=1; a <= 3; a++ )
        {
            for ( int b=1; b <= 3; b++ )
            {
                System.out.print( a + "-" + b + " " );
            }
            // * You will add a line of code here.
            System.out.println();
        }

        System.out.println("\n");

    }
}
