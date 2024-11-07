package condicionales;

import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm38 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtMes, txtAño, txtNombreMes, txtDias;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm38 frame = new frm38();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm38() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblMes = new JLabel("Mes (1-12):");
        lblMes.setBounds(50, 30, 120, 30);
        getContentPane().add(lblMes);

        JLabel lblAño = new JLabel("Año:");
        lblAño.setBounds(50, 70, 120, 30);
        getContentPane().add(lblAño);

        JLabel lblNombreMes = new JLabel("Nombre del Mes:");
        lblNombreMes.setBounds(50, 110, 120, 30);
        getContentPane().add(lblNombreMes);

        JLabel lblDias = new JLabel("Cantidad de Dias:");
        lblDias.setBounds(50, 150, 120, 30);
        getContentPane().add(lblDias);

        txtMes = new JTextField();
        txtMes.setBounds(180, 30, 150, 30);
        txtMes.setHorizontalAlignment(SwingConstants.RIGHT);
        txtMes.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtMes);

        txtAño = new JTextField();
        txtAño.setBounds(180, 70, 150, 30);
        txtAño.setHorizontalAlignment(SwingConstants.RIGHT);
        txtAño.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtAño);

        txtNombreMes = new JTextField();
        txtNombreMes.setBounds(180, 110, 150, 30);
        txtNombreMes.setFocusable(false);
        txtNombreMes.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNombreMes.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtNombreMes);

        txtDias = new JTextField();
        txtDias.setBounds(180, 150, 150, 30);
        txtDias.setFocusable(false);
        txtDias.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDias.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtDias);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(150, 200, 100, 30);
        btnCalcular.setMnemonic('a');
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnCalcular_actionPerformed();
            }
        });
    }

    protected void btnCalcular_actionPerformed() {
        int mes = Integer.parseInt(txtMes.getText());
        int año = Integer.parseInt(txtAño.getText());
        String nombreMes;
        int dias;

        switch (mes) {
            case 1:
                nombreMes = "Enero";
                dias = 31;
                break;
            case 2:
                nombreMes = "Febrero";
                if ((año % 4 == 0 && año % 100 != 0) || (año % 400 == 0)) {
                    dias = 29;
                } else {
                    dias = 28;
                }
                break;
            case 3:
                nombreMes = "Marzo";
                dias = 31;
                break;
            case 4:
                nombreMes = "Abril";
                dias = 30;
                break;
            case 5:
                nombreMes = "Mayo";
                dias = 31;
                break;
            case 6:
                nombreMes = "Junio";
                dias = 30;
                break;
            case 7:
                nombreMes = "Julio";
                dias = 31;
                break;
            case 8:
                nombreMes = "Agosto";
                dias = 31;
                break;
            case 9:
                nombreMes = "Septiembre";
                dias = 30;
                break;
            case 10:
                nombreMes = "Octubre";
                dias = 31;
                break;
            case 11:
                nombreMes = "Noviembre";
                dias = 30;
                break;
            case 12:
                nombreMes = "Diciembre";
                dias = 31;
                break;
            default:
                nombreMes = "Mes invÃ¡lido";
                dias = 0;
                break;
        }

        txtNombreMes.setText(nombreMes);
        txtDias.setText(String.valueOf(dias));
    }
}