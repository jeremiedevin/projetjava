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
  final static int BSIZE = 12; // board size.
  final static int HEXSIZE = 60;	//hex size in pixels
  final static int BORDERS = 15;
  final static int SCRSIZE = HEXSIZE * (BSIZE + 4) + BORDERS*3; //screen size (vertical dimension).

  Grille Grille = new Grille();

  Pion Pion = new Pion();

  int[][] board = new int[BSIZE][BSIZE];

  void initGame(){

    Grille.setXYasVertex(false); //recommandation du net : laisser à FALSE.

    Grille.setHeight(HEXSIZE*2);
    Grille.setBorders(BORDERS);

    for (int i=0;i<BSIZE;i++) {
      for (int j=0;j<BSIZE;j++) {
        board[i][j]=EMPTY;
      }
    }

    // test affichage de case grise
    //board[3][3] = (int)'A';
    //board[4][4] = -(int)'B';
  }

  private void createAndShowGUI()
  {
    DrawingPanel panel = new DrawingPanel();


    JFrame frame = new JFrame("Gobelin Game");
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    Container content = frame.getContentPane();
    content.add(panel);
    //this.add(panel);  // impossible si context static


    /** a revoir --> taille de la fenêtre */
    frame.setSize( (int)(SCRSIZE*1.9), SCRSIZE); // donner la taille via la constante

    frame.setResizable(true);
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
          Grille.fillHex(i,j,board[i][j],g2);
        }
      }

      //g.setColor(Color.RED);
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
        //board[p.x][p.y] = 'P';
        Pion.setPosition(p.x,p.y);

        initGame();
        board[Pion.getX()][Pion.getY()] = (int)'X';
        repaint();
      }
    } // fin classe MyMouseListener
  } // fin classe DrawingPanel
}