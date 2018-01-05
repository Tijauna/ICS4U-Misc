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

public class template
{


    //generating ints from 1 to 16
    public static int generate ()
    {
	int randomInt = 1 + (int) (Math.random () * ((16 - 1) + 1));

	return randomInt;
    }


    public static void main (String str[]) throws IOException
    {
	BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
	DecimalFormat df = new DecimalFormat ("#.##");
	System.out.println ("hello.");

	int random;
	//the total number of tiles for this round of the game, increasing over time
	int generationCounter = 2;
	int tempCounter = 0;

	//answer array
	int[] answers = new int [15];


	int finish = 1;

	int kappa = 0;


	do
	{
	    tempCounter = 0;
	    finish = 1;

	    System.out.println ("game start");

	    do
	    {

		random = generate ();
		System.out.println ("generated");


		for (int i = 0 ; i <= generationCounter ; i++)
		{

		    //conflict check with existing answers
		    if (random == answers [i])
		    {
			finish = 0;
		    }


		}

		if (finish == 1)
		{

		    answers [tempCounter] = random;

		    tempCounter = tempCounter + 1;
		}



	    }
	    while (finish == 0);

	    for (int x = 0 ; x < generationCounter ; x++)
	    {

		System.out.println (answers [x]);

	    }


	    generationCounter = generationCounter + 1;


	    for (int z = 0 ; z < generationCounter ; z++)
	    {
		answers [z] = 0;
	    }



	}

	while (generationCounter <= 15)
	    ;


    }
}


