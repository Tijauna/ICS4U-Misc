/*--------------------------------------------------------------------------------------*/
/*  template.java  -  Description                                                       */
/*                                                                                      */
/*--------------------------------------------------------------------------------------*/
/*  Author:                                                                             */
/*  Date:                                                                               */
/*--------------------------------------------------------------------------------------*/
/*  Input:                                                                              */
/*  Output:                                                                             */
/*--------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
import java.text.*;

public class fibonacci
{

    static void fibonaccicheck (int input, int number1, int number2, int sum, int counter)
    {
	sum = number1 + number2;
	counter = counter + 1;

	if (counter < input - 1)
	{
	    fibonaccicheck (input, number1 = number2, number2 = sum, sum, counter);

	}

	else
	{
	    System.out.println (sum);

	}

    }


    public static void main (String str[]) throws IOException
    {
	BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
	DecimalFormat df = new DecimalFormat ("#.##");



	int number1 = 0, number2 = 1, sum = 0;
	int counter = 0;
	int input = 0;


	input = Integer.parseInt (stdin.readLine ());

	if (input == 0)
	{
	    System.out.println ("0");
	}

	else
	{

	    fibonaccicheck (input, number1, number2, sum, counter);

	}



    }
}


