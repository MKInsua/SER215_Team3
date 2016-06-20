import java.util.*;
import java.util.Random;

public class MoveEngine {
	
	// Class Variables
	
	private int size = 0;
	private int numToCheck;
	private int count;
	private Queue<Integer> computerMoves = new LinkedList<Integer>();
	private Queue<Integer> checkQueue;
	private Queue<Integer> tempQueue;
	
	//Add the next move to the Queue, increases the size variable and sets the temp Queues to computerMoves.
	
	public void addMove(){
		Random randomGenerator = new Random();
		computerMoves.add((randomGenerator.nextInt(40) % 4) + 1);
		size++;
		tempQueue = new LinkedList<Integer>(computerMoves); 
		checkQueue = new LinkedList<Integer>(computerMoves);
	}
	
	//Displays the Queue to the GUI.
	
	public void queueToScreen(){
		
		for (int i = 0; i < size; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			displayMove(tempQueue.remove());
		}
	}
	
	//allows the GameEngine to pull the number for the head of the queue
	
	public int getValue(){
		
		numToCheck = checkQueue.remove();
		count = checkQueue.size();
		
		return numToCheck;
		
	}
	
	// returns the size of checkQueue
	
	public int checkSize(){
		
		return count;
	}
	
	// removes all elements from the Queue and resets size to 0
	
	public void removeAll(){
		
		while (computerMoves.size() > 0){
			computerMoves.remove();
		}
		size = 0;
	}
	
	//returns the size of computerMoves. Represents the level of the game
	
	public int getLevel(){
		return size;
	}
	
	//checks the value and displays appropriate panel
	
	private void displayMove(int move){
		if (move == 1)
			 MainView.illumPanelGreen();
		if (move == 2)
			 MainView.illumPanelRed();
		if (move == 3)
			 MainView.illumPanelYellow();
		if (move == 4)
			 MainView.illumPanelBlue();
	}
	
	
}

