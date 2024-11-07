package repetitivas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm05 {

    public static void main(String[] args) {
        // Crear la ventana
        JFrame frame = new JFrame("Tabla de Multiplicar");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Etiqueta y campo de texto
        JLabel lblNumero = new JLabel("Número (n):");
        lblNumero.setBounds(50, 50, 100, 30);
        frame.add(lblNumero);

        JTextField txtNumero = new JTextField();
        txtNumero.setBounds(150, 50, 200, 30);
        frame.add(txtNumero);

        JButton btnCalcular = new JButton("Generar Tabla");
        btnCalcular.setBounds(150, 100, 150, 30);
        frame.add(btnCalcular);

        // Área de texto para mostrar la tabla
        JTextArea txtResultado = new JTextArea();
        txtResultado.setBounds(50, 150, 300, 100);
        txtResultado.setEditable(false);
        frame.add(txtResultado);

        // Acción del botón
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numero = Integer.parseInt(txtNumero.getText());
                    StringBuilder tabla = new StringBuilder("Tabla de Multiplicar de " + numero + ":\n\n");

                    // Generar la tabla del 1 al 12
                    for (int i = 1; i <= 12; i++) {
                        tabla.append(numero).append(" x ").append(i).append(" = ").append(numero * i).append("\n");
                    }

                    // Mostrar la tabla en el área de texto
                    txtResultado.setText(tabla.toString());
                } catch (NumberFormatException ex) {
                    txtResultado.setText("Por favor, ingrese un número válido.");
                }
            }
        });

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}

