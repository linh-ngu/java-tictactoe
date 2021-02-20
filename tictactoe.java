import java.util.*;

class Main {
  public static void main(String[] args) {
    
    String[] gameBoard = {" ", " ", " ", " ", " ", " ", " ", " " ," "};
    
    printGameBoard(gameBoard);

    Scanner x = new Scanner(System.in);

    Scanner o = new Scanner(System.in);
    
    while (true) {
      
      System.out.println("Player X, choose your position (1-9): ");

      int X = x.nextInt();

      while (X < 1 || X > 9 || gameBoard[X-1] != " ") {
        System.out.println("Not a valid move! Enter a correct move: ");
        X = x.nextInt();
      }

      placePosition(gameBoard, X, "PlayerX");

      printGameBoard(gameBoard);
      
      System.out.println(checkWinner(gameBoard, "X"));

      String resultsX = checkWinner(gameBoard, "X");

      if (resultsX.length() > 0) {
        break;
      }

      System.out.println("Player O, choose your position (1-9): ");
      
      int O = o.nextInt();

      while (X < 1 || X > 9 || gameBoard[O-1] != " ") {
        System.out.println("Not a valid move! Enter a correct move: ");
        O = o.nextInt();
      }

      placePosition(gameBoard, O, "PlayerO");

      printGameBoard(gameBoard);
    
      System.out.println(checkWinner(gameBoard, "O"));

      String resultsO = checkWinner(gameBoard, "O");

      if (resultsO.length() > 0) {
        break;
      }
    }
    x.close();
    o.close();
  }
  
  public static void printGameBoard(String[] gameBoard){
      System.out.println(" |---|---|---|");
      System.out.println(" | " + gameBoard[0] + " | " + gameBoard[1] + " | " + gameBoard[2] + " |");
      System.out.println(" |---|---|---|");
      System.out.println(" | " + gameBoard[3] + " | " + gameBoard[4] + " | " + gameBoard[5] + " |");
      System.out.println(" |---|---|---|");
      System.out.println(" | " + gameBoard[6] + " | " + gameBoard[7] + " | " + gameBoard[8] + " |");
      System.out.println(" |---|---|---|");
    }
  
  public static void placePosition(String[] gameBoard, int Player, String user){
    String symbol = " ";
    if (user.equals("PlayerX")){
      symbol = "X";
    }
    else if (user.equals("PlayerO")){
      symbol = "O";
    }
    
    switch(Player){
      case 1:
        gameBoard[0] = symbol;
        break;
      case 2:
        gameBoard[1] = symbol;
        break;
      case 3:
        gameBoard[2] = symbol;
        break;
      case 4:
        gameBoard[3] = symbol;
        break;
      case 5:
        gameBoard[4] = symbol;
        break;
      case 6:
        gameBoard[5] = symbol;
        break;
      case 7:
        gameBoard[6] = symbol;
        break;
      case 8:
        gameBoard[7] = symbol;
        break;
      case 9:
        gameBoard[8] = symbol;
        break;
      default:
        break;
    }
  }

  public static String checkWinner(String[] gameBoard, String user) {
    String symbol = " ";
    if (user.equals("X")){
      symbol = "X";
    }
    else if (user.equals("O")){
      symbol = "O";
    }
    if (gameBoard[0] == symbol && gameBoard[1] == symbol && gameBoard[2] == symbol || gameBoard[3] == symbol && gameBoard[4] == symbol && gameBoard[5] == symbol || gameBoard[6] == symbol && gameBoard[7] == symbol && gameBoard[8] == symbol || gameBoard[0] == symbol && gameBoard[3] == symbol && gameBoard[6] == symbol || gameBoard[1] == symbol && gameBoard[4] == symbol && gameBoard[7] == symbol || gameBoard[2] == symbol && gameBoard[5] == symbol && gameBoard[8] == symbol || gameBoard[0] == symbol && gameBoard[4] == symbol && gameBoard[8] == symbol|| gameBoard[2] == symbol && gameBoard[4] == symbol && gameBoard[6] == symbol) {
      return "Player " + user + " is the winner!";
    }
    else if (!(Arrays.asList(gameBoard).contains(" "))) {
      return "Draw";
    }
    else {
      return "";
    }
  }
}
