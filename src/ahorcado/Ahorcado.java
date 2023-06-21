package ahorcado;

import java.awt.Color;

public class Ahorcado {

    public static void main(String[] args) {
        pprincipal pp = new pprincipal();
        pp.getContentPane().setBackground(new Color(13,77,15));
        pp.setSize(250,500);
        pp.setVisible(true);
        pp.setLocationRelativeTo(null);
        pp.setResizable(false);
    }
    
}
