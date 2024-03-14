import java.util.Arrays;

public class sumTriangle {
    public static void main(String[] args)
  {
    

    int[] x = { 1, 2, 3, 4, 5 };
   
    printTriangle(x);
    System.out.println(Arrays.toString(x));
  }
static void printTriangle(int[] x)
{
    //base condition
    if (x.length == 1) {
        return;
    }
   
    int[] temp = new int[x.length - 1];
    
    helper(temp, x, 0);
    
    printTriangle(temp);
    //prints String format of temp Array//
    System.out.println(Arrays.toString(temp));
}
  //Recursive function to fill elements in temp Array//
static int[] helper(int[] temp, int[] x, int index)
{
    //base condition//
    if (index == x.length - 1) {
        return temp;
    }
    temp[index] = x[index] + x[index + 1];
    //Recursive Call for helper() function//
    return helper(temp, x, index + 1);
  
    }
}
