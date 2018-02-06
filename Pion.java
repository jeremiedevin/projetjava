public class Pion {
  private int[] position;
  private int health;
  private char morale;
  private int melee;
  private int missile;

  public int[] getPosition(){
    return this.position;
  }

  public void setPosition(int x, int y){
    int[] pos = {x,y};
    this.position = pos;
  }


  public void displayPion(Pion Pion){
    for (int t:Pion.getPosition()){
      System.out.print(t);
    }
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
