import java.util.TimerTask;
import java.util.LinkedList;
import java.util.Queue;

public class GameEngine extends TimerTask 
{
	private boolean gameStarted = false;
	private boolean okToReceiveUserInput = true;
	private boolean userLost = false;
	private boolean readyForGameButtonInput = false;
	private MoveEngine sequence = new MoveEngine();
	
	// Create a Queue to be used to buffer user input.
	private Queue<Integer> userInputQueue = new LinkedList<Integer>();
	
	

	
	public void run() 
	{
		System.out.println("game engine run method called");
		
		/*
		 * Thread loop, this is the infinite loop of the game engine.
		 */
		while (true)
		{
			/*
			 * Game Loop
			 */
			
			Thread.yield();
			
			while (gameStarted == true && userLost == false)
			{
				System.out.println("game loop started");
				
				MainView.updateStatusText("Game Started!");
				
				okToReceiveUserInput = false;
				readyForGameButtonInput = false;
				
				// adds a move and displays the sequence
				
				sequence.addMove();
				
				MainView.updateLevelDisplay(sequence.getLevel());
				
				sequence.queueToScreen();
				
				
				// allow the button presses to be used again
				okToReceiveUserInput = true;
				
				// allow for game button input
				readyForGameButtonInput = true;
				
				/*
				 * This loop waits for the user input
				 */
				while (readyForGameButtonInput == true && gameStarted == true)
				{
					if (userInputQueue.size() > 0)
					{
						/*
						 * Retrieve the next buffered user input to work with.
						 */
						int lastUserInput = (int) userInputQueue.remove();
						
						
						/*
						 * Ask the GUI to flash the button the user hit.
						 */
						switch (lastUserInput)
						{
							case 1:{
								MainView.illumPanelGreen();
								break;
							}
							case 2:{
								MainView.illumPanelRed();
								break;
							}
							case 3:{
								MainView.illumPanelYellow();
								break;
							}
							case 4:{
								MainView.illumPanelBlue();
								break;
							}
						}
								
						
						/*
						 * 	check to see if the user input matches the next required color from the queue here
						 *  if it does match, clear the input to allow the loop to continue for the
						 *  next user input
						 */
						int numToCheck = sequence.getValue();
						
						System.out.println("User Input is " + lastUserInput + " : System Number is " + numToCheck);
						if (lastUserInput == numToCheck) // needs condition
						{
							// it matched, need to do anything?
	
						}
						else // it didn't match
						{
							userLost = true;
							readyForGameButtonInput = false;
						}
						

						
						/*
						 *  if that was the last element from the queue, and the user got them all correct, 
						 *  turn off readyForGameButtonInput to allow the while loop to close, and move
						 *  back to the top of the game loop to generate the next sequence
						 */
						if(sequence.checkSize() == 0) // needs condition
						{
							
							readyForGameButtonInput = false;
						}
						
					}
					
					/*
					 * check to see if the user lost
					 */
					if (userLost == true)
					{
						/*
						 *  end the game
						 *  
						 *  write a message to the GUI etc.
						 */
						MainView.updateStatusText("You Lost!!!");
						
						// set this to end the game loop and allow the user to restart the game
						gameStarted = false;
						okToReceiveUserInput = true;
						sequence.removeAll();
					}
					
					
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
								
			} // end while - game loop
			
		} // end while - thread loop
		
	} // end run()
	
		
	
	
	
	/*
	 * Below are methods that the GUI will be calling
	 * to report user actions.
	 */
	
	
	public void reportStartPressed()
	{
		if(okToReceiveUserInput == true && gameStarted == false)
		{
			System.out.println("start request received");
			
			gameStarted = true;
			
			userLost = false;
		}
	}
	
	public void reportResetPressed()
	{
		if(okToReceiveUserInput == true && gameStarted == true)
		{
			System.out.println("reset request received");
			
			gameStarted = false;
			
			sequence.removeAll();
			
			MainView.updateLevelDisplay(sequence.getLevel());
			
			MainView.updateStatusText("Game Reset!");
			
			
		}
	}
	
	public void reportGreenPressed()
	{
		if(okToReceiveUserInput == true && readyForGameButtonInput == true)
		{
			System.out.println("green button press received");
			
			userInputQueue.add((int)1);
			
			
		}
	}
	
	public void reportRedPressed()
	{
		if(okToReceiveUserInput == true && readyForGameButtonInput == true)
		{
			System.out.println("red button press received");
			
			userInputQueue.add((int)2);
		}
	}
	
	public void reportYellowPressed()
	{
		if(okToReceiveUserInput == true && readyForGameButtonInput == true)
		{
			System.out.println("yellow button press received");
			
			userInputQueue.add((int)3);
		}
	}
	
	public void reportBluePressed()
	{
		if(okToReceiveUserInput == true && readyForGameButtonInput == true)
		{
			System.out.println("blue button press received");
			
			userInputQueue.add((int)4);
		}
	}
	
	
	
	
	

	
}
