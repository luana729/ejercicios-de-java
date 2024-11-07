import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm04 {

    public static void main(String[] args) {
        // Crear la ventana
        JFrame frame = new JFrame("Suma de Array");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Etiqueta y campo de texto
        JLabel lblElementos = new JLabel("Elementos (separados por comas):");
        lblElementos.setBounds(50, 50, 300, 30);
        frame.add(lblElementos);

        JTextField txtElementos = new JTextField();
        txtElementos.setBounds(50, 100, 300, 30);
        frame.add(txtElementos);

        JButton btnCalcular = new JButton("Calcular Suma");
        btnCalcular.setBounds(150, 150, 150, 30);
        frame.add(btnCalcular);

        // Etiqueta para mostrar el resultado
        JLabel lblResultado = new JLabel("");
        lblResultado.setBounds(50, 200, 300, 30);
        frame.add(lblResultado);

        // Acción del botón
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = txtElementos.getText();
                String[] elementos = input.split(",");
                int[] numeros = new int[elementos.length];

                try {
                    for (int i = 0; i < elementos.length; i++) {
                        numeros[i] = Integer.parseInt(elementos[i].trim());
                    }

                    int suma = sumarArray(numeros, numeros.length);
                    lblResultado.setText("Suma de elementos: " + suma);
                } catch (NumberFormatException ex) {
                    lblResultado.setText("Por favor, ingrese números válidos.");
                }
            }
        });

        // Hacer visible la ventana
        frame.setVisible(true);
    }

    public static int sumarArray(int[] array, int n) {
        if (n <= 0) {
            return 0; // Caso base
        }
        return array[n - 1] + sumarArray(array, n - 1); // Llamada recursiva
    }
}
