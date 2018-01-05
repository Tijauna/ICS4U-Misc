/*--------------------------------------------------------------------------------------*/
/*  survivor.java  -  Program simulating TV show Survivor. Allows user to enter a list  */
/*  of contestant names in a circular linked list, backs up contestants to another      */
/*  linked list, allows user to remove eliminated survivors, and also displays          */
/*  all original contestants and the winner.                                            */
/*--------------------------------------------------------------------------------------*/
/*  Author: Daniel Ding                                                                 */
/*  Date:  January 4, 2016.                                                             */
/*--------------------------------------------------------------------------------------*/
/*  Input:  Contestant names, contestants to be eliminated                              */
/*  Output:   Repeated original list, remaining winner                                  */
/*--------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
import java.text.*;

public class survivorfinal
{

    //input method, allow the user to input a list of survivor contestants into a circular linked list
    static Node input (Node head) throws IOException
    {
	//reader for user input
	BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
	DecimalFormat df = new DecimalFormat ("#");

	//string variables used for contestant names and eliminated contestants
	String input;
	//counter for tracking number of contestants
	int counter = 0;
	//declare the node needed;
	Node node;

	//user enters contestants, finishes with 'fin' input
	System.out.println ("***Welcome to the Survivor program!***\n------------------------------------------\nPlease enter names of contestants as needed; enter 'fin' to end input:");

	do
	{
	    //read the input
	    input = stdin.readLine ();

	    //if input is not 'fin', link the list
	    if (!input.equals ("fin"))
	    {
		node = new Node ();
		node.data = input;
		node.next = head;
		//reset head to latest position in list
		head = node;

		//count total number of contestants
		counter = counter + 1;
	    }

	    //validation: check to make sure game has more than one survivor, if user attempts to end input deliver error and continue
	    if ((input.equals ("fin")) && (counter < 2))
	    {
		System.out.println ("*Sorry, the game requires at least two contestants.\nPlease enter at least one more contestant:\n");
		input = ("x");
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

	//return head to the main method, in order to use it to access this linked list
	return head;

    }


    //the backup method, duplicate the user list of contestants into a seperate linked list, return the head of the backup list
    static Node backupMethod (Node head)
    {
	//declare nodes as required, standard setup with the original head, a backup node and a backup head
	Node node;
	Node backup, backupHead = null;


	node = head;

	//Backup the linked list into a new list
	do
	{
	    backup = new Node ();
	    backup.data = node.data;
	    backup.next = backupHead;
	    backupHead = backup;

	    //move to the next position node
	    node = node.next;
	}
	while (!node.equals (head));

	//run through list until backup hits head, or null, in order to complete the circular list
	do
	{
	    backup = backup.next;
	}
	while (backup.next != null);

	//complete the circular list, link the last entry with the first
	backup.next = backupHead;

	//return backupHead to main method
	return backupHead;
    }


    //the following method allows the user to delete contestants from the game, until only one is left
    static Node elimination (Node head) throws IOException
    {
	//reader for user input
	BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
	DecimalFormat df = new DecimalFormat ("#");

	//declare variables needed for deletion - A string for the actual input and an integer for found condition
	String eliminate;
	int found = 0;
	//declare the node needed
	Node node;

	//assign node to the head
	node = head;

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

			//check if head is equal to node.next, if so, point head to the next node in order to continue the list
			if (node.next.equals (head))
			{
			    head = node.next.next;
			}

			//delete the next node by removing it from the loop
			node.next = node.next.next;

			found = 1;
		    }

		    //move node forward to then next search position
		    node = node.next;

		}
		while (!node.equals (head));

		//name validation, tell user if contestant entered does not exist
		if (found != 1)
		{
		    System.out.println ("Contestant does not exist! Try again:");
		}

	    }
	    while (found != 1);

	}
	while (!node.equals (node.next));


	System.out.println ("\n\n");

	//return node with winner to the main method, in order to use it to access the final list
	return node;

    }


    //show the overall contestant list
    static void contestants (Node backup, Node backup2)
    {
	System.out.println (backup.data);

	//run through whole list once
	if (!backup.next.equals (backup2))
	{
	    contestants (backup.next, backup2);
	}
    }


    //main method
    public static void main (String str[]) throws IOException
    {
	//reader for user input
	BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
	DecimalFormat df = new DecimalFormat ("#");

	//declare nodes for main linked list and backup linked list, main node and head for each
	Node node, head = null;
	Node backup, backupHead = null;

	//call the input method, allow the user to enter the list of contestants into a linked list
	head = input (head);

	node = head;

	//call the backup method, save the current linked list to a duplicate linked list by passing the head of the main list to the method
	backup = backupMethod (head);

	//call the elimination method; allows the user to delete contestants from the list until only one winner is remaining
	node = elimination (node);

	//Show user the original full list of contestants
	System.out.println ("ORIGINAL CONTESTANTS:\n________________________");

	//call the recursive method in order to display the original list of contestants
	contestants (backup, backup);
	System.out.println ("\n\n");

	//show the final winner of the game
	System.out.println ("THE WINNER OF SURVIVOR IS: " + node.data + "!");
    }
}
