import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;



public class MainView 
{
	/*
	 * class variables
	 */
	private JFrame frame;
	public static MainView window;
	private static JPanel panelTitle;
	private static JPanel panelButtons;
	private static JPanel panel0;
	private static JPanel panel1;
	private static JPanel panel2;
	private static JPanel panel3;
	
	/*
	 * Some button colors...
	 */
	private static Color darkGreen = new Color(0, 102, 0);
	private static Color lightGreen = new Color(51, 255, 51);
	
	private static Color darkRed = new Color(153, 0, 0);
	private static Color lightRed = new Color(255, 0, 0);
	
	private static Color darkBlue = new Color(0, 0, 102);
	private static Color lightBlue = new Color(51, 51, 255);
	
	private static Color darkYellow = new Color(204, 204, 0);
	private static Color lightYellow = new Color(255, 255, 51);
	
	
	// Create timers that will be used later to trigger threaded tasks.
	private static Timer timer_Panel0 = new Timer();
	private static Timer timer_Panel1 = new Timer();
	private static Timer timer_Panel2 = new Timer();
	private static Timer timer_Panel3 = new Timer();

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		
		/*
		 * create and display the main GUI window
		 */
		try 
		{
			// create the main GUI window
			window = new MainView();
			
			// makes the window visible after it is instantiated
			window.frame.setVisible(true); 
			
			// do not let the user resize the window
			window.frame.setResizable(false); 
			
			/*
			 *  Close all background processes on a user window close, if this
			 *  is not done, only the window gets closed, but the Java app continues to run in the
			 *  background.
			 */
			window.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}

		//testing
		MoveEngine test = new MoveEngine();
		test.addMove();
		test.queueToScreen();
		test.addMove();
		test.queueToScreen();
		test.addMove();
		test.queueToScreen();
		test.addMove();
		test.queueToScreen();
		test.addMove();
		test.queueToScreen();
		
	}

	/**
	 * Create the application via the
	 * class constructor.
	 */
	public MainView() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		/*
		 *  Main window
		 */
		frame = new JFrame();
		frame.setBounds(100, 100, 364, 439);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/*
		 *  Title panel
		 */
		panelTitle = new JPanel();
		panelTitle.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitle.setBounds(10, 11, 329, 82);
		frame.getContentPane().add(panelTitle);
		panelTitle.setLayout(null);
		
		/*
		 *  Organizational panel for buttons to reside in
		 */
		panelButtons = new JPanel();
		panelButtons.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelButtons.setBounds(10, 101, 329, 288);
		frame.getContentPane().add(panelButtons);
		panelButtons.setLayout(null);
		
		/*
		 * The buttons that make up the game GUI are below.  
		 * 
		 * I am using JPanel objects instead of JButtons because the JPanel objects
		 * are much easier to modify colors of programmatically.
		 */
		
		/*
		 * The green button panel.
		 */
		panel0 = new JPanel();
		panel0.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				lightenPanel0();
			}
		});
		panel0.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel0.setBackground(darkGreen);
		panel0.setBounds(10, 11, 150, 125);
		panelButtons.add(panel0);
		
		/*
		 * The red button panel.
		 */
		panel1 = new JPanel();
		panel1.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				lightenPanel1();
			}
		});
		panel1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel1.setBackground(darkRed);
		panel1.setBounds(170, 11, 150, 125);
		panelButtons.add(panel1);
		
		/*
		 * The yellow button panel.
		 */
		panel2 = new JPanel();
		panel2.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				lightenPanel2();
			}
		});
		panel2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel2.setBackground(darkYellow);
		panel2.setBounds(10, 152, 150, 125);
		panelButtons.add(panel2);
		
		/*
		 * The blue button panel.
		 */
		panel3 = new JPanel();
		panel3.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				lightenPanel3();
			}
		});
		panel3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel3.setBackground(darkBlue);
		panel3.setBounds(170, 152, 150, 125);
		panelButtons.add(panel3);
	} // end initialize
	
	
	public static void lightenPanel0()
	{
		// Set the background color to a lighter color.
		panel0.setBackground(lightGreen);
		
		
		// Create an instance of the task to be scheduled.
		Task_Panel0Dim task = new Task_Panel0Dim();
		
		// Schedule a task to run after a delay.
		timer_Panel0.schedule(task, 500);
	
	}
	
	public static void dimPanel0()
	{
		// Set the background back to it's default color.
		panel0.setBackground(darkGreen);
		
	}
	
	public static void lightenPanel1()
	{
		// Set the background color to a lighter color.
		panel1.setBackground(lightRed);
		
		
		// Create an instance of the task to be scheduled.
		Task_Panel1Dim task = new Task_Panel1Dim();
		
		// Schedule a task to run after a delay.
		timer_Panel1.schedule(task, 500);
	
	}
	
	public static void dimPanel1()
	{
		// Set the background back to it's default color.
		panel1.setBackground(darkRed);
		
	}
	
	public static void lightenPanel2()
	{
		// Set the background color to a lighter color.
		panel2.setBackground(lightYellow);
		
		
		// Create an instance of the task to be scheduled.
		Task_Panel2Dim task = new Task_Panel2Dim();
		
		// Schedule a task to run after a delay.
		timer_Panel2.schedule(task, 500);
	
	}
	
	public static void dimPanel2()
	{
		// Set the background back to it's default color.
		panel2.setBackground(darkYellow);
		
	}
	
	public static void lightenPanel3()
	{
		// Set the background color to a lighter color.
		panel3.setBackground(lightBlue);
		
		
		// Create an instance of the task to be scheduled.
		Task_Panel3Dim task = new Task_Panel3Dim();
		
		// Schedule a task to run after a delay.
		timer_Panel3.schedule(task, 500);
	
	}
	
	public static void dimPanel3()
	{
		// Set the background back to it's default color.
		panel3.setBackground(darkBlue);
		
	}
	
	
	
	
	
	
	
}
