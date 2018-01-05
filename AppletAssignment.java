/*--------------------------------------------------------------------------------------*/
/*  AppletAssignment.java  -  Applet that allows user to select and render a shape with */
/*  selected properties like size, shape, colour; also animates the shape               */
/*--------------------------------------------------------------------------------------*/
/*  Author:  Daniel Ding                                                                */
/*  Date:  April 4th, 2016                                                              */
/*--------------------------------------------------------------------------------------*/
/*  Input: User selects shape, size, colour, then renders or animates shape             */
/*  Output: Renders the shape as selected, or animates the shape across the screen      */
/*--------------------------------------------------------------------------------------*/

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class AppletAssignment extends Applet
    implements ActionListener
{
    //declare int variables needed
    int colourNum = 1;
    int shapeNum = 1;
    int shapeSize = 50;
    int animateStatus;

    //declare buttons
    Button draw = new Button ("Draw");
    Button animate = new Button ("Animate!");

    //declare checkboxes
    CheckboxGroup shapes, colours;
    Checkbox rectangle, circle, square, triangle;
    Checkbox red, green, blue, yellow;

    //declare text box size
    TextField size = new TextField (2);

    //timer for animation
    Timer tm = new Timer (30, this);
    int xpos = 20, counter = 5;


    //intialize method
    public void init ()
    {
	//declare radio button groups
	shapes = new CheckboxGroup ();
	colours = new CheckboxGroup ();

	//declare radio buttons
	rectangle = new Checkbox ("Rectangle", shapes, false);
	circle = new Checkbox ("Circle", shapes, false);
	triangle = new Checkbox ("Triangle", shapes, false);
	square = new Checkbox ("Square", shapes, false);
	red = new Checkbox ("Red", colours, false);
	green = new Checkbox ("Green", colours, false);
	blue = new Checkbox ("Blue", colours, false);
	yellow = new Checkbox ("Yellow", colours, false);

	//add buttons for shape select
	add (rectangle);

	add (circle);

	add (triangle);

	add (square);

	//add buttons for colour select
	add (red);

	add (green);

	add (blue);

	add (yellow);

	//add size box and draw/animate controls
	add (size);

	draw.addActionListener (this);

	add (draw);

	add (animate);

	animate.addActionListener (this);
    }


    //method for rendering the shape
    public void paint (Graphics g)
    {
	switch (colourNum)
	{
		//red
	    case 1:
		g.setColor (Color.red);
		break;

		//green
	    case 2:
		g.setColor (Color.green);
		break;

		//blue
	    case 3:
		g.setColor (Color.blue);
		break;

		//yellow
	    case 4:
		g.setColor (Color.yellow);
		break;
	}

	switch (shapeNum)
	{
		//rectangle
	    case 1:
		g.fillRect (xpos, 100, shapeSize, shapeSize * 2);
		break;

		//circle
	    case 2:
		g.fillOval (xpos, 100, shapeSize, shapeSize);
		break;

		//triangle
	    case 3:
		g.fillPolygon (new int[]
		{
		    shapeSize + xpos, 0 + xpos, shapeSize + xpos
		}
		, new int[]
		{
		    shapeSize, shapeSize + shapeSize, shapeSize + shapeSize + shapeSize
		}
		, 3);
		break;

		//square
	    case 4:
		g.fillRect (xpos, 100, shapeSize, shapeSize);

		break;
	}

	//start the timer for animation
	tm.start ();
    }


    //method for detecting user input and performing associated tasks
    public void actionPerformed (ActionEvent evt)
    {
	//check for button press (draw or animate)
	if (evt.getSource () == draw || evt.getSource () == animate)
	{

	    //set red
	    if (red.getState ())
	    {
		colourNum = 1;
	    }

	    //set green
	    else if (green.getState ())
	    {
		colourNum = 2;
	    }

	    //set blue
	    else if (blue.getState ())
	    {
		colourNum = 3;
	    }

	    //set yellow
	    else
	    {
		colourNum = 4;
	    }

	    //set rectangle
	    if (rectangle.getState ())
	    {
		shapeNum = 1;
	    }

	    //set circle
	    else if (circle.getState ())
	    {
		shapeNum = 2;
	    }

	    //set triangle
	    else if (triangle.getState ())
	    {
		shapeNum = 3;
	    }

	    //set square
	    else
	    {
		shapeNum = 4;
	    }

	    //check for no size input and output error as needed
	    try
	    {
		//read the size of the shape
		shapeSize = Integer.parseInt (size.getText ());
	    }

	    catch (Throwable t)
	    {
		//error output
		JOptionPane.showMessageDialog (null, "Exception or error " + t + " has occured!", "Exception or Error", 0);
	    }

	    //starting x position for shape animation
	    xpos = 10;

	    //check for animation button press, set animation status as required
	    if (evt.getSource () == animate)
	    {
		animateStatus = 1;
	    }

	    else
	    {
		animateStatus = 0;
	    }
	}

	//if animation button pressed, use the timer to move the horizontal location
	if (animateStatus == 1)
	{
	    animateStatus = 1;
	    xpos = xpos + counter;
	}

	//call the paint method to render the shape
	repaint ();
    }
}
