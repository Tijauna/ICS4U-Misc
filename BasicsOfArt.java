/*--------------------------------------------------------------------------------------*/
/*  BasicsOfArt.java  -  lmao                                                           */
/*                                                                                      */
/*--------------------------------------------------------------------------------------*/
/*  Author:  Daniel Ding                                                                */
/*  Date:  April 18th, 2016                                                             */
/*--------------------------------------------------------------------------------------*/
/*  Input:                                                                              */
/*  Output:                                                                             */
/*--------------------------------------------------------------------------------------*/

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class BasicsOfArt extends Applet
    implements ActionListener
{

    //main UI images
    Image button1, button2, button3;
    Image homeBackground;

    //int variables
    int animateStatus;

    //declare buttons
    Button draw = new Button ("Draw");
    Button animate = new Button ("Animate!");

    //declare main ui buttons
    Button UI_1 = new Button ("");
    Button UI_2 = new Button ("");
    Button UI_3 = new Button ("");

    //declare text box size
    TextField size = new TextField (2);

    //timer for animation
    Timer tm = new Timer (30, this);
    int xpos = 20, counter = 5;


    //intialize method
    public void init ()
    {
	setLayout (null);

	//set size of the window
	this.setSize (750, 750);

	add (UI_1);
	UI_1.setBounds (100, 400, 150, 50);

	UI_1.addActionListener (this);

	add (UI_2);
	UI_2.setBounds (300, 400, 150, 50);

	UI_2.addActionListener (this);

	add (UI_3);
	UI_3.setBounds (500, 400, 150, 50);

	UI_3.addActionListener (this);

	
	homeBackground = getImage (getDocumentBase (), "background.jpg");

	button1 = getImage (getDocumentBase (), "basicbutton.png");
	button2 = getImage (getDocumentBase (), "basicbutton.png");
	button3 = getImage (getDocumentBase (), "basicbutton.png");

    }


    //method for rendering the shape
    public void paint (Graphics g)
    {

	//background
	g.drawImage (homeBackground, 0, 0, this);

	//draw homepage
	g.drawImage (button1, 100, 200, this);
	g.drawImage (button2, 300, 200, this);
	g.drawImage (button3, 500, 200, this);



    }


    //method for detecting user input and performing associated tasks
    public void actionPerformed (ActionEvent evt)
    {

    }
}
