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
	private static JPanel panelGreen;
	private static JPanel panelRed;
	private static JPanel panelYellow;
	private static JPanel panelBlue;
	private static final long ILLUMINATIONTIME = 500;
	
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
	
	private static Color black = new Color(0, 0, 0);
	
	
	
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
		panelButtons.setBackground(black);
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
		panelGreen = new JPanel();
		panelGreen.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				illumPanelGreen();
			}
		});
		panelGreen.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelGreen.setBackground(darkGreen);
		panelGreen.setBounds(10, 11, 150, 125);
		panelButtons.add(panelGreen);
		
		/*
		 * The red button panel.
		 */
		panelRed = new JPanel();
		panelRed.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				illumPanelRed();
			}
		});
		panelRed.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelRed.setBackground(darkRed);
		panelRed.setBounds(170, 11, 150, 125);
		panelButtons.add(panelRed);
		
		/*
		 * The yellow button panel.
		 */
		panelYellow = new JPanel();
		panelYellow.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				illumPanelYellow();
			}
		});
		panelYellow.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelYellow.setBackground(darkYellow);
		panelYellow.setBounds(10, 152, 150, 125);
		panelButtons.add(panelYellow);
		
		/*
		 * The blue button panel.
		 */
		panelBlue = new JPanel();
		panelBlue.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				illumPanelBlue();
			}
		});
		panelBlue.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBlue.setBackground(darkBlue);
		panelBlue.setBounds(170, 152, 150, 125);
		panelButtons.add(panelBlue);
	} // end initialize
	
	/**
	 * Illuminate the panel.  Also creates a new thread
	 * that will return the panel to a dimmed state after a
	 * period of time.
	 */
	public static void illumPanelGreen()
	{
		// Set the background color to a lighter color.
		panelGreen.setBackground(lightGreen);		
		
		// Create an instance of the task to be scheduled.
		Task_PanelGreenDim task = new Task_PanelGreenDim();
		
		// Create an instance of a timer for scheduling the task.
		Timer timer = new Timer();
		
		// Schedule a task to run after a delay.
		timer.schedule(task, ILLUMINATIONTIME);
	
	}
	
	/**
	 * Returns the panel to a default state - not illuminated.
	 */
	public static void dimPanelGreen()
	{
		// Set the background back to it's default color.
		panelGreen.setBackground(darkGreen);
		
	}
	
	/**
	 * Illuminate the panel.  Also creates a new thread
	 * that will return the panel to a dimmed state after a
	 * period of time.
	 */
	public static void illumPanelRed()
	{
		// Set the background color to a lighter color.
		panelRed.setBackground(lightRed);
		
		// Create an instance of the task to be scheduled.
		Task_PanelRedDim task = new Task_PanelRedDim();
		
		// Create an instance of a timer for scheduling the task.
		Timer timer = new Timer();
		
		// Schedule a task to run after a delay.
		timer.schedule(task, ILLUMINATIONTIME);
	
	}
	
	/**
	 * Returns the panel to a default state - not illuminated.
	 */
	public static void dimPanelRed()
	{
		// Set the background back to it's default color.
		panelRed.setBackground(darkRed);
		
	}
	
	/**
	 * Illuminate the panel.  Also creates a new thread
	 * that will return the panel to a dimmed state after a
	 * period of time.
	 */
	public static void illumPanelYellow()
	{
		// Set the background color to a lighter color.
		panelYellow.setBackground(lightYellow);
		
		// Create an instance of the task to be scheduled.
		Task_PanelYellow task = new Task_PanelYellow();
		
		// Create an instance of a timer for scheduling the task.
		Timer timer = new Timer();
		
		// Schedule a task to run after a delay.
		timer.schedule(task, ILLUMINATIONTIME);
	
	}
	
	/**
	 * Returns the panel to a default state - not illuminated.
	 */
	public static void dimPanelYellow()
	{
		// Set the background back to it's default color.
		panelYellow.setBackground(darkYellow);
		
	}
	
	/**
	 * Illuminate the panel.  Also creates a new thread
	 * that will return the panel to a dimmed state after a
	 * period of time.
	 */
	public static void illumPanelBlue()
	{
		// Set the background color to a lighter color.
		panelBlue.setBackground(lightBlue);
		
		// Create an instance of the task to be scheduled.
		Task_PanelBlue task = new Task_PanelBlue();
		
		// Create an instance of a timer for scheduling the task.
		Timer timer = new Timer();
		
		// Schedule a task to run after a delay.
		timer.schedule(task, ILLUMINATIONTIME);
	
	}
	
	/**
	 * Returns the panel to a default state - not illuminated.
	 */
	public static void dimPanelBlue()
	{
		// Set the background back to it's default color.
		panelBlue.setBackground(darkBlue);
		
	}
	
	
	
	
	
	
	
}
