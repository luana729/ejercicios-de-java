import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm10 {

    public static void main(String[] args) {
        // Crear la ventana
        JFrame frame = new JFrame("Generar Combinaciones");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Etiqueta y campo de texto
        JLabel lblCadena = new JLabel("Cadena:");
        lblCadena.setBounds(50, 50, 100, 30);
        frame.add(lblCadena);

        JTextField txtCadena = new JTextField();
        txtCadena.setBounds(150, 50, 200, 30);
        frame.add(txtCadena);

        JButton btnGenerar = new JButton("Generar Combinaciones");
        btnGenerar.setBounds(100, 100, 200, 30);
        frame.add(btnGenerar);

        // Área de texto para mostrar resultados
        JTextArea txtResultado = new JTextArea();
        txtResultado.setBounds(50, 150, 300, 100);
        txtResultado.setEditable(false);
        frame.add(txtResultado);

        // Acción del botón
        btnGenerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cadena = txtCadena.getText();
                StringBuilder resultado = new StringBuilder();
                generarCombinaciones(cadena, "", 0, resultado);
                txtResultado.setText(resultado.toString());
            }
        });

        // Hacer visible la ventana
        frame.setVisible(true);
    }

    public static void generarCombinaciones(String cadena, String combinacion, int indice, StringBuilder resultado) {
        // Agregar la combinación actual a los resultados
        resultado.append(combinacion).append("\n");

        // Generar combinaciones adicionales
        for (int i = indice; i < cadena.length(); i++) {
            // Llamada recursiva
            generarCombinaciones(cadena, combinacion + cadena.charAt(i), i + 1, resultado);
        }
    }
}
