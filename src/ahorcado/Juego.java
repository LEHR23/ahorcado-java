package ahorcado;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Juego extends JFrame implements ActionListener{

    private JLabel letras[], vidas, intentos, error, acierto, imagen;
    private JButton abc[], salir;
    String pal;
    int n, errores = 7, aciertos = 0, inten = 0;
    private ImageIcon ahorcado[];

    public Juego() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        pprincipal pp = new pprincipal();
        ahorcado = new ImageIcon[8];
        ahorcado[0] = new ImageIcon("imagenes/ahorcado1.png");
        ahorcado[1] = new ImageIcon("imagenes/ahorcado2.png");
        ahorcado[2] = new ImageIcon("imagenes/ahorcado3.png");
        ahorcado[3] = new ImageIcon("imagenes/ahorcado4.png");
        ahorcado[4] = new ImageIcon("imagenes/ahorcado5.png");
        ahorcado[5] = new ImageIcon("imagenes/ahorcado6.png");
        ahorcado[6] = new ImageIcon("imagenes/ahorcado7.png");
        ahorcado[7] = new ImageIcon("imagenes/ahorcado8.png");
        String[] palabras = new String[20];
        palabras[0] = "leon";
        palabras[1] = "casa";
        palabras[2] = "futbol";
        palabras[3] = "tampico";
        palabras[4] = "automovil";
        palabras[5] = "caballo";
        palabras[6] = "resorte";
        palabras[7] = "persona";
        palabras[8] = "amor";
        palabras[9] = "sentimiento";
        palabras[10] = "computadora";
        palabras[11] = "ahorcado";
        palabras[12] = "videojuego";
        palabras[13] = "rayo";
        palabras[14] = "actor";
        palabras[15] = "puerta";
        palabras[16] = "gordo";
        palabras[17] = "llave";
        palabras[18] = "conejo";
        palabras[19] = "ganador";
        if (pp.aleato == false) {
            pal = pp.s;
        }else {
            int ran = (int)(Math.random()*19+1);
            System.out.println(ran);
            pal = palabras[ran];
        }
        n = pal.length();

        abc = new JButton[26];
        letras = new JLabel[n];
        int c = 50, b = 175;
        for (int i = 0; i < n; i++) {
            letras[i] = new JLabel("__");
            letras[i].setBounds(c, b, 30, 30);
            letras[i].setForeground(Color.black);
            add(letras[i]);
            c += 30;
            if (c >= 350) {
                c = 50;
                b += 30;
            }
        }
        c = 10;
        b = 270;
        int j = 0;
        for (int i = 97; i < 123; i++) {
            abc[j] = new JButton((char) i + "");
            abc[j].setBounds(c, b, 45, 25);
            abc[j].setForeground(Color.black);
            abc[j].addActionListener(this);
            add(abc[j]);
            c += 43;
            if (c >= 350) {
                c = 10;
                b += 25;
            }
            j++;
        }

        salir = new JButton("REGRESAR");
        salir.setBounds(256, 345, 100, 25);
        salir.addActionListener(this);
        add(salir);
        vidas = new JLabel("VIDAS: " + errores);
        vidas.setBounds(10, 10, 100, 30);
        vidas.setForeground(Color.black);
        add(vidas);
        intentos = new JLabel("INTENTOS: " + inten);
        intentos.setBounds(10, 40, 100, 30);
        intentos.setForeground(Color.black);
        add(intentos);
        error = new JLabel("ERRORES: " + (7 - errores));
        error.setBounds(10, 70, 100, 30);
        error.setForeground(Color.black);
        add(error);
        acierto = new JLabel("ACIERTOS: " + aciertos);
        acierto.setBounds(10, 100, 100, 30);
        acierto.setForeground(Color.black);
        add(acierto);
        imagen = new JLabel(ahorcado[0]);
        imagen.setBounds(190, 0, 200, 175);
        add(imagen);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == salir) {
            pprincipal pp = new pprincipal();
            pp.getContentPane().setBackground(Color.red);
            pp.setSize(250, 500);
            pp.setVisible(true);
            pp.setLocationRelativeTo(null);
            pp.setResizable(false);
            this.setVisible(false);
        }
        int j = 0;
        for (int i = 97; i < 123; i++) {
            if (e.getSource() == abc[j]) {
                inten++;
                intentos.setText("INTENTOS: " + inten);
                abc[j].setEnabled(false);
                this.seleccion((char) i);
                i = 123;
            }
            j++;
        }
    }

    public void seleccion(char c) {
        boolean err = true;
        for (int i = 0; i < n; i++) {
            if (pal.charAt(i) == c) {
                aciertos++;
                letras[i].setText(c + "");
                err = false;
            }

        }

        acierto.setText("ACIERTOS: " + aciertos);
        if (aciertos == n) {
            JOptionPane.showMessageDialog(null, "WINNER");
            for (int i = 0; i < 26; i++) {
                abc[i].setEnabled(false);
            }
        }
        if (err == true) {
            errores--;
            imagen.setIcon(ahorcado[7 - errores]);
            error.setText("ERRORES: " + (7 - errores));
            vidas.setText("VIDAS: " + errores);
        }
        if (errores == 0) {
            JOptionPane.showMessageDialog(null, "GAME OVER!!\nLA PALABRA ERA: " + pal);
            pprincipal pp = new pprincipal();
            pp.getContentPane().setBackground(Color.red);
            pp.setSize(250, 500);
            pp.setVisible(true);
            pp.setLocationRelativeTo(null);
            pp.setResizable(false);
            this.setVisible(false);
        }
    }

}
