package ahorcado;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class pprincipal extends JFrame implements ActionListener {

    private JLabel pre, imag;
    private JTextField palabra;
    private JButton start, aleatorio;
    public static String s = "";
    public static boolean aleato ;

    public pprincipal() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        pre = new JLabel("INGRESA LA PALABRA");
        pre.setBounds(50, 250, 150, 30);
        pre.setForeground(Color.white);
        add(pre);

        palabra = new JTextField();
        palabra.setBounds(50, 275, 150, 30);
        palabra.setBackground(Color.gray);
        add(palabra);

        start = new JButton("START");
        start.setBounds(75, 320, 100, 30);
        start.setBackground(Color.gray);
        start.addActionListener(this);
        add(start);

        imag = new JLabel(new ImageIcon("imagenes/ahorcado.png"));
        imag.setBounds(50, 20, 147, 190);
        add(imag);

        aleatorio = new JButton("ALEARTORIO");
        aleatorio.setBounds(65, 365, 120, 30);
        aleatorio.setBackground(Color.gray);
        aleatorio.addActionListener(this);
        add(aleatorio);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {
            s = palabra.getText().trim();
            if (s.equals("")) {
                JOptionPane.showMessageDialog(null, "Por favor Ingresa una palabra", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                aleato = false;
                Juego jue = new Juego();
                jue.setSize(400, 400);
                jue.setVisible(true);
                jue.setLocationRelativeTo(null);
                jue.setResizable(false);
                jue.getContentPane().setBackground(Color.red);
                this.setVisible(false);
            }
        }
        if (e.getSource() == aleatorio) {
            aleato = true;
            Juego jue = new Juego();
            jue.setSize(400, 400);
            jue.setVisible(true);
            jue.setLocationRelativeTo(null);
            jue.setResizable(false);
            jue.getContentPane().setBackground(Color.red);
            this.setVisible(false);
        }
    }
}
