
import java.util.TimerTask;


public class GameEngine extends TimerTask 
{
	private boolean gameStarted = false;
	private boolean okToReceiveUserInput = true;
	private boolean userLost = false;
	private int userGameButtonInput = 0;
	private boolean readyForGameButtonInput = false;
	
	

	
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
			
			System.out.println("game looping");
			
			while (gameStarted == true && userLost == false)
			{
				System.out.println("game loop started");
				
				MainView.updateStatusText("Game Started!");
				
				okToReceiveUserInput = false;
				readyForGameButtonInput = false;
				
				/*
				 *  generate the next sequence here with additional code
				 */
				
				/*
				 *  display the sequence to the GUI here with additional code
				 */
				
				// allow the button presses to be used again
				okToReceiveUserInput = true;
				
				// allow for game button input
				readyForGameButtonInput = true;
				
				/*
				 * This loop waits for the user input
				 */
				while (readyForGameButtonInput == true && gameStarted == true)
				{
					if (userGameButtonInput > 0)
					{
						/*
						 * Ask the GUI to flash the button the user hit.
						 */
						switch (userGameButtonInput)
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
						if (true) // needs condition
						{
							userGameButtonInput = 0;
							
							System.out.println("button press digested");
							
							// get the next color needed ready
						}
						else // it didn't match
						{
							userGameButtonInput = 0;
							userLost = true;
							readyForGameButtonInput = false;
						}

						
						/*
						 *  if that was the last element from the queue, and the user got them all correct, 
						 *  turn off readyForGameButtonInput to allow the while loop to close, and move
						 *  back to the top of the game loop to generate the next sequence
						 */
						if(true) // needs condition
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
						
						// set this to end the game loop and allow the user to restart the game
						gameStarted = false;
						okToReceiveUserInput = true;
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
		}
	}
	
	public void reportResetPressed()
	{
		if(okToReceiveUserInput == true && gameStarted == true)
		{
			System.out.println("reset request received");
			
			gameStarted = false;
			
			MainView.updateStatusText("Game Reset!");
		}
	}
	
	public void reportGreenPressed()
	{
		if(okToReceiveUserInput == true && readyForGameButtonInput == true)
		{
			System.out.println("green button press received");
			
			userGameButtonInput = 1;
		}
	}
	
	public void reportRedPressed()
	{
		if(okToReceiveUserInput == true && readyForGameButtonInput == true)
		{
			System.out.println("red button press received");
			
			userGameButtonInput = 2;
		}
	}
	
	public void reportYellowPressed()
	{
		if(okToReceiveUserInput == true && readyForGameButtonInput == true)
		{
			System.out.println("yellow button press received");
			
			userGameButtonInput = 3;
		}
	}
	
	public void reportBluePressed()
	{
		if(okToReceiveUserInput == true && readyForGameButtonInput == true)
		{
			System.out.println("blue button press received");
			
			userGameButtonInput = 4;
		}
	}
	
	
	
	
	

	
}