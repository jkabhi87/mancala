/**
 * Human.java
 */

import java.io.*;

public class Human extends Player 
{
	public static final int SLEEP_TIME = 20;
	public static int choice = -1;
    public void move(GameState context)
    {
    	//reset the choice from board
    	choice = -1;
    	
    	int random = (int )(Math.random() * 6);
    	while(context.illegalMove(random)){
    		random = (int )(Math.random() * 6);
    		
    	}
    	move = random;
    	
    	//try to get the choice from GUI
    	while (choice == -1)
    	{
    		Utility.tSleep(SLEEP_TIME);
    	}
    	//transform from the index of the bins to the choice
    	if (choice < 6)
    		move = choice;
    	else
    		move = choice - 6;
    	choice = -1;
    }
}
