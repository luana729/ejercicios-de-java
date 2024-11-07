package condicionales;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class frm23 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtNotaMatematicas;
    private JTextField txtNotaFisica;
    private JTextField txtPropina;
    private JTextField txtObsequio;
    private JButton btnCalcular;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                frm23 frame = new frm23();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    public frm23() {
        // Configuración de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        // Etiqueta y campo de texto para la nota de Matemáticas
        JLabel lblNotaMatematicas = new JLabel("Nota en Matemáticas:");
        lblNotaMatematicas.setBounds(30, 30, 150, 30);
        getContentPane().add(lblNotaMatematicas);
        txtNotaMatematicas = new JTextField();
        txtNotaMatematicas.setBounds(200, 30, 150, 30);
        getContentPane().add(txtNotaMatematicas);
        // Etiqueta y campo de texto para la nota de Física
        JLabel lblNotaFisica = new JLabel("Nota en Física:");
        lblNotaFisica.setBounds(30, 70, 150, 30);
        getContentPane().add(lblNotaFisica);
        txtNotaFisica = new JTextField();
        txtNotaFisica.setBounds(200, 70, 150, 30);
        getContentPane().add(txtNotaFisica);
        // Botón para calcular
        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(200, 110, 150, 30);
        getContentPane().add(btnCalcular);
        // Etiqueta y campo de texto para la propina total
        JLabel lblPropina = new JLabel("Propina Total:");
        lblPropina.setBounds(30, 150, 150, 30);
        getContentPane().add(lblPropina);
        txtPropina = new JTextField();
        txtPropina.setBounds(200, 150, 150, 30);
        txtPropina.setFocusable(false);
        getContentPane().add(txtPropina);
        // Etiqueta y campo de texto para el obsequio
        JLabel lblObsequio = new JLabel("Obsequio:");
        lblObsequio.setBounds(30, 190, 150, 30);
        getContentPane().add(lblObsequio);
        txtObsequio = new JTextField();
        txtObsequio.setBounds(200, 190, 150, 30);
        txtObsequio.setFocusable(false);
        getContentPane().add(txtObsequio);
        // Acción del botón Calcular
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularPropina();
            }
        });
    }
    private void calcularPropina() {
        try {
            double notaMatematicas = Double.parseDouble(txtNotaMatematicas.getText());
            double notaFisica = Double.parseDouble(txtNotaFisica.getText());
            double propinaMatematicas, propinaFisica, propinaTotal;
            // Calcular la propina de Matemáticas
            if (notaMatematicas > 17) {
                propinaMatematicas = 3.0;
            } else {
                propinaMatematicas = notaMatematicas * 1.0; // S/. 1 por cada punto
            }
            // Calcular la propina de Física
            if (notaFisica > 15) {
                propinaFisica = 2.0;
            } else {
                propinaFisica = 0.5; // S/. 0.50 en caso contrario
            }
            // Calcular la propina total
            propinaTotal = propinaMatematicas + propinaFisica;
            // Calcular el promedio y determinar si recibe un reloj
            double promedio = (notaMatematicas + notaFisica) / 2;
            String obsequio = promedio > 16 ? "Reloj" : "Sin obsequio";
            // Mostrar los resultados
            txtPropina.setText(String.format("%.2f", propinaTotal));
            txtObsequio.setText(obsequio);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese notas válidas.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
