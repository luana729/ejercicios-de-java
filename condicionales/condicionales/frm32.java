package condicionales;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm32 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtCategoria, txtPromedio, txtPensionActual, txtDescuento, txtNuevaPension;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm32 frame = new frm32();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm32() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblCategoria = new JLabel("Categoría:");
        lblCategoria.setBounds(50, 50, 80, 30);
        getContentPane().add(lblCategoria);

        JLabel lblPromedio = new JLabel("Promedio:");
        lblPromedio.setBounds(50, 90, 80, 30);
        getContentPane().add(lblPromedio);

        JLabel lblPensionActual = new JLabel("Pensión Actual:");
        lblPensionActual.setBounds(50, 130, 100, 30);
        getContentPane().add(lblPensionActual);

        JLabel lblDescuento = new JLabel("Descuento:");
        lblDescuento.setBounds(50, 170, 80, 30);
        getContentPane().add(lblDescuento);

        JLabel lblNuevaPension = new JLabel("Nueva Pensión:");
        lblNuevaPension.setBounds(50, 210, 100, 30);
        getContentPane().add(lblNuevaPension);

        txtCategoria = new JTextField();
        txtCategoria.setBounds(150, 50, 60, 30);
        txtCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtCategoria);

        txtPromedio = new JTextField();
        txtPromedio.setBounds(150, 90, 60, 30);
        txtPromedio.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtPromedio);

        txtPensionActual = new JTextField();
        txtPensionActual.setBounds(150, 130, 60, 30);
        txtPensionActual.setEditable(false);
        txtPensionActual.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtPensionActual);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(150, 170, 60, 30);
        txtDescuento.setEditable(false);
        txtDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtDescuento);

        txtNuevaPension = new JTextField();
        txtNuevaPension.setBounds(150, 210, 60, 30);
        txtNuevaPension.setEditable(false);
        txtNuevaPension.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtNuevaPension);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(100, 250, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularPension();
            }
        });
    }

    protected void calcularPension() {
        String categoria = txtCategoria.getText().toUpperCase();
        double promedio = Double.parseDouble(txtPromedio.getText());
        double pensionActual = 0, descuento = 0, nuevaPension = 0;

        switch (categoria) {
            case "A":
                pensionActual = 550;
                if (promedio >= 0 && promedio <= 13.99) descuento = 0;
                break;
            case "B":
                pensionActual = 500;
                if (promedio >= 14 && promedio <= 15.99) descuento = 0.10 * pensionActual;
                break;
            case "C":
                pensionActual = 450;
                if (promedio >= 16 && promedio <= 17.99) descuento = 0.12 * pensionActual;
                break;
            case "D":
                pensionActual = 400;
                if (promedio >= 18 && promedio <= 20) descuento = 0.15 * pensionActual;
                break;
            default:
                txtPensionActual.setText("Categoría Inválida");
                return;
        }

        nuevaPension = pensionActual - descuento;
        txtPensionActual.setText("S/. " + pensionActual);
        txtDescuento.setText("S/. " + descuento);
        txtNuevaPension.setText("S/. " + nuevaPension);
    }
}
