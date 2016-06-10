import java.util.*;
import java.util.Random;

public class MoveEngine {
	protected int size = 0; 
	protected Queue<Integer> computerMoves = new LinkedList<Integer>(); 
	
	public void addMove(){
		Random randomGenerator = new Random();
		computerMoves.add(randomGenerator.nextInt(4));
		size++;
	}
	
	public void queueToScreen(){
		Queue<Integer> tempQueue = new LinkedList<Integer>(computerMoves); 
		
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
	
	public int getLevel(){
		return size;
	}
	
	public Queue<Integer> getMoves(){
		return computerMoves;
	}
	
	public void displayMove(int move){
		if (move == 0)
			 MainView.illumPanelGreen();
		if (move == 1)
			 MainView.illumPanelRed();
		if (move == 2)
			 MainView.illumPanelYellow();
		if (move == 3)
			 MainView.illumPanelBlue();
	}
	
	
}
