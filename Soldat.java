//package gobelinGame;

public class Soldat extends Pion {
    private char morale;
    private int melee;
    private int missile;

    public void setmelee(int melee) {
        this.melee = melee;
    }

    public void setmissile(int missile) {
        this.missile = missile;
    }

    public void setmorale(char morale) {
        this.morale = morale;
    }

    public char getmorale() {
        return morale;
    }

    public int getmelee() {
        return melee;
    }

    public int getmissile() {
        return missile;
    }

}
