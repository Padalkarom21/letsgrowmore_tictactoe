import java.util.Scanner;

 class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    
    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }
    
    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }
    
    private void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean hasWon(char player) {
        
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        
      
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {
                return true;
            }
        }
        
     
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }
        
        return false;
    }
    
    public void play() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        
        System.out.println("Welcome to Tic Tac Toe Game!");
        
        while (true) {
            System.out.println("Current board:");
            printBoard();
            
            System.out.println("Player " + currentPlayer + ", Enter your move (row [1-3] and column [1-3]):");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
            
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
                board[row][col] = currentPlayer;
                
                if (hasWon(currentPlayer)) {
                    System.out.println("Player " + currentPlayer + " wins! Congratulations!");
                    break;
                } else if (isBoardFull()) {
                    System.out.println("It's a draw! So the board is full.");
                    break;
                }
                
                
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }
        
        System.out.println("Game over.");
    }
   }
   class tictac
{
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }
}
