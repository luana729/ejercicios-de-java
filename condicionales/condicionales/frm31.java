package condicionales;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm31 extends JFrame { 
    private static final long serialVersionUID = 1L;
    JTextField txtCategoria, txtHoras, txtSueldoBruto, txtDescuento, txtSueldoNeto;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm31 frame = new frm31(); 
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm31() { 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblCategoria = new JLabel("Categoría:");
        lblCategoria.setBounds(50, 50, 80, 30);
        getContentPane().add(lblCategoria);

        JLabel lblHoras = new JLabel("Horas:");
        lblHoras.setBounds(50, 90, 80, 30);
        getContentPane().add(lblHoras);

        JLabel lblSueldoBruto = new JLabel("Sueldo Bruto:");
        lblSueldoBruto.setBounds(50, 130, 100, 30);
        getContentPane().add(lblSueldoBruto);

        JLabel lblDescuento = new JLabel("Descuento:");
        lblDescuento.setBounds(50, 170, 80, 30);
        getContentPane().add(lblDescuento);

        JLabel lblSueldoNeto = new JLabel("Sueldo Neto:");
        lblSueldoNeto.setBounds(50, 210, 100, 30);
        getContentPane().add(lblSueldoNeto);

        txtCategoria = new JTextField();
        txtCategoria.setBounds(150, 50, 60, 30);
        txtCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtCategoria);

        txtHoras = new JTextField();
        txtHoras.setBounds(150, 90, 60, 30);
        txtHoras.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtHoras);

        txtSueldoBruto = new JTextField();
        txtSueldoBruto.setBounds(150, 130, 80, 30);
        txtSueldoBruto.setEditable(false);
        txtSueldoBruto.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtSueldoBruto);

        txtDescuento = new JTextField();
        txtDescuento.setBounds(150, 170, 80, 30);
        txtDescuento.setEditable(false);
        txtDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtDescuento);

        txtSueldoNeto = new JTextField();
        txtSueldoNeto.setBounds(150, 210, 80, 30);
        txtSueldoNeto.setEditable(false);
        txtSueldoNeto.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtSueldoNeto);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(100, 280, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularSueldo();
            }
        });
    }

    protected void calcularSueldo() {
        try {
            String categoria = txtCategoria.getText().toUpperCase();
            int horas = Integer.parseInt(txtHoras.getText());
            double tarifa = 0;

            switch (categoria) {
                case "A":
                    tarifa = 21.00;
                    break;
                case "B":
                    tarifa = 19.50;
                    break;
                case "C":
                    tarifa = 17.00;
                    break;
                case "D":
                    tarifa = 15.50;
                    break;
                default:
                    txtSueldoBruto.setText("Categoría Inválida");
                    txtDescuento.setText("");
                    txtSueldoNeto.setText("");
                    return;
            }

            double sueldoBruto = horas * tarifa;
            double descuento = (sueldoBruto > 2500) ? sueldoBruto * 0.20 : sueldoBruto * 0.15;
            double sueldoNeto = sueldoBruto - descuento;

            DecimalFormat df = new DecimalFormat("###.00");
            txtSueldoBruto.setText("S/. " + df.format(sueldoBruto));
            txtDescuento.setText("S/. " + df.format(descuento));
            txtSueldoNeto.setText("S/. " + df.format(sueldoNeto));

        } catch (NumberFormatException e) {
            txtSueldoBruto.setText("Error en datos");
            txtDescuento.setText("");
            txtSueldoNeto.setText("");
        }
    }
}
