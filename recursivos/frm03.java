import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm03 {

    public static void main(String[] args) {
        // Crear la ventana
        JFrame frame = new JFrame("Cálculo de Factorial");
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

        JButton btnCalcular = new JButton("Calcular Factorial");
        btnCalcular.setBounds(150, 100, 150, 30);
        frame.add(btnCalcular);

        // Etiqueta para mostrar el resultado
        JLabel lblResultado = new JLabel("");
        lblResultado.setBounds(50, 150, 300, 30);
        frame.add(lblResultado);

        // Acción del botón
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numero = Integer.parseInt(txtNumero.getText());
                    long resultado = calcularFactorial(numero);
                    lblResultado.setText("Factorial de " + numero + " es: " + resultado);
                } catch (NumberFormatException ex) {
                    lblResultado.setText("Por favor, ingrese un número válido.");
                }
            }
        });

        // Hacer visible la ventana
        frame.setVisible(true);
    }

    public static long calcularFactorial(int n) {
        if (n <= 1) {
            return 1; // Caso base
        }
        return n * calcularFactorial(n - 1); // Llamada recursiva
    }
}
