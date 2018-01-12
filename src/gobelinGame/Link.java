package gobelinGame;


public class Link
{


    public boolean Link (int x1, int y1, int x2, int y2,int[] row)
    {
        boolean link=true;
        int forbidden[][] ={
                {   /**premiere paire de coordonnées interdites*/},
                {   /**deuxieme paire de coordonnées*/},
                {   /**troisieme paire de coordonnées*/},
                {   /**quatrieme paire de coordonnées*/},
                {   /**cinquieme paire de coordonnées*/},
                {   /**sixieme paire de coordonnées*/},
                {   /**septieme paire de coordonnées*/},
                {   /**huitieme paire de coordonnées*/},
                {   /**neuvieme paire de coordonnées*/},
            };
        for (int i:row )
        {
            if ((forbidden[i][0] == x1 && forbidden[i][1] == y1 && forbidden[i][2] == x2 && forbidden[i][3] == y2 )||(forbidden[i][2] == x1 && forbidden[i][3] == y1 && forbidden[i][0] == x2 && forbidden[i][1] == y2) )
            {
                link = false;
                break;
            }
        }
        return link;
    }
}