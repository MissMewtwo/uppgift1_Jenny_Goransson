import java.util.HashSet;
import java.util.Scanner;

public class TicTacToe {
	
	static HashSet<Integer> xSet = new HashSet<Integer>();
	static HashSet<Integer> oSet = new HashSet<Integer>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Välj spelläge: \n1. Multiplayer - Play with a friend \n2. Singleplayer - Play alone against the computer");
		int userChoice = in.nextInt();;
		int max = 2;
		int min = 1;
		
		while (userChoice > max || userChoice < min) {
			System.out.println("Är du dum eller, jag sa 1 eller 2!");
			userChoice = in.nextInt();
		}
		char[][] gameBoard = { 
			{ ' ', '|', ' ', '|', ' ' }, 
			{ '-', '|', '-', '|', '-' },
			{ ' ', '|', ' ', '|', ' ' },
			{ '-', '|', '-', '|', '-' }, 
			{ ' ', '|', ' ', '|', ' ' } 
		};

		printBoard(gameBoard);

		while (true) {

			int userPos = getUserNumber(in);
			posHolder(gameBoard, userPos, "Player 1");

			String result = checkWinner();
			if (result.length() > 0) {
				System.out.println(result);
				break;
			}

			System.out.println("");
			if (userChoice == 1) {
				int userPos2 = getUserNumber(in);
				posHolder(gameBoard, userPos2, "Player 2");
			} else {
				int compPos = genRandom();
				while (xSet.contains(compPos) || oSet.contains(compPos)) {

					compPos = genRandom();
				}
				posHolder(gameBoard, compPos, "Player 2");
			}
			result = checkWinner();
			if (result.length() > 0) {
				System.out.println(result);
				break;
			}
		}

	}

	static String checkWinner() {
		HashSet<Integer> r1 = new HashSet<Integer>();
		r1.add(1);
		r1.add(2);
		r1.add(3);
		HashSet<Integer> r2 = new HashSet<Integer>();
		r2.add(4);
		r2.add(5);
		r2.add(6);
		HashSet<Integer> r3 = new HashSet<Integer>();
		r3.add(7);
		r3.add(8);
		r3.add(9);
		HashSet<Integer> c1 = new HashSet<Integer>();
		c1.add(1);
		c1.add(4);
		c1.add(7);
		HashSet<Integer> c2 = new HashSet<Integer>();
		c2.add(2);
		c2.add(5);
		c2.add(8);
		HashSet<Integer> c3 = new HashSet<Integer>();
		c3.add(3);
		c3.add(6);
		c3.add(9);
		HashSet<Integer> d1 = new HashSet<Integer>();
		d1.add(1);
		d1.add(5);
		d1.add(9);
		HashSet<Integer> d2 = new HashSet<Integer>();
		d2.add(3);
		d2.add(5);
		d2.add(7);

		HashSet<HashSet> set = new HashSet<HashSet>();
		set.add(r1);
		set.add(r2);
		set.add(r3);
		set.add(c1);
		set.add(c2);
		set.add(c3);
		set.add(d1);
		set.add(d2);

		for (HashSet c : set) {
			if (xSet.containsAll(c))
				return "'X' Won";
			else if (oSet.containsAll(c))
				return "'O' Won";
		}
		if (xSet.size() + oSet.size() == 9)
			return "Draw";
		return "";
	}

	static int getUserNumber(Scanner in) {
		System.out.print("Välj en siffra mellan 1-9:");
		int userPos = in.nextInt();
		while (xSet.contains(userPos) || oSet.contains(userPos) || !checkNumber(userPos)) {

			System.out.println();
			System.out.print("Upptagen plats eller ogiltlig siffra");
			userPos = in.nextInt();
		}
		return userPos;
	}

	static int genRandom() {
		int max = 9;
		int min = 1;

		int range = max - min + 1;
		int result = (int) (Math.random() * range) + min;
		return result;
	}

	static void printBoard(char[][] gameBoard) {
		for (int r = 0; r < gameBoard.length; r++) {
			for (int c = 0; c < gameBoard[0].length; c++) {
				System.out.print(gameBoard[r][c]);
			}
			System.out.println();
		}
	}

	static boolean checkNumber(int number) {
		switch (number) {

		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
			return true;

		default:
			return false;

		}
	}

	static void posHolder(char[][] gameBoard, int pos, String user) {
		char symbol = 'X';
		if (user.equals("Player 1")) {
			symbol = 'X';
			xSet.add(pos);

		} else if (user.contentEquals("Player 2")) {
			symbol = 'O';
			oSet.add(pos);
		}
		switch (pos) {

		case 1:
			gameBoard[0][0] = symbol;
			break;
		case 2:
			gameBoard[0][2] = symbol;
			break;
		case 3:
			gameBoard[0][4] = symbol;
			break;
		case 4:
			gameBoard[2][0] = symbol;
			break;
		case 5:
			gameBoard[2][2] = symbol;
			break;
		case 6:
			gameBoard[2][4] = symbol;
			break;
		case 7:
			gameBoard[4][0] = symbol;
			break;
		case 8:
			gameBoard[4][2] = symbol;
			break;
		case 9:
			gameBoard[4][4] = symbol;
			break;

		default:
			System.out.println("Ogiltlig symbol");

		}
		printBoard(gameBoard);
	}
}
