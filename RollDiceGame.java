import java.util.*;
class Player {
	String name;
	int score;
	Player (String name , int score) {
		this.name = name;
		this.score = score;
	}
	public String getName(){
		return name;
	} 
	public int getScore(){
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	} 

    public String toString() {
        String output = "Name ::" + this.name + " " + "Score ::" + this.score + " ";
        return output;
    }
}

class Dice {
	int faceValue;
	public int rollADice(int max) {
		Random rand = new Random();
		faceValue = rand.nextInt(max) + 1;
		System.out.println("faceValue :: " + faceValue);
		return faceValue;
	}	
}
class DiceGame {
	List<Player> allPlayers = new ArrayList<Player>();
	Dice dice = new Dice();

	public void addAPlayer(Player player) {
		allPlayers.add(player);
	}

	public void startGame() {
		while(true) {
			for(Player player : allPlayers) {
				playGame(player);
				if(player.getScore() >= 100) {
					System.out.println(player.getName() + "  Won the game");
					return;
				}	
			}
		} 
	}

	public void result() {
		for(Player player : allPlayers){
			System.out.println(player);
		}		
	}

	public void playGame(Player player) {
		//System.out.println(player);
		int score = 0 ;
		while(true) {
			int result = dice.rollADice(6);
			if(result==1) {
				player.setScore(0);
				System.out.println("----Score to Zero for ::" + player.getName());
				break;
			} else if(score >=100) {
				player.setScore(score);
				break;
			} else if(result==6) {
				score += result;
				System.out.println("------------------"+"choice for ::" + player.getName());
				System.out.println("----------------------------Your score :: " + score);
				System.out.println("Enter 1 to continue " + "\n" + "Enter 2 to leave");
				//int choice = dice.rollADice(2);
				Scanner kb = new Scanner(System.in);
				int choice = kb.nextInt();
				//System.out.println("Entered choice is :: " + choice);
				if(choice == 2) {
					player.setScore(score);
					break;
				}
			} else {
				score = score + result;
			}
		}
	}
}

public class RollDiceGame {
	public static void main(String[] args) {
		String name;
		int size;
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter number of players");
		size = kb.nextInt();
		DiceGame games = new DiceGame();
		Player players;
		kb.nextLine();
		for(int i = 0 ; i < size ; i++) {
			System.out.println("Enter player name");
			name = kb.nextLine();
			players = new Player(name , 0);
			games.addAPlayer(players);
		}
		games.startGame();
		games.result();
	}
}
