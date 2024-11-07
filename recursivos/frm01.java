import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm01 {

    public static void main(String[] args) {
        // Crear la ventana
        JFrame frame = new JFrame("Cálculo de Potencia");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Etiqueta y campos de texto
        JLabel lblBase = new JLabel("Base (a):");
        lblBase.setBounds(50, 50, 100, 30);
        frame.add(lblBase);

        JTextField txtBase = new JTextField();
        txtBase.setBounds(150, 50, 200, 30);
        frame.add(txtBase);

        JLabel lblExponente = new JLabel("Exponente (b):");
        lblExponente.setBounds(50, 100, 100, 30);
        frame.add(lblExponente);

        JTextField txtExponente = new JTextField();
        txtExponente.setBounds(150, 100, 200, 30);
        frame.add(txtExponente);

        JButton btnCalcular = new JButton("Calcular Potencia");
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
                try {
                    double base = Double.parseDouble(txtBase.getText());
                    int exponente = Integer.parseInt(txtExponente.getText());
                    double resultado = calcularPotencia(base, exponente);
                    lblResultado.setText(base + " elevado a " + exponente + " es: " + resultado);
                } catch (NumberFormatException ex) {
                    lblResultado.setText("Por favor, ingrese números válidos.");
                }
            }
        });

        // Hacer visible la ventana
        frame.setVisible(true);
    }

    public static double calcularPotencia(double a, int b) {
        if (b == 0) {
            return 1; // Caso base
        }
        return a * calcularPotencia(a, b - 1); // Llamada recursiva
    }
}
