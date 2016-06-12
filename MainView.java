import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;



public class MainView 
{
	/*
	 * class variables
	 */
	private JFrame frame;
	public static MainView window;
	private static JPanel panelTitleImage;
	
	private static JLabel lblLevelNumber;
	private static JLabel lblStatusText;
	
	private static JPanel panelGameButtons;
	private static JPanel panelGreen;
	private static JPanel panelRed;
	private static JPanel panelYellow;
	private static JPanel panelBlue;
	private static final long ILLUMINATIONTIME = 500;
	
	/*
	 * Some colors for use in the GUI
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
	
	
	// Create a game engine instance
	public static GameEngine engine = new GameEngine();
	
	
	
	
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

		/* testing
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
		*/
		
	
		
		// Create an instance of a timer for scheduling the task.
		Timer timer = new Timer();
		
		// Schedule a task to run after a delay.
		timer.schedule(engine, ILLUMINATIONTIME);
			
		
		
		
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
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 365, 699);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		/*
		 *  Title panel
		 */
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(Color.BLACK);
		panelTitle.setBounds(10, 13, 329, 98);
		frame.getContentPane().add(panelTitle);
		
		panelTitleImage = new JPanel();
		panelTitle.add(panelTitleImage);
		panelTitleImage.setBorder(null);
		panelTitleImage.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelSimonImage = new JLabel("");
		labelSimonImage.setBackground(Color.WHITE);
		labelSimonImage.setHorizontalAlignment(SwingConstants.CENTER);
		labelSimonImage.setIcon(new ImageIcon(MainView.class.getResource("/SimonImage.PNG")));
		
		panelTitleImage.add(labelSimonImage);
		
		
		/*
		 *  Organizational panel for all buttons to reside in
		 */
		panelGameButtons = new JPanel();
		panelGameButtons.setBorder(null);
		panelGameButtons.setBounds(10, 109, 329, 530);
		panelGameButtons.setBackground(black);
		frame.getContentPane().add(panelGameButtons);
		panelGameButtons.setLayout(null);
		
		
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
				engine.reportGreenPressed();
			}
		});
		panelGreen.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelGreen.setBackground(darkGreen);
		panelGreen.setBounds(10, 146, 150, 125);
		panelGameButtons.add(panelGreen);
		
		/*
		 * The red button panel.
		 */
		panelRed = new JPanel();
		panelRed.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				engine.reportRedPressed();
			}
		});
		panelRed.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelRed.setBackground(darkRed);
		panelRed.setBounds(172, 146, 150, 125);
		panelGameButtons.add(panelRed);
		
		/*
		 * The yellow button panel.
		 */
		panelYellow = new JPanel();
		panelYellow.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				engine.reportYellowPressed();
			}
		});
		panelYellow.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelYellow.setBackground(darkYellow);
		panelYellow.setBounds(10, 287, 150, 125);
		panelGameButtons.add(panelYellow);
		
		/*
		 * The blue button panel.
		 */
		panelBlue = new JPanel();
		panelBlue.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				engine.reportBluePressed();
			}
		});
		panelBlue.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBlue.setBackground(darkBlue);
		panelBlue.setBounds(172, 287, 150, 125);
		panelGameButtons.add(panelBlue);
		
		/*
		 * An organizational panel for the game control buttons.
		 */
		JPanel panelGameControl = new JPanel();
		panelGameControl.setBorder(null);
		panelGameControl.setBounds(10, 31, 312, 87);
		panelGameButtons.add(panelGameControl);
		panelGameControl.setLayout(new GridLayout(0, 3, 0, 0));
		
		/*
		 * The start button.
		 */
		JButton btnStart = new JButton("Start");
		btnStart.setFont(new Font("Bauhaus 93", Font.BOLD, 16));
		btnStart.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				engine.reportStartPressed();
			}
		});
		panelGameControl.add(btnStart);
		
		/*
		 * The reset button.
		 */
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setFont(new Font("Bauhaus 93", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				engine.reportResetPressed();
			}
		});
		panelGameControl.add(btnNewButton_1);
		
		/*
		 * An organizational panel for the level display.
		 */
		JPanel panelLevel = new JPanel();
		panelLevel.setBorder(new LineBorder(Color.WHITE));
		panelLevel.setForeground(Color.WHITE);
		panelLevel.setBackground(Color.BLACK);
		panelGameControl.add(panelLevel);
		panelLevel.setLayout(null);
		
		/*
		 * The actual text label.
		 */
		JLabel lblLevelText = new JLabel("Level:");
		lblLevelText.setForeground(Color.WHITE);
		lblLevelText.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevelText.setBounds(12, 15, 80, 16);
		panelLevel.add(lblLevelText);
		
		/*
		 * The displayed level number, this is the number that will be
		 * to show the level progress.
		 */
		lblLevelNumber = new JLabel("0");
		lblLevelNumber.setForeground(Color.WHITE);
		lblLevelNumber.setBounds(29, 44, 45, 30);
		panelLevel.add(lblLevelNumber);
		lblLevelNumber.setFont(new Font("Verdana", Font.PLAIN, 24));
		lblLevelNumber.setHorizontalAlignment(SwingConstants.CENTER);
		
		/*
		 * A text label for displaying the game status,
		 */
		lblStatusText = new JLabel("Welcome!");
		lblStatusText.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatusText.setFont(new Font("Bauhaus 93", Font.BOLD, 29));
		lblStatusText.setForeground(Color.WHITE);
		lblStatusText.setBounds(12, 441, 310, 84);
		panelGameButtons.add(lblStatusText);
		
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
	
	
	/**
	 * Updates the level display on the GUI
	 * 
	 * @param newLevel the new level to display
	 */
	public static void updateLevelDisplay(int newLevel)
	{
		lblLevelNumber.setText(Integer.toString(newLevel));
	}
	
	
	/**
	 * Updates the game status display on the GUI
	 * 
	 * @param newLevel the new level to display
	 */
	public static void updateStatusText(String newText)
	{
		lblStatusText.setText(newText);
	}
	
}
