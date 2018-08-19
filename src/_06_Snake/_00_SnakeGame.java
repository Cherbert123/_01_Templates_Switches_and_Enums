package _06_Snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

// Go through the methods and complete the steps in this class
// and the Snake class

public class _00_SnakeGame implements ActionListener, KeyListener {
	public static final Color BORDER_COLOR = Color.WHITE;
	public static final Color BACKGROUND_COLOR = Color.BLACK;
	public static final Color FOOD_COLOR = Color.RED;
	public static final int WIDTH = 15;
	public static final int HEIGHT = 12;
	public static final int WINDOW_SCALE = 50;
	public static final int WINDOW_WIDTH = WINDOW_SCALE * WIDTH;
	public static final int WINDOW_HEIGHT = WINDOW_SCALE * HEIGHT;

	private JFrame window;
	private JPanel panel;

	private Snake snake;

	private Timer timer;

	private Location foodLocation;

	public _00_SnakeGame() {
		snake = new Snake(new Location(WIDTH / 2, HEIGHT / 2));

		window = new JFrame("Snake");
		panel = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;

				g2.setColor(BACKGROUND_COLOR);
				g2.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

				g2.setColor(FOOD_COLOR);
				g2.drawOval(foodLocation.x * WINDOW_SCALE, foodLocation.y * WINDOW_SCALE, Snake.BODY_SIZE,
						Snake.BODY_SIZE);
				snake.draw(g);
			}
		};

		panel.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		window.add(panel);

		timer = new Timer(0, this);

		window.pack();
		window.addKeyListener(this);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

		setFoodLocation();

		startGame();
	}

	public void startGame() {
		// 1. Save the instructions for the game in the following string variable.
		String instructions = "Select a Difficulty then, Use the Arrow Keys to navigate the Snake to the Food";

		String[] options = new String[] { "Insanity", "Expert", "Moderate", "Beginner" };
		int input = JOptionPane.showOptionDialog(null, instructions, "Snake", 0, -1, null, options, 0);

		String choice = options[input];

		// 2. Use a switch statement to determine which difficulty was chosen.
		// Use timer.setDelay(delay) with different numbers to change the speed
		// of the game. The smaller the number, the faster it goes.
		switch (choice) {

		case "Beginner":
			System.out.println("Beginner Selected");
			timer.setDelay(120);
			break;
		case "Moderate":
			System.out.println("Moderate Selected");
			timer.setDelay(80);
			break;
		case "Expert":
			System.out.println("Expert Selected");
			timer.setDelay(50);
			break;
		case "Insanity":
			System.out.println("Insanity Selected");
			timer.setDelay(400);
			break;
		}
		// 3. start the timer
		timer.start();
	}

	public static void main(String[] args) {
		new _00_SnakeGame();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 1. Use a switch statement on e.getKeyCode()
		// to determine which key was pressed.
		int key = e.getKeyCode();
		System.out.println(key);
		// if an arrow key is pressed, set the snake's
		// direction accordingly
		switch (key) {

		case 37:
			snake.setDirection(Direction.LEFT);
			break;
		case 38:
			snake.setDirection(Direction.UP);
			break;
		case 39:
			snake.setDirection(Direction.RIGHT);
			break;
		case 40:
			snake.setDirection(Direction.DOWN);
			break;
		case 32:
			snake.feed();
			break;
		}
		// if the space key is pressed, call the snake's feed method

	}

	private void setFoodLocation() {
		// 1. Create a new Location object that is set to a random location
		Random random = new Random();
		Location loc = new Location(random.nextInt(WIDTH), random.nextInt(HEIGHT));
		if (snake.isLocationOnSnake(loc)) {
			setFoodLocation();
		} else {
			foodLocation = loc;
			System.out.println(loc.x + ", " + loc.y);
		}
		// 2. set the foodLocation variable equal to the Location object you just
		// created.
		// use the snake's isLocationOnSnake method to make sure you don't put the food
		// on the snake

	}

	private void gameOver() {

		// 1. stop the timer
		timer.stop();
		// 2. tell the user their snake is dead
		String[] options = new String[] { "Play Again!", "Quit" };
		int input = JOptionPane.showOptionDialog(null, "You Lose!", "Snake", 0, -1, null, options, 0);

		String choice = options[input];
		switch (choice) {

		case "Play Again!":
			snake.reset(new Location(WIDTH / 2, HEIGHT / 2));
			setFoodLocation();
			timer.start();
			break;
		case "Quit":
			window.dispose();
			System.exit(0);
			break;
		}
		// 3. ask them if they want to play again.

		// 4. if they want to play again
		// reset the snake and the food and start the timer
		// else, exit the game

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 1. update the snake
		snake.update();
		System.out.println(snake.getHeadLocation().x + ", " + snake.getHeadLocation().y);
		// 2. if the snake is colliding with its own body
		// or if the snake is out of bounds, call gameOver
		if (snake.isHeadCollidingWithBody() | snake.isOutOfBounds()) {
			gameOver();
		}
		// 3. if the location of the head is equal to the location of the food,
		// feed the snake and set the food location
		if (snake.getHeadLocation().x == foodLocation.x && snake.getHeadLocation().y == foodLocation.y) {
			snake.feed();
			setFoodLocation();
		}
		// 4. call panel.repaint();
		panel.repaint();
	}
}
