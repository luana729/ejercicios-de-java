package condicionales;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm39 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtAusencia, txtTornillosDefectuosos, txtTornillosNoDefectuosos, txtResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm39 frame = new frm39();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm39() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblAusencia = new JLabel("Horas de ausencia:");
        lblAusencia.setBounds(50, 30, 150, 30);
        getContentPane().add(lblAusencia);

        JLabel lblTornillosDefectuosos = new JLabel("Tornillos defectuosos:");
        lblTornillosDefectuosos.setBounds(50, 70, 150, 30);
        getContentPane().add(lblTornillosDefectuosos);

        JLabel lblTornillosNoDefectuosos = new JLabel("Tornillos no defectuosos:");
        lblTornillosNoDefectuosos.setBounds(50, 110, 150, 30);
        getContentPane().add(lblTornillosNoDefectuosos);

        JLabel lblResultado = new JLabel("Grado de eficiencia:");
        lblResultado.setBounds(50, 150, 150, 30);
        getContentPane().add(lblResultado);

        txtAusencia = new JTextField();
        txtAusencia.setBounds(210, 30, 100, 30);
        txtAusencia.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtAusencia);

        txtTornillosDefectuosos = new JTextField();
        txtTornillosDefectuosos.setBounds(210, 70, 100, 30);
        txtTornillosDefectuosos.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtTornillosDefectuosos);

        txtTornillosNoDefectuosos = new JTextField();
        txtTornillosNoDefectuosos.setBounds(210, 110, 100, 30);
        txtTornillosNoDefectuosos.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtTornillosNoDefectuosos);

        txtResultado = new JTextField();
        txtResultado.setBounds(210, 150, 100, 30);
        txtResultado.setEditable(false);
        txtResultado.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(txtResultado);

        JButton btnCalcular = new JButton("Calcular Grado");
        btnCalcular.setBounds(130, 200, 120, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularGradoEficiencia();
            }
        });
    }

    protected void calcularGradoEficiencia() {
        try {
            double horasAusencia = Double.parseDouble(txtAusencia.getText());
            int tornillosDefectuosos = Integer.parseInt(txtTornillosDefectuosos.getText());
            int tornillosNoDefectuosos = Integer.parseInt(txtTornillosNoDefectuosos.getText());

            boolean condicion1 = horasAusencia <= 1.5;
            boolean condicion2 = tornillosDefectuosos < 300;
            boolean condicion3 = tornillosNoDefectuosos > 10000;

            int gradoEficiencia;

            if (condicion1 && condicion2 && condicion3) {
                gradoEficiencia = 20;
            } else if (condicion1 && condicion2) {
                gradoEficiencia = 12;
            } else if (condicion1 && condicion3) {
                gradoEficiencia = 13;
            } else if (condicion2 && condicion3) {
                gradoEficiencia = 15;
            } else if (condicion1) {
                gradoEficiencia = 7;
            } else if (condicion2) {
                gradoEficiencia = 8;
            } else if (condicion3) {
                gradoEficiencia = 9;
            } else {
                gradoEficiencia = 5;
            }

            txtResultado.setText(String.valueOf(gradoEficiencia));
        } catch (NumberFormatException e) {
            txtResultado.setText("Datos invÃ¡lidos");
        }
    }
}
