package repetitivas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm04 {

    public static void main(String[] args) {
        // Crear la ventana
        JFrame frame = new JFrame("Múltiplos de un Número");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Etiqueta y campo de texto para el número
        JLabel lblNumero = new JLabel("Número (n):");
        lblNumero.setBounds(50, 50, 100, 30);
        frame.add(lblNumero);

        JTextField txtNumero = new JTextField();
        txtNumero.setBounds(150, 50, 200, 30);
        frame.add(txtNumero);

        // Etiqueta y campo de texto para la cantidad de múltiplos
        JLabel lblMultiples = new JLabel("Cantidad de múltiplos (m):");
        lblMultiples.setBounds(50, 100, 200, 30);
        frame.add(lblMultiples);

        JTextField txtMultiples = new JTextField();
        txtMultiples.setBounds(250, 100, 100, 30);
        frame.add(txtMultiples);

        // Botón para calcular
        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(150, 150, 100, 30);
        frame.add(btnCalcular);

        // Etiqueta para mostrar resultados
        JLabel lblResultado = new JLabel("");
        lblResultado.setBounds(50, 200, 300, 30);
        frame.add(lblResultado);

        // Acción del botón
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numero = Integer.parseInt(txtNumero.getText());
                    int cantidadMultiples = Integer.parseInt(txtMultiples.getText());

                    if (cantidadMultiples <= 0) {
                        lblResultado.setText("Ingrese un valor positivo para m.");
                        return;
                    }

                    StringBuilder resultado = new StringBuilder("Múltiplos de " + numero + ": ");
                    for (int i = 1; i <= cantidadMultiples; i++) {
                        resultado.append(numero * i).append(" ");
                    }

                    lblResultado.setText(resultado.toString());
                } catch (NumberFormatException ex) {
                    lblResultado.setText("Por favor, ingrese números válidos.");
                }
            }
        });

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}

