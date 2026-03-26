import java.awt.Font;
import java.awt.Graphics;

public class Board {

    private String[][] board;

    public Board() {
        board = initializeBoard();
    }

    private String[][] initializeBoard() {
        String[][] temp = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = ".";
            }
        }
        return temp;
    }

    public void drawGrid(Graphics g2d) {
        g2d.setFont(new Font("Broadway", Font.BOLD, 50));
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                g2d.drawString(board[i][j], j * 100 + 100, i * 100 + 100);
            }
        }
    }

    public void setCell(int row, int col, String value) {
        board[row][col] = value;
    }

    public String getCell(int row, int col) {
        return board[row][col];
    }
}