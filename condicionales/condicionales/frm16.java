package condicionales;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class frm16 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtCostoCasa;
    private JTextField txtIngresoMensual;
    private JTextField txtCuotaInicial;
    private JTextField txtCuotaMensual;
    private JButton btnCalcular;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                frm16 frame = new frm16();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    public frm16() {
        // Configuración de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        // Etiqueta y campo de texto para el costo de la casa
        JLabel lblCostoCasa = new JLabel("Costo de la Casa:");
        lblCostoCasa.setBounds(30, 30, 150, 30);
        getContentPane().add(lblCostoCasa);
        txtCostoCasa = new JTextField();
        txtCostoCasa.setBounds(200, 30, 150, 30);
        getContentPane().add(txtCostoCasa);
        // Etiqueta y campo de texto para el ingreso mensual
        JLabel lblIngresoMensual = new JLabel("Ingreso Mensual:");
        lblIngresoMensual.setBounds(30, 70, 150, 30);
        getContentPane().add(lblIngresoMensual);
        txtIngresoMensual = new JTextField();
        txtIngresoMensual.setBounds(200, 70, 150, 30);
        getContentPane().add(txtIngresoMensual);
        // Botón para calcular
        btnCalcular = new JButton("Calcular Cuotas");
        btnCalcular.setBounds(200, 110, 150, 30);
        getContentPane().add(btnCalcular);
        // Etiqueta y campo de texto para la cuota inicial
        JLabel lblCuotaInicial = new JLabel("Cuota Inicial:");
        lblCuotaInicial.setBounds(30, 150, 100, 30);
        getContentPane().add(lblCuotaInicial);
        txtCuotaInicial = new JTextField();
        txtCuotaInicial.setBounds(200, 150, 150, 30);
        txtCuotaInicial.setFocusable(false);
        getContentPane().add(txtCuotaInicial);
        // Etiqueta y campo de texto para la cuota mensual
        JLabel lblCuotaMensual = new JLabel("Cuota Mensual:");
        lblCuotaMensual.setBounds(30, 190, 100, 30);
        getContentPane().add(lblCuotaMensual);
        txtCuotaMensual = new JTextField();
        txtCuotaMensual.setBounds(200, 190, 150, 30);
        txtCuotaMensual.setFocusable(false);
        getContentPane().add(txtCuotaMensual);
        // Acción del botón Calcular
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularCuotas();
            }
        });
    }
    private void calcularCuotas() {
        try {
            double costoCasa = Double.parseDouble(txtCostoCasa.getText());
            double ingresoMensual = Double.parseDouble(txtIngresoMensual.getText());
            double cuotaInicial;
            double cuotaMensual;
            int numCuotas;
            // Condiciones según el ingreso mensual
            if (ingresoMensual < 1250) {
                cuotaInicial = costoCasa * 0.15;
                numCuotas = 120;
            } else {
                cuotaInicial = costoCasa * 0.30;
                numCuotas = 75;
            }
            // Calcular la cuota mensual
            cuotaMensual = (costoCasa - cuotaInicial) / numCuotas;
            // Mostrar los resultados
            txtCuotaInicial.setText(String.format("%.2f", cuotaInicial));
            txtCuotaMensual.setText(String.format("%.2f", cuotaMensual));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
