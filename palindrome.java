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

public class palindrome
{


    static void palindromeCheck (Node node, int length, int min, int max, int counter)
    {

	//System.out.println (node.data);

	String input = node.data;

	char test = input.charAt (min);

	//System.out.println (test);

	char test2 = input.charAt (max);

	//System.out.println (test2);


	if ((test == (test2)) && (counter != length - 1))
	{
	    palindromeCheck (node, length, min + 1, max - 1, counter + 1);
	}

	else if (counter == length || counter == length - 1)
	{
	    System.out.println ("Is palindrome.");

	}

	else
	{
	    System.out.println ("Is not palindrome.");

	}


    }



    public static void main (String str[]) throws IOException
    {
	BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
	DecimalFormat df = new DecimalFormat ("#");

	BufferedReader reader = new BufferedReader (new FileReader ("numberspalindrome.txt"));

	Node node, head = null;

	String input;

	int entries = 0;

	do
	{


	    input = reader.readLine ();

	    if (input != null)
	    {

		node = new Node ();

		node.data = input;

		//System.out.println (node.data);

		node.next = head;

		head = node;

		entries = entries + 1;


	    }



	}
	while (input != null);


	node = head;
	
	int length, min, max, counter;


	for (int i = 0 ; i < entries ; i++)
	{

	    length = node.data.length ();

	    System.out.println (node.data);
	    min = 0;
	    max = length - 1;
	    counter = 0;

	    palindromeCheck (node, length, min, max, counter);

	    node = node.next;

	}

    }
}


