import javax.swing.*;
import java.awt.*;

public class Pion {
  private int x;
  private int y;
  private int health;
  private char morale;
  private int melee;
  private int missile;

  public int getX(){
    return this.x;
  }

  public int getY(){
    return this.y;
  }

  public void setPosition(int x, int y){
    this.x = x;
    this.y = y;
  }


  public void displayPion(Pion Pion){

    ImageIcon pion_soldat= new ImageIcon(getClass().getResource("img/pion_soldat.png"));
    Image imgsold = pion_soldat.getImage();


    g2.drawImage(imgsold,Pion.getX(),Pion.getY(),100,100,null);
    System.out.print(Pion.getX());
  }







  public int getHealth() {
    return this.health;
  }

  public char getMorale() {
    return this.morale;
  }

  public int getMelee() {
    return this.melee;
  }

  public int getMissile() {
    return this.missile;
  }

}
