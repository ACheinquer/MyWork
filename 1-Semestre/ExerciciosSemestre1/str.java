import java.util.*;
public class str
{
    public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in) ;
        int lin = 0;
        String [] str = new String[5] ;
        do
        {
            System.out.println("Insira a String") ;
            str [lin] = input.nextLine();
            lin++;
        }while(lin<5);
        
        for(int i = 0;i<str.length;i++)
        {
            System.out.println(str[i]);
        }
    }
}
