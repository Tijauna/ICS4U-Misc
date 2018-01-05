/*--------------------------------------------------------------------------------------*/
/*  funtest.java  -  so much fun                                                        */
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

public class funtest
{

    static void drawing (double height)
    {

	double counter = 0;

	do
	{
	    double i = height - 1;

	    for (double a = i ; i > 0 ; i--)
	    {
		System.out.print (" ");

	    }

	    for (double b = 0 ; b <= counter ; b++)
	    {
		System.out.print ("*");
	    }

	    height = height - 1;
	    counter = counter + 1;
	    System.out.println ();
	}
	while (height > 0);

    }


    static void pyramid (double height)
    {

	double counter = 0;
	double counterTwo = 0;

	do
	{
	    double i = height - 1;

	    for (double a = i ; i > 0 ; i--)
	    {
		System.out.print (" ");
	    }

	    for (double b = 0 ; b <= counter ; b++)
	    {
		System.out.print ("^");
	    }

	    //for (double c = 0 ; c < counter ; c++)
	    //{
	    //System.out.print ("*");
	    //}

	    height = height - 1;
	    counter = counter + 2;
	    //counterTwo = counterTwo + 1;


	    System.out.println ();
	}
	while (height > 0);
    }


    public static void main (String str[]) throws IOException, InterruptedException
    {
	BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
	DecimalFormat df = new DecimalFormat ("#");

	System.out.println ("Please select which shape you would like to generate:\n1. Reverse Triangle\n2. Pyramid\n3. Exiterino");
	int selection = Integer.parseInt (stdin.readLine ());

	switch (selection)
	{
	    case 1:

		System.out.println ("Please enter the height of the triangle .");
		double width = Double.parseDouble (stdin.readLine ());

		drawing (width);
		break;

	    case 2:
		System.out.println ("Please enter the height of the pyramid .");
		double widthTwo = Double.parseDouble (stdin.readLine ());

		pyramid (widthTwo);
		break;

	    case 3:
		System.exit (0);
		break;

	}

    }
}


