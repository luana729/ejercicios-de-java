package repetitivas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm02 {

    public static void main(String[] args) {
        // Crear la ventana
        JFrame frame = new JFrame("Multiplicación de Dos Números");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Etiquetas y campos de texto
        JLabel lblNumero1 = new JLabel("Número 1:");
        lblNumero1.setBounds(50, 50, 100, 30);
        frame.add(lblNumero1);

        JTextField txtNumero1 = new JTextField();
        txtNumero1.setBounds(150, 50, 200, 30);
        frame.add(txtNumero1);

        JLabel lblNumero2 = new JLabel("Número 2:");
        lblNumero2.setBounds(50, 100, 100, 30);
        frame.add(lblNumero2);

        JTextField txtNumero2 = new JTextField();
        txtNumero2.setBounds(150, 100, 200, 30);
        frame.add(txtNumero2);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(150, 150, 100, 30);
        frame.add(btnCalcular);

        JLabel lblResultado = new JLabel("");
        lblResultado.setBounds(50, 200, 300, 30);
        frame.add(lblResultado);

        // Acción del botón
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numero1 = Integer.parseInt(txtNumero1.getText());
                    int numero2 = Integer.parseInt(txtNumero2.getText());

                    int resultado = multiplicarSinOperador(numero1, numero2);
                    lblResultado.setText("Resultado: " + resultado);
                } catch (NumberFormatException ex) {
                    lblResultado.setText("Por favor, ingrese números válidos.");
                }
            }
        });

        // Hacer visible la ventana
        frame.setVisible(true);
    }

    public static int multiplicarSinOperador(int a, int b) {
        int resultado = 0;
        boolean negativo = (a < 0) ^ (b < 0); // Determina si el resultado debe ser negativo

        // Usar valores absolutos para la multiplicación
        a = Math.abs(a);
        b = Math.abs(b);

        // Realizar la multiplicación mediante sumas sucesivas
        for (int i = 0; i < b; i++) {
            resultado += a;
        }

        // Ajustar el signo del resultado
        return negativo ? -resultado : resultado;
    }
}

