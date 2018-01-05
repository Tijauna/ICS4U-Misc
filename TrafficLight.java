import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class TrafficLight extends Applet 
    implements ActionListener
{
    int colourNum;
    Font textFont;
    Button bttn1 = new Button ("Red Light");
    Button bttn2 = new Button ("Yellow Light");
    Button bttn3 = new Button ("Green Light");
    Button bttn4 = new Button ("Advanced Green");

    public void init ()
    {
	setBackground (Color.lightGray);
	colourNum = 1;
	textFont = new Font ("Calibri", Font.BOLD, 24);
	bttn1.addActionListener (this);
	bttn2.addActionListener (this);
	bttn3.addActionListener (this);
	bttn4.addActionListener (this);
	add (bttn1);
	add (bttn2);
	add (bttn3);
	add (bttn4);
    }


    public void paint (Graphics g) 
    {
	switch (colourNum)
	{
	    case 1:

		g.setColor (Color.orange);

		g.fillRect (10, 30, 40, 100);

		g.setColor (Color.red);

		int xpos = 20;

		g.fillRect (xpos, 40, 20, 20);

		g.setColor (Color.gray);


		g.fillRect (xpos, 70, 20, 20);


		g.fillRect (xpos, 100, 20, 20);

		break;

	    case 2:

		g.setColor (Color.orange);

		g.fillRect (10, 30, 40, 100);

		g.setColor (Color.gray);

		xpos = 20;

		g.fillRect (xpos, 40, 20, 20);

		g.setColor (Color.yellow);


		g.fillRect (xpos, 70, 20, 20);

		g.setColor (Color.gray);


		g.fillRect (xpos, 100, 20, 20);


		break;

	    case 3:

		g.setColor (Color.orange);

		g.fillRect (10, 30, 40, 100);

		g.setColor (Color.gray);

		xpos = 20;

		g.fillRect (xpos, 40, 20, 20);


		g.fillRect (xpos, 70, 20, 20);

		g.setColor (Color.green);


		g.fillRect (xpos, 100, 20, 20);



		break;

	    case 4:

		g.setColor (Color.orange);

		g.fillRect (10, 30, 40, 100);

		g.setColor (Color.gray);

		xpos = 20;

		g.fillRect (xpos, 40, 20, 20);


		g.fillRect (xpos, 70, 20, 20);




		for (int ticker = 0 ; ticker < 2000 ; ticker++)
		{
		    g.setColor (Color.green);
		    g.fillRect (xpos, 100, 20, 20);

		    g.setColor (Color.gray);
		    g.fillRect (xpos, 100, 20, 20);
		}


		break;

	}

    }


    public void actionPerformed (ActionEvent evt)
    {

	if (evt.getSource () == bttn1)
	    colourNum = 1;
	else if (evt.getSource () == bttn2)
	    colourNum = 2;
	else if (evt.getSource () == bttn3)
	    colourNum = 3;
	else
	    colourNum = 4;

	repaint ();
    }
}


