package repetitivas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm03 {

    public static void main(String[] args) {
        // Crear la ventana
        JFrame frame = new JFrame("Cantidad de Divisores");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Etiqueta y campo de texto
        JLabel lblNumero = new JLabel("Número:");
        lblNumero.setBounds(50, 50, 100, 30);
        frame.add(lblNumero);

        JTextField txtNumero = new JTextField();
        txtNumero.setBounds(150, 50, 200, 30);
        frame.add(txtNumero);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(150, 100, 100, 30);
        frame.add(btnCalcular);

        JLabel lblResultado = new JLabel("");
        lblResultado.setBounds(50, 150, 300, 30);
        frame.add(lblResultado);

        // Acción del botón
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numero = Integer.parseInt(txtNumero.getText());
                    int cantidadDivisores = contarDivisores(numero);
                    lblResultado.setText("Cantidad de divisores: " + cantidadDivisores);
                } catch (NumberFormatException ex) {
                    lblResultado.setText("Por favor, ingrese un número válido.");
                }
            }
        });

        // Hacer visible la ventana
        frame.setVisible(true);
    }

    public static int contarDivisores(int numero) {
        int contador = 0;

        // Si el número es 0, no tiene divisores.
        if (numero == 0) {
            return 0;
        }

        // Contar divisores
        for (int i = 1; i <= Math.abs(numero); i++) {
            if (numero % i == 0) {
                contador++;
            }
        }

        return contador;
    }
}
