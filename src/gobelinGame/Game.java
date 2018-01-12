package gobelinGame;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Game
{
  private Game() {
    initGame();
    createAndShowGUI();
  }

  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new Game();
      }
    });
  }

  // constantes et variables env
  final static Color COLOURBACK =  Color.WHITE;
  final static Color COLOURCELL =  Color.ORANGE;
  final static Color COLOURGRID =  Color.BLACK;
  final static Color COLOURONE = new Color(255,255,255,200);
  final static Color COLOURONETXT = Color.BLUE;
  final static Color COLOURTWO = new Color(0,0,0,200);
  final static Color COLOURTWOTXT = new Color(255,100,255);
  final static int EMPTY = 0;
  final static int BSIZE = 16; // board size.
  final static int HEXSIZE = 60;	//hex size in pixels
  final static int BORDERS = 15;
  final static int SCRSIZE = HEXSIZE * (BSIZE + 1) + BORDERS*3; //screen size (vertical dimension).

  Grille Grille = new Grille();

  int[][] board = new int[BSIZE][BSIZE];

  void initGame(){

    Grille.setXYasVertex(false); //recommandation du net : laisser � FALSE.

    Grille.setHeight(HEXSIZE);
    Grille.setBorders(BORDERS);

    for (int i=0;i<BSIZE;i++) {
      for (int j=0;j<BSIZE;j++) {
        board[i][j]=EMPTY;
      }
    }

    //set up board here
    board[3][3] = (int)'A';
    board[4][3] = (int)'Q';
    board[4][4] = -(int)'B';

  }

  private void createAndShowGUI()
  {
    DrawingPanel panel = new DrawingPanel();


    JFrame frame = new JFrame("Goblin Game");
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    Container content = frame.getContentPane();
    content.add(panel);
    //this.add(panel);  // impossible si context static


    /** a revoir */
    frame.setSize( (int)(SCRSIZE*0.8), SCRSIZE); // donner la taille via la constante
    //System.out.print(java.awt.Frame.MAXIMIZED_BOTH); // Redimensionner la fenetre


    frame.setResizable(false);
    frame.setLocationRelativeTo( null );
    frame.setVisible(true);
  }


  class DrawingPanel extends JPanel
  {
    // variable souris
    //Point mPt = new Point(0,0);

    public DrawingPanel()
    {
      setBackground(COLOURBACK);

      MyMouseListener ml = new MyMouseListener();
      addMouseListener(ml);
    }

    public void paintComponent(Graphics g)
    {
      Graphics2D g2 = (Graphics2D)g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
      super.paintComponent(g2);
      //draw grid
      for (int i=0;i<BSIZE;i++) {
        for (int j=0;j<BSIZE;j++) {
          Grille.drawHex(i,j,g2);
        }
      }

      for (int i=0;i<BSIZE;i++) {
        for (int j=0;j<BSIZE;j++) {
          //if (board[i][j] < 0) Grille.fillHex(i,j,COLOURONE,-board[i][j],g2);
          //if (board[i][j] > 0) Grille.fillHex(i,j,COLOURTWO, board[i][j],g2);
          Grille.fillHex(i,j,board[i][j],g2);
        }
      }

      //g.setColor(Color.RED);
      //g.drawLine(mPt.x,mPt.y, mPt.x,mPt.y);
    }

    class MyMouseListener extends MouseAdapter	{
      public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        //mPt.x = x;
        //mPt.y = y;
        Point p = new Point( Grille.pxtoHex(e.getX(),e.getY()) );
        if (p.x < 0 || p.y < 0 || p.x >= BSIZE || p.y >= BSIZE) return;

        // action au clic sur la tuile
        board[p.x][p.y] = (int)'X';
        repaint();
      }
    } // fin classe MyMouseListener
  } // fin classe DrawingPanel
}