package repetitivas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm01{

    public static void main(String[] args) {
        // Crear la ventana
        JFrame frame = new JFrame("División por Restas Sucesivas");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Etiquetas y campos de texto
        JLabel lblDividendo = new JLabel("Dividendo:");
        lblDividendo.setBounds(50, 50, 100, 30);
        frame.add(lblDividendo);

        JTextField txtDividendo = new JTextField();
        txtDividendo.setBounds(150, 50, 200, 30);
        frame.add(txtDividendo);

        JLabel lblDivisor = new JLabel("Divisor:");
        lblDivisor.setBounds(50, 100, 100, 30);
        frame.add(lblDivisor);

        JTextField txtDivisor = new JTextField();
        txtDivisor.setBounds(150, 100, 200, 30);
        frame.add(txtDivisor);

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
                    int dividendo = Integer.parseInt(txtDividendo.getText());
                    int divisor = Integer.parseInt(txtDivisor.getText());

                    if (divisor == 0) {
                        lblResultado.setText("El divisor no puede ser cero.");
                        return;
                    }

                    int[] resultado = divisionPorRestas(dividendo, divisor);
                    lblResultado.setText("Cociente: " + resultado[0] + ", Resto: " + resultado[1]);
                } catch (NumberFormatException ex) {
                    lblResultado.setText("Por favor, ingrese números válidos.");
                }
            }
        });

        // Hacer visible la ventana
        frame.setVisible(true);
    }

    public static int[] divisionPorRestas(int dividendo, int divisor) {
        int cociente = 0;

        // Asegurarse de trabajar con números positivos
        int absDividendo = Math.abs(dividendo);
        int absDivisor = Math.abs(divisor);

        // Restar el divisor del dividendo sucesivamente
        while (absDividendo >= absDivisor) {
            absDividendo -= absDivisor;
            cociente++;
        }

        // El resto será el valor que queda después de las restas
        return new int[]{cociente, absDividendo};
    }
}

