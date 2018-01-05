/*--------------------------------------------------------------------------------------*/
/*  binarysearch.java  -  Program reads a sorted list of phone numbers into an array,   */
/*  allows user to search for a specific number using recursion or linear search        */
/*--------------------------------------------------------------------------------------*/
/*  Author:  Daniel Ding                                                                */
/*  Date:  November 21, 2015.                                                           */
/*--------------------------------------------------------------------------------------*/
/*  Input: Phone numbers, search number, search method selection                        */
/*  Output: Found search/not found, location of number in array, operations required    */
/*--------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
import java.text.*;

public class binarysearchAverageCase
{


    //recursive search method
    static void recursiveSearch (String phone, String[] array, int min, int max, int[] counter)
    {

	//base case, term cannot be found
	if (min > max)
	{
	    System.out.println ("The search term could not be found.");
	}

	//recursion
	else
	{
	    //count number of searches required
	    counter [0] = counter [0] + 1;


	    //if search term is found
	    if (phone.compareTo (array [(min + max) / 2]) == 0)
	    {
		System.out.println ("Found:" + array [(min + max) / 2]);
		System.out.println (counter [0]);

	    }

	    //search term is higher in value
	    else if (phone.compareTo (array [(min + max) / 2]) > 0)
	    {

		//shift min value higher
		min = ((min + max) / 2) + 1;

		recursiveSearch (phone, array, min, max, counter);

	    }

	    //search term is lower in value
	    else if (phone.compareTo (array [(min + max) / 2]) < 0)
	    {

		//shift max value lower
		max = ((min + max) / 2) - 1;

		recursiveSearch (phone, array, min, max, counter);

	    }

	}
    }




    //main method
    public static void main (String str[]) throws IOException
    {
	BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
	DecimalFormat df = new DecimalFormat ("#");

	//declare constants, variables, arrays
	final int maximum = 1500;
	String[] array = new String [maximum];

	int entries = 0, selection;
	String phone;

	//read all telelphone numbers into an array
	BufferedReader reader = new BufferedReader (new FileReader ("phone.txt"));

	for (int i = 0 ; i < maximum ; i++)
	{

	    array [i] = reader.readLine ();
	    entries = entries + 1;

	}



	double comparisons = 0;
	int[] counter = new int [1];




	for (int x = 0 ; x < 1500 ; x++)
	{

	    phone = array [x];

	    int max = entries - 1;
	    int min = 0;




	    recursiveSearch (phone, array, min, max, counter);

	    comparisons = comparisons + counter [0];


	    counter [0] = 0;

	}

	System.out.println (comparisons / entries);


    }
}



