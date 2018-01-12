/*import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Fenetre extends JFrame{
    public Fenetre(){
        this.setTitle("Bouton");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //On définit le layout à utiliser sur le content pane
        //Trois lignes sur deux colonnes
        this.setLayout(new GridLayout(3, 1, 5, 5));
        //On ajoute le bouton au content pane de la JFrame
        this.getContentPane().add(new JButton("Jouer"));
        this.getContentPane().add(new JButton("Tutoriel"));
        this.getContentPane().add(new JButton("Quitter"));
        this.setVisible(true);
    }
}*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetre extends JFrame{
    private Jeu fen;
    private Panneau pan = new Panneau();
    private JButton bouton = new JButton("Quitter");
    private JButton bouton2 = new JButton("Jouer");
    private JPanel container = new JPanel();
    private JLabel label = new JLabel("Le JLabel");
    private int compteur = 0;
    private boolean animated = true;
    private boolean backX, backY;
    private int x, y;

    public Fenetre(){
        this.setTitle("Menu Principal");
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());
        container.add(pan, BorderLayout.CENTER);
        bouton.addActionListener(new BoutonListener());
        bouton.setEnabled(true);
        bouton2.addActionListener(new Bouton2Listener());

        JPanel south = new JPanel();
        south.add(bouton);
        south.add(bouton2);
        container.add(south, BorderLayout.SOUTH);
        Font police = new Font("Tahoma", Font.BOLD, 16);
        label.setFont(police);
        label.setForeground(Color.blue);
        label.setHorizontalAlignment(JLabel.CENTER);
        container.add(label, BorderLayout.NORTH);
        this.setContentPane(container);
        this.setVisible(true);
    }

    class BoutonListener implements ActionListener{
        public void actionPerformed(ActionEvent arg0) {
            dispose();
        }
    }

    class Bouton2Listener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            fen = new Jeu();
            dispose();
        }
    }
}
/*
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Fenetre extends JFrame implements ActionListener {
    private Jeu fen;
    private JPanel pan = new JPanel();

    private JButton bouton1 = new JButton("Start");
    public Fenetre(){
        pan.setLayout(null);
        this.setTitle("Jeux casse brique");
        this.setSize(400, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        bouton1.setBackground(Color.cyan);
        bouton1.setBounds(200,150, 300, 200);

        pan.add(bouton1);


        setContentPane(pan);
        bouton1.addActionListener(this);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent arg0) {
        //Lorsque nous cliquons sur notre bouton, on passe a l'autre fenétre
        this.dispose();
        fen = new Jeu();
    }

}*/