import javax.swing.*;
import java.awt.*;

public class Pion {
  private int[] position;
  private int health;
 /* private char morale;
  private int melee;
  private int missile;
*/
  public int[] getPosition(Pion Pion){
    int x = Pion.x;
    int y = Pion.y
    return this.position;
  }
        
  public void setPosition(int x, int y){
    int[] pos = {x,y};
    this.position = pos;
  }


  public void displayPion(Pion Pion, Graphics g){
    for (int t:Pion.getPosition()){
        ImageIcon pion_soldat= new ImageIcon(getClass().getResource("img/pion_soldat.png"));
        Image imgsold = pion_soldat.getImage();
        Graphics2D g3 = (Graphics2D)g;
        //g3.drawImage(imgsold,2,2,100,100,null);
      System.out.print(Pion.getPosition());
    }
  }

  public int getHealth() {
    return this.health;
  }
/*
  public char getMorale() {
    return this.morale;
  }

  public int getMelee() {
    return this.melee;
  }

  public int getMissile() {
    return this.missile;
  }*/

}
