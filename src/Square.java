/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
public class Square {

    private String marker;
    private TicTacToeViewer back;
    private Image x, o;
    private int row;
    private int col;
    private static final int BRUSH_THICKNESS = 5;
    private boolean isWinningSquare;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col, TicTacToeViewer back) {
        this.back = back;
        this.row = row;
        this.col = col;
        this.x = new ImageIcon("Resources/X.png").getImage();
        this.o = new ImageIcon("Resources/O.png").getImage();

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    public void draw(Graphics g, int sideLength, int x_padding, int y_padding) {
        // Note: Idea and method to increase the thickness of line was taken from Edwin Buck on Stack Overflow
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(BRUSH_THICKNESS));

        // Checks for the winning square and paints the squares green if a player has won.
        if (isWinningSquare) {
            g2.setColor(Color.GREEN);
            g2.fillRect(x_padding + col * sideLength, y_padding + row * sideLength, sideLength, sideLength);
        }

        // Draws the outline of the board (the squares)
        g2.setColor(Color.RED);
        g2.drawRect(x_padding + col * sideLength, y_padding + row * sideLength, sideLength, sideLength);

        // Uses a switch statement to draw the correct image in each square
        switch (marker) {
            case "X":
                g.drawImage(x, x_padding + col * sideLength, y_padding + row * sideLength, sideLength, sideLength, back);
                break;
            case "O":
                g.drawImage(o, x_padding + col * sideLength, y_padding + row * sideLength, sideLength, sideLength, back);
                break;
            case "-":
                // Leave square empty
                break;
            default:
                System.out.println("Something went horribly wrong");
        }
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }
}
