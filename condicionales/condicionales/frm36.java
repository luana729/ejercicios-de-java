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

public class frm36 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtCuadernos, txtLucas, txtFaber, txtPilot;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm36 frame = new frm36();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm36() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblCuadernos = new JLabel("Cuadernos:");
        lblCuadernos.setBounds(50, 30, 120, 30);
        getContentPane().add(lblCuadernos);

        JLabel lblLucas = new JLabel("Lapiceros Lucas:");
        lblLucas.setBounds(50, 70, 120, 30);
        getContentPane().add(lblLucas);

        JLabel lblFaber = new JLabel("Lapiceros Faber:");
        lblFaber.setBounds(50, 110, 120, 30);
        getContentPane().add(lblFaber);

        JLabel lblPilot = new JLabel("Lapiceros Pilot:");
        lblPilot.setBounds(50, 150, 120, 30);
        getContentPane().add(lblPilot);

        txtCuadernos = new JTextField();
        txtCuadernos.setBounds(180, 30, 150, 30);
        txtCuadernos.setHorizontalAlignment(SwingConstants.RIGHT);
        txtCuadernos.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtCuadernos);

        txtLucas = new JTextField();
        txtLucas.setBounds(180, 70, 150, 30);
        txtLucas.setFocusable(false);
        txtLucas.setHorizontalAlignment(SwingConstants.RIGHT);
        txtLucas.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtLucas);

        txtFaber = new JTextField();
        txtFaber.setBounds(180, 110, 150, 30);
        txtFaber.setFocusable(false);
        txtFaber.setHorizontalAlignment(SwingConstants.RIGHT);
        txtFaber.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtFaber);

        txtPilot = new JTextField();
        txtPilot.setBounds(180, 150, 150, 30);
        txtPilot.setFocusable(false);
        txtPilot.setHorizontalAlignment(SwingConstants.RIGHT);
        txtPilot.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtPilot);

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
        int cuadernos = Integer.parseInt(txtCuadernos.getText());
        int lucas = 0, faber = 0, pilot = 0;

        if (cuadernos >= 36) {
            pilot = (cuadernos / 4) * 2;
            faber = (cuadernos / 6);
            lucas = (cuadernos / 12);
        } else if (cuadernos >= 24) {
            faber = (cuadernos / 4) * 2;
        } else if (cuadernos >= 12) {
            lucas = (cuadernos / 4);
        }

        txtLucas.setText(String.valueOf(lucas));
        txtFaber.setText(String.valueOf(faber));
        txtPilot.setText(String.valueOf(pilot));
    }
}
