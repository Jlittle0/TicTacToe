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
                             Y_PADDING = WINDOW_HEIGHT / 2 - SIDE_LENGTHS * 3 / 2 - TITLE_BAR_HEIGHT;
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
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        g.drawImage(background, 0 ,0, WINDOW_WIDTH, WINDOW_HEIGHT,  this);
        // Draws the board
        for (int i = 0; i < t.getBoard().length; i++) {
            for (int j = 0; j < t.getBoard().length; j++) {
                t.getBoard()[i][j].draw(g, SIDE_LENGTHS, X_PADDING, Y_PADDING);
            }
        }
    }

}
