package condicionales;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm34 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtPeso, txtAltura, txtIMC, txtResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm34 frame = new frm34();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm34() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblPeso = new JLabel("Peso (kg):");
        lblPeso.setBounds(50, 50, 100, 30);
        getContentPane().add(lblPeso);

        JLabel lblAltura = new JLabel("Altura (m):");
        lblAltura.setBounds(50, 90, 100, 30);
        getContentPane().add(lblAltura);

        JLabel lblIMC = new JLabel("IMC:");
        lblIMC.setBounds(50, 130, 100, 30);
        getContentPane().add(lblIMC);

        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(50, 170, 100, 30);
        getContentPane().add(lblResultado);

        txtPeso = new JTextField();
        txtPeso.setBounds(160, 50, 100, 30);
        txtPeso.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtPeso);

        txtAltura = new JTextField();
        txtAltura.setBounds(160, 90, 100, 30);
        txtAltura.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtAltura);

        txtIMC = new JTextField();
        txtIMC.setBounds(160, 130, 100, 30);
        txtIMC.setEditable(false);
        txtIMC.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtIMC);

        txtResultado = new JTextField();
        txtResultado.setBounds(160, 170, 150, 30);
        txtResultado.setEditable(false);
        txtResultado.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtResultado);

        JButton btnCalcular = new JButton("Calcular IMC");
        btnCalcular.setBounds(130, 220, 120, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularIMC();
            }
        });
    }

    protected void calcularIMC() {
        try {
            double peso = Double.parseDouble(txtPeso.getText());
            double altura = Double.parseDouble(txtAltura.getText());
            double imc = peso / (altura * altura);

            txtIMC.setText(String.format("%.2f", imc));
            txtResultado.setText(obtenerClasificacionIMC(imc));
        } catch (NumberFormatException e) {
            txtIMC.setText("Error");
            txtResultado.setText("Datos inválidos");
        }
    }

    private String obtenerClasificacionIMC(double imc) {
        if (imc < 20) {
            return "Delgado";
        } else if (imc >= 20 && imc <= 25) {
            return "Normal";
        } else if (imc > 25 && imc <= 27) {
            return "Sobrepeso";
        } else {
            return "Obesidad";
        }
    }
}

