//package gobelinGame;

public class Leader extends Pion {
    private int moralemodifier;
    private int commandlimit;

    public void setmoralemodifier(int moralemodifier)
    {
        this.moralemodifier=moralemodifier;
    }
    public void setcommandlimit(int commandlimit)
    {
        this.commandlimit=commandlimit;
    }

    public int getcommandlimit() {
        return commandlimit;
    }

    public int getmoralemodifier() {
        return moralemodifier;
    }
}
