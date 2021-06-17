import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class pokemonGame {

	JFrame window; //window for gui
	Container con; //container for everything
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel; //various panels for text and buttons
	JLabel titleNameLabel, hpLabel, hpLabelNumber, pokemonLabel, pokemonLabelName; //labels
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 64); //font for title
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 30); //font for everything else
	JButton startButton, choice1, choice2, choice3, choice4; //buttons for user to press
	JTextArea mainTextArea; 
	int pokemonHP, maxPokemonHP, snorlaxHP, position, caught; //variables that will be used later
	String pokemon;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler(); //used to change screen based on what button user pressed
	ChoiceHandler choiceHandler = new ChoiceHandler();
	
	public static void main(String[] args) {

		new pokemonGame(); 
	}

	public pokemonGame() {
		
		window = new JFrame(); //creates window object
		window.setSize(800, 600);  //size of the window
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //gives window a close button
		window.getContentPane().setBackground(Color.black); //makes the window black
		window.setLayout(null); 
		window.setVisible(true); //makes it visible 
		con = window.getContentPane(); //adds it to con
		
		titleNamePanel = new JPanel(); //new panel for the title screen
		titleNamePanel.setBounds(100, 100, 600, 150); //size of panel
		titleNamePanel.setBackground(Color.black); //background color of panel
		titleNameLabel = new JLabel("Pokemon: Java Edition"); //Title of the game
		titleNameLabel.setForeground(Color.white); //Font color of the title
		titleNameLabel.setFont(titleFont); //gives it the font for the title
		
		startButtonPanel = new JPanel(); //panel for the start button
		startButtonPanel.setBounds(300, 400, 200, 100); //size of start button
		startButtonPanel.setBackground(Color.black); //background color of start button
		
		startButton = new JButton("START"); //Word on the start button
		startButton.setBackground(Color.black); //color of the background of the button
		startButton.setForeground(Color.white); //color fo the font
		startButton.setFont(normalFont); //what font is used for the button
		startButton.setFocusPainted(false);  // gets rid of a weird white box in button
		startButton.addActionListener(tsHandler); //when pressed it does a certain function
		
		titleNamePanel.add(titleNameLabel); //adds title to the title screen
		startButtonPanel.add(startButton); //adds start button to the title screen
		
		con.add(titleNamePanel); //adds title to the container
		con.add(startButtonPanel); //adds start button to the container
		
	}
	public void createGameScreen() {
		
		titleNamePanel.setVisible(false); //makes title invisible
		startButtonPanel.setVisible(false); //makes start button invisible 
		
		
		mainTextPanel = new JPanel(); //makes a new panel
		mainTextPanel.setBounds(100, 100, 600, 250); //size of the panel
		mainTextPanel.setBackground(Color.black); //makes background color black
		con.add(mainTextPanel); //adds it to the container
		
		mainTextArea = new JTextArea("This is the main text area. This game is going to be great! I am sure of it."); 
		mainTextArea.setBounds(100, 100, 600, 250); //size of the text area 
		mainTextArea.setBackground(Color.black); //makes background color black
		mainTextArea.setForeground(Color.white); //makes font white
		mainTextArea.setFont(normalFont); //uses normal font
		mainTextArea.setLineWrap(true); //wraps the text so it moves to the next line when needed
		mainTextPanel.add(mainTextArea); //adds the text to the main panel
		
		choiceButtonPanel = new JPanel(); //new JPanel for buttons
		choiceButtonPanel.setBounds(250, 350, 300, 150); //size of the button area
		choiceButtonPanel.setBackground(Color.black); // makes background color black
		choiceButtonPanel.setLayout(new GridLayout(4,1)); //makes it so it's in a grid 4x1
		con.add(choiceButtonPanel);//adds it to the container
		
		choice1 = new JButton("Choice One"); //first button
		choice1.setBackground(Color.black); //makes the background black
		choice1.setForeground(Color.white); //makes the font white
		choice1.setFont(normalFont); //uses normal font
		choice1.setFocusPainted(false); //no weird white box
		choice1.addActionListener(choiceHandler); //does an action when pressed
		choice1.setActionCommand("c1"); //sets the action command to c1
		choiceButtonPanel.add(choice1);//adds to the panel
		
		choice2 = new JButton("Choice Two"); //second button
		choice2.setBackground(Color.black);// makes background black
		choice2.setForeground(Color.white);//makes font white
		choice2.setFont(normalFont); //uses normal font
		choice2.setFocusPainted(false); //no weird little white box
		choice2.addActionListener(choiceHandler); //does an action when pressed
		choice2.setActionCommand("c2"); //sets the action command to c2
		choiceButtonPanel.add(choice2); //adds to panel
		
		choice3 = new JButton("Choice Three"); //same as first button but with a 3
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton("Choice Four"); //same as the first button but with a 4
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		playerPanel = new JPanel(); //panel to display all the player stats
		playerPanel.setBounds(100, 50, 600, 50); //size of said panel
		playerPanel.setBackground(Color.black); //make background color black
		playerPanel.setLayout(new GridLayout(1,4)); //1x4 grid orintation 
		con.add(playerPanel); //adds it to the container
		 
		pokemonLabel = new JLabel("Pokemon:"); //new label for the player's pokemon
		pokemonLabel.setFont(normalFont); //uses normal font
		pokemonLabel.setForeground(Color.white); //font color white
		playerPanel.add(pokemonLabel);//adds to the player panel
		
		pokemonLabelName = new JLabel(); //label for the pokemon's name
		pokemonLabelName.setFont(normalFont); //uses normal font
		pokemonLabelName.setForeground(Color.white); // makes the font white
		playerPanel.add(pokemonLabelName); //adds to player panel
		

        hpLabel = new JLabel("HP:"); //label for pokemon hp
		hpLabel.setFont(normalFont); //uses normal font
		hpLabel.setForeground(Color.white); //makes font white
		playerPanel.add(hpLabel); //adds to player panel
		
		hpLabelNumber = new JLabel(); //label for hp number
		hpLabelNumber.setFont(normalFont); //uses normal font
		hpLabelNumber.setForeground(Color.white); //makes font white
		playerPanel.add(hpLabelNumber); //adds to player panel
		
		playerSetup(); //uses the player setup class to set up all the player stats

	}
	
	public void playerSetup() {
		pokemonHP = 15; //sets hp to 15
		maxPokemonHP = 15; //makes a cap for hp
		snorlaxHP = 20; //hp for later challenge
		pokemon = "Pikachu"; //pokemon you start with
		pokemonLabelName.setText(pokemon);//sents it to the default pokemon
		hpLabelNumber.setText("" + pokemonHP); //sets pokemon hp
		
		townGate(); //starts at the towngate 
	} 
	
	public void townGate(){
		position = 11;
		mainTextArea.setText("You are at the gate of the town.\nA trainer is standing in front of you. \n\n What do you do?"); //intro words
		choice1.setText("Talk to the trainer"); //first choice
		choice2.setText("Battle the trainer"); //second choice
		choice3.setText("Leave"); //third choice
		choice4.setText(""); //blank
		
		
		
	} 
	
	public void talkTrainer(){
		position = 12;
		mainTextArea.setText("Trainer: Hello there, \nWelcome to Vermilion City! Our trainer league is \nstarting soon but you look far too weak to enter. \nScram!"); //npc
		choice1.setText(">"); //next button
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	} 
	

	public void battleTrainer() {
		position = 13;
		mainTextArea.setText("Trainer:\n Ha! You think you can beat me? \n The trainer's beedrill fought back and hit pikachu.\n (Pikachu received 3 damage points.)");
		pokemonHP = pokemonHP - 3; //takes 3 damage from trainer
		if(pokemonHP < 1) {
			pokemonHP = 0;
			hpLabelNumber.setText("" + pokemonHP);
			lose(); //if health gets to zero or negative you automatically lose
		}
		hpLabelNumber.setText("" + pokemonHP); //sets pokemon hp to the new updated hp
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	
	}
	
	public void trailHead() {
		position = 14;
		mainTextArea.setText("You are at a trailhead.\nIf you go south, you will go back to the town."); //text
		choice1.setText("Go North");//choice one for user
		choice2.setText("Go East");//choice two for user
		choice3.setText("Go South");//choice three for user
		choice4.setText("Go West");//choice four for user
		
	} 
	
	public void north() {
		position = 15;
		mainTextArea.setText("You found a potion.\nYou use the potion on Pikachu.\n\n(Pikachu recovered 2 HP.)");
		pokemonHP = pokemonHP + 2; //adds hp to pokemon
		if(pokemonHP>maxPokemonHP) { //doesn't allow hp to go above the max
			pokemonHP = maxPokemonHP;
		}
		hpLabelNumber.setText("" + pokemonHP);
		choice1.setText("Go South");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	} 
	
	public void east() { //what happens when player goes east
		position = 16;
		mainTextArea.setText("You walked into the forest\nand found a thunder stone and evolved Pikachu.\n\n(You now have Raichu)");
        pokemon = "Raichu"; //evolves pokemon
		pokemonLabelName.setText("Raichu"); //changes the pokemon being used to raichu
		choice1.setText("Go West"); //option to go back west to trailhead
		choice2.setText(""); 
		choice3.setText("");
		choice4.setText("");
	} 
	
	public void west() { //option if player chooses west
		position = 17;
		
		if(caught == 0) { //if mission isn't already done
		mainTextArea.setText("You encounter a wild angry snorlax!\n\n What will you do?");
		choice1.setText("Battle"); //option 1
		choice2.setText("Run"); //option 2
		choice3.setText("");
		choice4.setText("");
		} 
		else {
			defeatedSnorlax();
		}
	} 
	
	public void fight() {
		position = 18;
		mainTextArea.setText("Snorlax HP: " + snorlaxHP + "\n\nWhat do you do?");
		choice1.setText("Attack");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
	} 
	
	public void playerAttack() {
		position = 19;
		
		int playerDamage = 0;
		
		if(pokemon.equals("Pikachu")) { //if the pokemon is not evolved it can only do up to 3 damage
			playerDamage = new java.util.Random().nextInt(3);
		} 
		
		else if (pokemon.equals("Raichu")) { //if pokemon is evolved it can do up to 8 damage
			playerDamage = new java.util.Random().nextInt(8);
		}
		
		mainTextArea.setText("You attacked the wild snorlax and\ndealt " + playerDamage + " damage!"); //prints damage done
		snorlaxHP = snorlaxHP - playerDamage; //decreases snorlax's hp based on damage dealt by the player
		
		choice1.setText(">"); //next button
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	} 
	
	public void snorlaxAttack() { 
		position = 20;
		int snorlaxDamage = 0;
		
		snorlaxDamage = new java.util.Random().nextInt(6);//snorlax does a random amount of damage between 0-6
		mainTextArea.setText("The monster attacked you and dealt you " + snorlaxDamage + " damage!"); //prints how much damage snorlax does
		pokemonHP = pokemonHP - snorlaxDamage;//changes player's pokemon's hp based on what snorlax did
		hpLabelNumber.setText("" + pokemonHP); //changes hp on gui
		choice1.setText(">");//next button
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
		if(pokemonHP<1) { //if hp is less than 1 the pokemon's hp is 0
			pokemonHP = 0;
			hpLabelNumber.setText("" + pokemonHP);
		}
		
	} 
	
	public void win() { //if snorlax is beat
		position = 21;
		
		mainTextArea.setText("Snorlax fainted!\nYou throw your pokeball.\n\n(You caught snorlax.)"); //prints this message to player
		
		caught = 1; //sets caught to 1
		
		choice1.setText("Go East"); //only option
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void lose() { //if snorlax isn't beat
		position = 22;
		mainTextArea.setText("Your pokemon fainted!\n\nGAME OVER!"); //game is over and game restarts
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true); //sets only this next option visible
		choice2.setVisible(false); 
		choice3.setVisible(false);
		choice4.setVisible(false);
		

	} 
	
	public void ending() { //final screen for player if they win
		position = 23;
		
		mainTextArea.setText("Trainer:\nOh, you caught that troublesome Snorlax!?\nYou're tougher than I thought!\nPlease enter the trainer league!\nTHE END");
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true); //only makes the next option visible 
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	} 
	
	public void defeatedSnorlax() {
		position = 24;
		mainTextArea.setText("Snorlax's berries that he left behind are on the \n path.There is nothing left to see here."); //if player goes back after snorlax is defeated this prints
		choice1.setText(">"); //next button
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	} 
	
	public void beginNewGame() { //resets window for a new game
		mainTextPanel.setVisible(false);
		choiceButtonPanel.setVisible(false);
		playerPanel.setVisible(false);
		titleNamePanel.setVisible(true);
		startButtonPanel.setVisible(true);
	} 

	
	public class TitleScreenHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent event){
			
			createGameScreen(); //starts new game
		} 
	} 
	public class ChoiceHandler implements ActionListener {
		public void actionPerformed(ActionEvent event){
			
			String yourChoice = event.getActionCommand(); //goes based on what the user presses
			
			switch(position){ //different outcomes if the position matches
			case 11:
				switch(yourChoice){
				case "c1": if(caught ==1) {
					ending(); break;
				}
				else {
					talkTrainer(); break; //talks to trainer if in position 11
				} 
				case "c2": battleTrainer(); break;
				case "c3": trailHead(); break;
				} 
				break;
				
			case 12:
				switch(yourChoice) {
				case "c1": townGate(); break; 
				} 
				break;
				
			case 13:
				switch(yourChoice) {
				case "c1": townGate(); break;
				} 
				break;
			case 14:
				switch(yourChoice) {
				case "c1": north(); break;
				case "c2": east(); break;
				case "c3": townGate(); break; 
				case "c4": west(); break;
				} 
				break;
			case 15:
				switch(yourChoice) {
				case "c1": trailHead(); break;
				} 
				break;
			case 16:
				switch(yourChoice) {
				case "c1": trailHead(); break;
				}
				break;
			case 17:
				switch(yourChoice) {
				case "c1": fight(); break;
				case "c2": trailHead(); break;
				} 
				break;
			case 18:
				switch(yourChoice) {
				case "c1": playerAttack(); break;
				case "c2": trailHead(); break;
				}
				break;
			case 19:
				switch(yourChoice) {
				case "c1": 
					if(snorlaxHP<1) {
						win();
					} 
					else {
						snorlaxAttack(); break;
					} 				
				} 
				break;
			case 20:
				switch(yourChoice) {
				case "c1":
					if(pokemonHP<1) {
						lose();
					} 
					else {
						fight();
					} 
					break;
				} 
				break;
			case 21:
				switch(yourChoice) {
				case "c1": trailHead(); break;
				} 
				break;
			case 24:
				switch(yourChoice) {
				case "c1": trailHead(); break;
				} 
				break;
			case 22:
				switch(yourChoice) {
				case "c1": beginNewGame(); break;
				} 
				break;
			case 23:
				switch(yourChoice) {
				case "c1": beginNewGame(); break;
				} 
				break;
			} 
			
		} 
	} 
} 
