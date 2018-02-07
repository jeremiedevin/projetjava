import java.awt.*;
import javax.swing.*;
import java.lang.*;

public class Grille
{

  //Constantes - le dernier fix les rends inutiles
  public final static boolean orFLAT= true;
  public final static boolean orPOINT= false;

  public static boolean XYVertex=true;	// true: x,y sont les coordonnees du premier vertex. // false: x,y sont les coordonnes du rectangle en au a gauche

  private static int BORDERS=50;	// nombre defaut de pixels du border.

  private static int s=0;	// taille d'un cote
  private static int t=0;	// short side of 30o triangle outside of each hex
  private static int r=0;	// radius of inscribed circle (centre to middle of each side). r= h/2
  private static int h=0;	// Largeur --> Distance between centres of two adjacent hexes. Distance between two opposite sides in a hex.

  public static void setXYasVertex(boolean b) {
    XYVertex=b;
  }
  public static void setBorders(int b){
    BORDERS=b;
  }

  // plus utile depuis back-to-basics
  public static void setSide(int side) {
    s=side;
    t =  (int) (s / 2);			//t = s sin(30) = (int) CalculateH(s);
    r =  (int) (s * 0.8660254037844);	//r = s cos(30) = (int) CalculateR(s);
    h=2*r;
  }

  public static void setHeight(int height) {
    h = height;			// h = basic dimension: height (distance between two adj centresr aka size)
    r = h/2;			// r = radius of inscribed circle
    s = (int) (h / 1.73205);	// s = (h/2)/cos(30)= (h/2) / (sqrt(3)/2) = h / sqrt(3)
    t = (int) (r / 1.73205);	// t = (h/2) tan30 = (h/2) 1/sqrt(3) = h / (2 sqrt(3)) = r / sqrt(3)
  }


  public static Polygon hex (int x0, int y0) {

    int y = y0 + BORDERS;
    int x = x0 + BORDERS; // + (XYVertex ? t : 0); // XYVertex = true.
    if (s == 0  || h == 0) {
      System.out.println("ERROR: La taille des hexa n'a pas été paramétrée");
      return new Polygon();
    }

    int[] cx,cy;

    if (XYVertex)
      cx = new int[] {x,x+s,x+s+t,x+s,x,x-t};  //this is for the top left vertex being at x,y (Some of the hex is cutoff)
    else
      cx = new int[] {x+t,x+s+t,x+s+t+t,x+s+t,x+t,x};	// this is for the whole hexagon to be below and to the right of this point

    cy = new int[] {y,y,y+r,y+r+r,y+r+r,y+r};
    return new Polygon(cx,cy,6);

		/*
		old code
		   x=200;
		   poly = new Polygon();
		   poly.addPoint(x,y);
		   poly.addPoint(x+s,y);
		   poly.addPoint(x+s+t,y+r);
		   poly.addPoint(x+s,y+r+r);
		   poly.addPoint(x,y+r+r);
		   poly.addPoint(x-t,y+r);
		 */
  }


  public void drawHex(int i, int j, Graphics2D g2) {

    ImageIcon igh= new ImageIcon(getClass().getResource("img/test.png"));
    Image img = igh.getImage();

    g2.drawImage(img,0,0,1300,1000,null);

    int x = i * (s+t);
    int y = j * h + (i%2) * h/2;
    Polygon poly = hex(x,y);
    g2.setColor(Game.COLOURCELL);
    //g2.fillPolygon(Grille.hex(x,y));
    g2.drawPolygon(poly);
    //g2.fillPolygon(poly);
    g2.setColor(Game.COLOURGRID);
    g2.drawPolygon(poly);

  }


  public static void fillHex(int i, int j, int n, Graphics2D g2) {
    char c='o';
    int x = i * (s+t);
    int y = j * h + (i%2) * h/2;
    if (n < 0) {
      g2.setColor(Game.COLOURONE);
      g2.fillPolygon(hex(x,y));
      g2.setColor(Game.COLOURONETXT);
      c = (char)(-n);
      g2.drawString(""+c, x+r+BORDERS, y+r+BORDERS+4);
    }
    if (n > 0) {
      g2.setColor(Game.COLOURTWO);
      g2.fillPolygon(hex(x,y));
      g2.setColor(Game.COLOURTWOTXT);
      c = (char)n;
      g2.drawString(""+c, x+r+BORDERS, y+r+BORDERS+4);
    }
  }

  public static Point pxtoHex(int mx, int my) {
    Point p = new Point(-1,-1);

    // correction for BORDERS and XYVertex
    mx -= BORDERS;
    my -= BORDERS;
    if (XYVertex) mx += t;

    int x = (int) (mx / (s+t)); //this gives a quick value for x. It works only on odd cols and doesn't handle the triangle sections. It assumes that the hexagon is a rectangle with width s+t (=1.5*s).
    int y = (int) ((my - (x%2)*r)/h); //this gives the row easily. It needs to be offset by h/2 (=r)if it is in an even column

    /******FIX futur pour le click *******/
    // dx,dy are the number of pixels from the hex boundary
    int dx = mx - x*(s+t);
    int dy = my - y*h;

    if (my - (x%2)*r < 0) return p; // prevent clicking in the open halfhexes at the top of the screen

    //even columns
    if (x%2==0) {
      if (dy > r) {	//bottom half of hexes
        if (dx * r /t < dy - r) {
          x--;
        }
      }
      if (dy < r) {	//top half of hexes
        if ((t - dx)*r/t > dy ) {
          x--;
          y--;
        }
      }
    } else {  // odd columns
      if (dy > h) {	//bottom half of hexes
        if (dx * r/t < dy - h) {
          x--;
          y++;
        }
      }
      if (dy < h) {	//top half of hexes
        //System.out.println("" + (t- dx)*r/t +  " " + (dy - r));
        if ((t - dx)*r/t > dy - r) {
          x--;
        }
      }
    }
    p.x=x;
    p.y=y;
    return p;
  }
}