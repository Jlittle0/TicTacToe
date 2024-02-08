import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
public class TicTacToeViewer extends JFrame {

    // TODO: Complete this class
    private static final int WINDOW_HEIGHT = 882,
                             WINDOW_WIDTH = 882,
                             SIDE_LENGTHS = 50,
                             TITLE_BAR_HEIGHT = 22,
                             X_PADDING = WINDOW_WIDTH / 2 - SIDE_LENGTHS * 3 / 2,
                             Y_PADDING = WINDOW_HEIGHT / 2 - SIDE_LENGTHS * 3 / 2 - TITLE_BAR_HEIGHT,
                             BRUSH_PADDING_Y = 15,
                             BRUSH_PADDING_X = 5;
    private static final String TITLE = "Tic-Tac-Toe";
    private TicTacToe t;
    private Image background;
    private Image[] images;

    public TicTacToeViewer(TicTacToe t) {
        this.t = t;
        images = new Image[2];
        this.background = new ImageIcon("Resources/Fmx9OoUXkAAtZUo.jpg").getImage();
        images[0] = new ImageIcon("Resources/O.png").getImage();
        images[1] = new ImageIcon("Resources/X.png").getImage();
        this.setTitle(TITLE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public Image[] getImages() {
        return images;
    }

    public void paint(Graphics g) {
        // Increasing font size so that the numbers are more visible
        Font stringFont = new Font( "SansSerif", Font.PLAIN, 25 );
        g.setFont(stringFont);

        // Clear the screen by drawing a white rectangle over everything
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        // Paint the background based on image resource file
        g.drawImage(background, 0 ,0, WINDOW_WIDTH, WINDOW_HEIGHT,  this);
        // Draws the board
        for (int i = 0; i < t.getBoard().length; i++) {
            for (int j = 0; j < t.getBoard().length; j++) {
                t.getBoard()[i][j].draw(g, SIDE_LENGTHS, X_PADDING, Y_PADDING);
            }
        }
        // Put all the numbers on the side of the board to indicate which indicies correspond to each square
        g.drawString("0", X_PADDING + SIDE_LENGTHS / 2 - BRUSH_PADDING_X, Y_PADDING - BRUSH_PADDING_X);
        g.drawString("1", X_PADDING + 3 * SIDE_LENGTHS / 2 - BRUSH_PADDING_X, Y_PADDING - BRUSH_PADDING_X);
        g.drawString("2", X_PADDING + 5 * SIDE_LENGTHS / 2 - BRUSH_PADDING_X, Y_PADDING - BRUSH_PADDING_X);
        g.drawString("0", X_PADDING - BRUSH_PADDING_Y * 3 / 2, Y_PADDING + SIDE_LENGTHS / 2 + BRUSH_PADDING_X * 2);
        g.drawString("1", X_PADDING - BRUSH_PADDING_Y * 3 / 2, Y_PADDING + 3 * SIDE_LENGTHS / 2 + BRUSH_PADDING_X * 2);
        g.drawString("2", X_PADDING - BRUSH_PADDING_Y * 3 / 2, Y_PADDING + 5 * SIDE_LENGTHS / 2 + BRUSH_PADDING_X * 2);
        // Check if the game is over and print the ending message accordingly
        switch (t.getWinner()) {
            case "X":
                g.drawString("X Wins!", WINDOW_WIDTH / 2 - BRUSH_PADDING_Y, WINDOW_HEIGHT / 2 + SIDE_LENGTHS * 3 / 2 + BRUSH_PADDING_Y);
                break;
            case "O":
                g.drawString("O Wins!", WINDOW_WIDTH / 2 - BRUSH_PADDING_Y, WINDOW_HEIGHT / 2 + SIDE_LENGTHS * 3 / 2 + BRUSH_PADDING_Y);
                break;
            case "-":
                if (t.getGameOver()) {
                    g.drawString("Game ends in a tie!", WINDOW_WIDTH / 2 - BRUSH_PADDING_Y * 2, WINDOW_HEIGHT / 2 + SIDE_LENGTHS * 3 / 2 + BRUSH_PADDING_Y);
                }
                break;
            default:
                System.out.println("Something wrong");
        }
    }

}
