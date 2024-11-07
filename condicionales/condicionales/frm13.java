package condicionales;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class frm13 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtNumero;
    private JTextField txtResultado;
    private JButton btnVerificar;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                frm13 frame = new frm13();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    public frm13() {
        // Configuración de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 380, 200);
        setLayout(null);
        setLocationRelativeTo(null);
        // Etiqueta y campo de texto para el número
        JLabel lblNumero = new JLabel("Ingrese un número de 3 cifras:");
        lblNumero.setBounds(30, 30, 200, 30);
        getContentPane().add(lblNumero);
        txtNumero = new JTextField();
        txtNumero.setBounds(230, 30, 100, 30);
        getContentPane().add(txtNumero);
        // Botón para verificar las cifras
        btnVerificar = new JButton("Verificar Cifras");
        btnVerificar.setBounds(230, 70, 100, 30);
        getContentPane().add(btnVerificar);
        // Etiqueta y campo de texto para el resultado
        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(30, 110, 100, 30);
        getContentPane().add(lblResultado);
        txtResultado = new JTextField();
        txtResultado.setBounds(230, 110, 100, 30);
        txtResultado.setFocusable(false);
        getContentPane().add(txtResultado);
        // Acción del botón Verificar
        btnVerificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarCifras();
            }
        });
    }
    private void verificarCifras() {
        try {
            int numero = Integer.parseInt(txtNumero.getText());
            // Verificar que el número tenga tres cifras y sea positivo
            if (numero < 100 || numero > 999) {
                txtResultado.setText("Ingrese un número de 3 cifras.");
                return;
            }
            // Extraer las cifras
            int unidad = numero % 10;
            int decena = (numero / 10) % 10;
            int centena = numero / 100;
            // Verificar si las cifras son consecutivas
            if ((centena == decena - 1 && decena == unidad - 1) || 
                (centena == decena + 1 && decena == unidad + 1)) {
                txtResultado.setText("Las cifras son consecutivas.");
            } else {
                txtResultado.setText("Las cifras NO son consecutivas.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número entero positivo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}