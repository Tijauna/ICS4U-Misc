/*--------------------------------------------------------------------------------------*/
/*  survivor.java  -  Program simulating TV show Survivor. Allows user to enter a list  */
/*  of contestant names in a circular linked list, backs up the list, allows user to    */
/*  remove eliminated survivors, and also displays all original contestants and winner. */
/*--------------------------------------------------------------------------------------*/
/*  Author: Daniel Ding                                                                 */
/*  Date:  January 4, 2016.                                                             */
/*--------------------------------------------------------------------------------------*/
/*  Input:  Contestant names, eliminated contestants                                    */
/*  Output:   Repeated list, winner                                                     */
/*--------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
import java.text.*;

public class survivor
{

    //show the overall contestant list
    static void contestants (Node backup, Node backupHead)
    {
	System.out.println (backup.data);

	//run through whole list once
	if (!backup.next.equals (backupHead))
	{
	    contestants (backup.next, backupHead);

	}

    }


    public static void main (String str[]) throws IOException
    {
	BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
	DecimalFormat df = new DecimalFormat ("#");

	Node node, head = null;
	Node backup, backupHead = null;
	String input, eliminate;

	//user enters contestants, finishes with 'fin' input
	System.out.println ("Welcome to the Survivor program.\nPlease enter names as needed; enter 'fin' to end input:");

	do
	{
	    //read the input
	    input = stdin.readLine ();

	    //if input is not 'fin' or finishing action, link the list
	    if (!input.equals ("fin"))
	    {
		node = new Node ();
		node.data = input;
		node.next = head;
		//reset head to latest position in list
		head = node;
	    }

	}
	while (!input.equals ("fin"));

	//return node to beginning of list
	node = head;

	//find node that has null pointer, in order to point it to the beginning and complete the circular list
	do
	{
	    node = node.next;
	}
	while (node.next != null);

	//points last entry in list (first input) to beginning of list
	node.next = head;

	//return node to beginning of list
	node = head;

	//backup the list into the 'backup' linked list
	do
	{
	    backup = new Node ();
	    backup.data = node.data;
	    backup.next = backupHead;
	    backupHead = backup;

	    //move onto the next node on the original linked list
	    node = node.next;
	}
	while (!node.equals (head));

	//return 'backup' to the beginning of the linked list
	backup = backupHead;

	//find node that has null pointer, in order to point it to the beginning and complete the circular list
	do
	{
	    backup = backup.next;
	}
	while (backup.next != null);

	//points last entry in list (first input) to beginning of list
	backup.next = backupHead;

	///return 'backup' to the beginning of the linked list
	backup = backupHead;



	//this portion of the program allows the user to delete contestants from the game, until only one is left
	int found = 0;
	System.out.println ();

	//loop the program until a node points to itself; eg. one node left in a circular list
	do
	{

	    //loop input
	    do
	    {
		found = 0;

		System.out.println ("Please enter the name of the eliminated contestant:");

		eliminate = stdin.readLine ();
		System.out.println ();

		//look for contestant name
		do
		{
		
		    //remove a node from the linked list if the search term is found, delete next node to make it easier to loop
		    if (eliminate.equals (node.next.data))
		    {
			//skip the next node; delete
			System.out.println ("ELIMINATED " + node.next.data + "!");
			System.out.println ();

			head = node.next;

			node.next = node.next.next;

			found = 1;

			//end the loop when deleted
			break;
		    }

		    //search in the next node
		    node = node.next;

		}
		while (!node.equals (head));

		//name validation
		if (found != 1)
		{
		    System.out.println ("Contestant does not exist! Try again:");
		}

	    }
	    while (found != 1);

	}
	while (!node.equals (node.next));


	System.out.println ("\n\n");

	//call the recursive method in order to display the original list of contestants
	System.out.println ("ORIGINAL CONTESTANTS:\n________________________");

	contestants (backup, backupHead);

	System.out.println ("\n\n");


	//show the winner
	System.out.println ("THE WINNER OF SURVIVOR IS: " + node.data + "!");
    }
}


