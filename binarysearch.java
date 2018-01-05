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

public class binarysearch
{

    //recursive search method
    static void recursiveSearch (String phone, String[] array, int min, int max, int counter)
    {

	//base case, term cannot be found
	if (min > max)
	{
	    System.out.println ("The search term could not be found.");
	    System.out.println ("Comparison Operations:" + counter);

	}

	//recursion
	else
	{
	    //count number of searches required
	    counter = counter + 1;
	    System.out.println ("Searching...");

	    //if search term is found
	    if (phone.compareTo (array [(min + max) / 2]) == 0)
	    {
		System.out.println ("Found:" + array [(min + max) / 2]);
		int location = (min + max) / 2;
		System.out.println ("Array Location (with array [0] as first): " + location + ".");
		System.out.println ("Comparison Operations:" + counter);
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


    //linear search method
    static void linearSearch (String phone, String[] array, int max, int counter)
    {

	//declare found variable
	int found = 0;

	//intialize loop for search
	for (int i = 0 ; i < max ; i++)
	{

	    //count comparison operations
	    counter = counter + 1;

	    //if found print relevant information
	    if (phone.compareTo (array [i]) == 0)
	    {
		System.out.println ("Found:" + array [i]);
		System.out.println ("Array Location (with array [0] as first): " + i + ".");
		System.out.println ("Comparison Operations:" + counter);

		found = 1;
	    }
	}

	//if not found tell user that term does not exist
	if (found == 0)
	{

	    System.out.println ("The search term could not be found.");

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
	int entries = 0, counter = 0, selection;
	String phone;

	//read all telelphone numbers into an array
	BufferedReader reader = new BufferedReader (new FileReader ("phone.txt"));

	for (int i = 0 ; i < maximum ; i++)
	{

	    array [i] = reader.readLine ();
	    entries = entries + 1;

	}

	//total entries
	System.out.println ("Total entries in phone.txt: " + entries + ".");

	//request search term from user
	System.out.println ("Please enter the telephone number that you wish to search for (xxx-xxx-xxxx):");

	phone = stdin.readLine ();

	//request search method from user
	System.out.println ("Please select search method: \n1. Recursion \n2. Linear");

	selection = Integer.parseInt (stdin.readLine ());

	//switch for search methods
	switch (selection)
	{

		//recursive search
	    case 1:

		int max = entries - 1;
		int min = 0;

		recursiveSearch (phone, array, min, max, counter);

		break;

		//linear search
	    case 2:

		max = entries - 1;

		linearSearch (phone, array, max, counter);

		break;

	}

    }
}


