package condicionales;

import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm37 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtVotosPamela, txtVotosCarol, txtVotosFanny, txtResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm37 frame = new frm37();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm37() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblVotosPamela = new JLabel("Votos Pamela:");
        lblVotosPamela.setBounds(50, 30, 120, 30);
        getContentPane().add(lblVotosPamela);

        JLabel lblVotosCarol = new JLabel("Votos Carol:");
        lblVotosCarol.setBounds(50, 70, 120, 30);
        getContentPane().add(lblVotosCarol);

        JLabel lblVotosFanny = new JLabel("Votos Fanny:");
        lblVotosFanny.setBounds(50, 110, 120, 30);
        getContentPane().add(lblVotosFanny);

        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(50, 150, 120, 30);
        getContentPane().add(lblResultado);

        txtVotosPamela = new JTextField();
        txtVotosPamela.setBounds(180, 30, 150, 30);
        txtVotosPamela.setHorizontalAlignment(SwingConstants.RIGHT);
        txtVotosPamela.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtVotosPamela);

        txtVotosCarol = new JTextField();
        txtVotosCarol.setBounds(180, 70, 150, 30);
        txtVotosCarol.setHorizontalAlignment(SwingConstants.RIGHT);
        txtVotosCarol.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtVotosCarol);

        txtVotosFanny = new JTextField();
        txtVotosFanny.setBounds(180, 110, 150, 30);
        txtVotosFanny.setHorizontalAlignment(SwingConstants.RIGHT);
        txtVotosFanny.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtVotosFanny);

        txtResultado = new JTextField();
        txtResultado.setBounds(180, 150, 150, 30);
        txtResultado.setFocusable(false);
        txtResultado.setHorizontalAlignment(SwingConstants.RIGHT);
        txtResultado.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtResultado);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(150, 200, 100, 30);
        btnCalcular.setMnemonic('a');
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnCalcular_actionPerformed();
            }
        });
    }

    protected void btnCalcular_actionPerformed() {
        int votosPamela = Integer.parseInt(txtVotosPamela.getText());
        int votosCarol = Integer.parseInt(txtVotosCarol.getText());
        int votosFanny = Integer.parseInt(txtVotosFanny.getText());

        int totalVotos = votosPamela + votosCarol + votosFanny;
        int mitadMasUno = (totalVotos / 2) + 1;

        if (votosPamela == votosCarol && votosCarol == votosFanny) {
            txtResultado.setText("Empate entre los tres");
            return;
        }

        if (votosPamela >= mitadMasUno) {
            txtResultado.setText("Pamela gana");
            return;
        } else if (votosCarol >= mitadMasUno) {
            txtResultado.setText("Carol gana");
            return;
        } else if (votosFanny >= mitadMasUno) {
            txtResultado.setText("Fanny gana");
            return;
        }

        int[] votos = {votosPamela, votosCarol, votosFanny};
        String[] nombres = {"Pamela", "Carol", "Fanny"};
        int[] indices = {0, 1, 2};

        for (int i = 0; i < votos.length - 1; i++) {
            for (int j = i + 1; j < votos.length; j++) {
                if (votos[i] < votos[j]) {
                    int tempVotos = votos[i];
                    votos[i] = votos[j];
                    votos[j] = tempVotos;

                    int tempIndex = indices[i];
                    indices[i] = indices[j];
                    indices[j] = tempIndex;
                }
            }
        }

        if (votos[1] == votos[2]) {
            txtResultado.setText("Empate por el segundo puesto");
        } else {
            String resultado = "Segunda vuelta entre " + nombres[indices[0]] + " y " + nombres[indices[1]];
            txtResultado.setText(resultado);
        }
    }
}
