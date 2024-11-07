package condicionales;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm35 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtCodigo, txtTipoEmpleado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm35 frame = new frm35();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm35() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblCodigo = new JLabel("Código (3 cifras):");
        lblCodigo.setBounds(50, 50, 150, 30);
        getContentPane().add(lblCodigo);

        JLabel lblTipoEmpleado = new JLabel("Tipo de Empleado:");
        lblTipoEmpleado.setBounds(50, 90, 150, 30);
        getContentPane().add(lblTipoEmpleado);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(200, 50, 100, 30);
        txtCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtCodigo);

        txtTipoEmpleado = new JTextField();
        txtTipoEmpleado.setBounds(200, 90, 150, 30);
        txtTipoEmpleado.setEditable(false);
        txtTipoEmpleado.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtTipoEmpleado);

        JButton btnDeterminarTipo = new JButton("Determinar Tipo");
        btnDeterminarTipo.setBounds(130, 140, 150, 30);
        getContentPane().add(btnDeterminarTipo);

        btnDeterminarTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                determinarTipoEmpleado();
            }
        });
    }

    protected void determinarTipoEmpleado() {
        try {
            int codigo = Integer.parseInt(txtCodigo.getText());

            String tipoEmpleado = obtenerTipoEmpleado(codigo);
            txtTipoEmpleado.setText(tipoEmpleado);
        } catch (NumberFormatException e) {
            txtTipoEmpleado.setText("Error: Código inválido");
        }
    }

    private String obtenerTipoEmpleado(int codigo) {
        boolean divisiblePor2 = (codigo % 2 == 0);
        boolean divisiblePor3 = (codigo % 3 == 0);
        boolean divisiblePor5 = (codigo % 5 == 0);

        if (divisiblePor2 && divisiblePor3 && divisiblePor5) {
            return "Administrativo";
        } else if (divisiblePor3 && divisiblePor5 && !divisiblePor2) {
            return "Directivo";
        } else if (divisiblePor2 && !divisiblePor3 && !divisiblePor5) {
            return "Vendedor";
        } else {
            return "Seguridad";
        }
    }
}
