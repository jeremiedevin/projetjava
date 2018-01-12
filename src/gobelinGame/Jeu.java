package gobelinGame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Jeu extends JFrame  {

    private JPanel pan = new JPanel();
    private JLabel label = new JLabel();
    private JButton bouton1 = new JButton("Start");
    public Jeu(){
        pan.setLayout(new BorderLayout());
        this.setTitle("Gobelin");
        this.setSize(1920,1080);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        label.setText("mettre la map ^^");

        pan.add(label);


        setContentPane(pan);

        this.setVisible(true);
    }

}