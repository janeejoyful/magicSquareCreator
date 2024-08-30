// Lab15astv110.java
// Janee Yeak
// 21 April 2021
// This program creates a magic square of any size. It also confirms by checking all the rows
// columns and diagonals to make sure they all add up to the same number.

import java.util.Scanner;
import java.text.DecimalFormat;

public class Lab15astv110
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

      System.out.print("Enter the odd# size of the Magic Square -->  ");
      int size = input.nextInt();
      MagicSquare magic = new MagicSquare(size);

      magic.computeMagicSquare();
      magic.displayMagicSquare();
     	magic.checkRows();          
   	magic.checkColumns();		 
   	magic.checkDiagonals();	 	 
	}
}


class MagicSquare
{
	private int size;
	private int[][] magic;
	private DecimalFormat output;

	public MagicSquare(int s)
	{
		size = s;
		magic = new int[size][size];
		output = new DecimalFormat("000");
	}

	public void computeMagicSquare()
	{
      int hi = 1;
      int column = size / 2;
      int sizeSq = size * size;
      int row = 0;
      int bottom = size - 1;
      
      magic [row] [column] = hi; 

      for (int k = sizeSq - 2; k >= 0; k--)
      {
         hi++;
         
         if ((hi % size == 1) && (hi > size))
         {
            row++;
            if ( row < 0 ) { row = size - 1; }
            if ( column >= size ) { column = 0; }
            magic [row] [column] = hi; 
              
         }
         
         else {
            row--;
            column++;  

            if ( row < 0 ) { row = bottom; }
         
            if ( column >= size ) { column = 0; }
                          
            magic [row] [column] = hi;
            
        }
     }
   }

	public void displayMagicSquare()
	{
		System.out.println();
		System.out.println(size + "x" + size + " Magic Square");
		System.out.println("==================");
		System.out.println();
      
      for ( int [ ] row : magic) 
	   {
		   for ( int number : row)
		   {
           System.out.print(output.format(number) + " ");
		   }
		
		 System.out.println();
	   }      
	}

	public void checkRows()
	{
		System.out.println();
		System.out.println("Checking Rows");
		System.out.println("=============");
		System.out.println();
      
      int sum = 0;
      String addition = "";
      
       for (int k = 0; k <= size - 1; k++)
      {
         for (int a = 0; a <= size - 1; a++)
         {
            sum += magic[k][a];
            addition += output.format(magic[k][a]) + "+";
         }
         
         int len = addition.length();
         String addition2 = addition.substring(0, len - 1);
         System.out.println(addition2 + " = " + sum);
         sum = 0;
         addition = "";
      }
         
      System.out.println();
	}

	public void checkColumns()
	{
		System.out.println();
		System.out.println("Checking Columns");
		System.out.println("================");
		System.out.println();
      
      int sum = 0;
      String addition = "";
      
      for (int k = 0; k <= size - 1; k++)
      {
         for (int a = 0; a <= size - 1; a++)
         {
            sum += magic[a][k];
            addition += output.format(magic[a][k]) + "+";
         }
         
         int len = addition.length();
         String addition2 = addition.substring(0, len - 1);
         System.out.println(addition2 + " = " + sum);
         
         sum = 0;
         addition = "";
      }

    
        System.out.println();

   }

	public void checkDiagonals()
	{
		System.out.println();
		System.out.println("Checking Diagonals");
		System.out.println("==================");
		System.out.println();
      
      int sum = 0;
      int row2 = size - 1;
      String addition = "";
      int j = 0;

      for (int k = 0; k <= size - 1; k++)
      { 
         sum += magic[j][k]; 
         addition += output.format(magic[j][k]) + "+";
         j++;
      }
      
      int len = addition.length();
      String addition2 = addition.substring(0, len - 1);
      System.out.println(addition2 + " = " + sum);
      sum = 0;
      addition = ""; 
      j = 0;
          
      for (int k = size - 1; k >= 0; k--)
      { 
         sum += magic[j][k]; 
         addition += output.format(magic[j][k]) + "+";
         j++;
      }
     
      len = addition.length();
      addition2 = addition.substring(0, len - 1);
      System.out.println(addition2 + " = " + sum);
	}
   
}

