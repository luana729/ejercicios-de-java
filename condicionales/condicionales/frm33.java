package condicionales;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm33 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtTardanza, txtObservaciones, txtPuntajePuntualidad, txtPuntajeRendimiento, txtBonificacion;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm33 frame = new frm33();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm33() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblTardanza = new JLabel("Minutos de Tardanza:");
        lblTardanza.setBounds(50, 50, 150, 30);
        getContentPane().add(lblTardanza);

        JLabel lblObservaciones = new JLabel("Observaciones:");
        lblObservaciones.setBounds(50, 90, 150, 30);
        getContentPane().add(lblObservaciones);

        JLabel lblPuntajePuntualidad = new JLabel("Puntaje Puntualidad:");
        lblPuntajePuntualidad.setBounds(50, 130, 150, 30);
        getContentPane().add(lblPuntajePuntualidad);

        JLabel lblPuntajeRendimiento = new JLabel("Puntaje Rendimiento:");
        lblPuntajeRendimiento.setBounds(50, 170, 150, 30);
        getContentPane().add(lblPuntajeRendimiento);

        JLabel lblBonificacion = new JLabel("BonificaciÃ³n Anual:");
        lblBonificacion.setBounds(50, 210, 150, 30);
        getContentPane().add(lblBonificacion);

        txtTardanza = new JTextField();
        txtTardanza.setBounds(210, 50, 60, 30);
        txtTardanza.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtTardanza);

        txtObservaciones = new JTextField();
        txtObservaciones.setBounds(210, 90, 60, 30);
        txtObservaciones.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtObservaciones);

        txtPuntajePuntualidad = new JTextField();
        txtPuntajePuntualidad.setBounds(210, 130, 60, 30);
        txtPuntajePuntualidad.setEditable(false);
        txtPuntajePuntualidad.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtPuntajePuntualidad);

        txtPuntajeRendimiento = new JTextField();
        txtPuntajeRendimiento.setBounds(210, 170, 60, 30);
        txtPuntajeRendimiento.setEditable(false);
        txtPuntajeRendimiento.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtPuntajeRendimiento);

        txtBonificacion = new JTextField();
        txtBonificacion.setBounds(210, 210, 60, 30);
        txtBonificacion.setEditable(false);
        txtBonificacion.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtBonificacion);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(150, 250, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularBonificacion();
            }
        });
    }

    protected void calcularBonificacion() {
        int minutosTardanza = Integer.parseInt(txtTardanza.getText());
        int observaciones = Integer.parseInt(txtObservaciones.getText());
        int puntajePuntualidad = calcularPuntajePuntualidad(minutosTardanza);
        int puntajeRendimiento = calcularPuntajeRendimiento(observaciones);
        int puntajeTotal = puntajePuntualidad + puntajeRendimiento;
        double bonificacion = calcularBonificacionAnual(puntajeTotal);

        txtPuntajePuntualidad.setText(String.valueOf(puntajePuntualidad));
        txtPuntajeRendimiento.setText(String.valueOf(puntajeRendimiento));
        txtBonificacion.setText("S/. " + bonificacion);
    }

    private int calcularPuntajePuntualidad(int minutosTardanza) {
        if (minutosTardanza == 0) return 10;
        else if (minutosTardanza <= 5) return 8;
        else if (minutosTardanza <= 10) return 6;
        else if (minutosTardanza <= 15) return 4;
        else return 2;
    }

    private int calcularPuntajeRendimiento(int observaciones) {
        if (observaciones == 0) return 10;
        else if (observaciones == 1) return 8;
        else if (observaciones == 2) return 6;
        else if (observaciones == 3) return 4;
        else return 2;
    }

    private double calcularBonificacionAnual(int puntajeTotal) {
        if (puntajeTotal >= 18) return 1000.0;
        else if (puntajeTotal >= 15) return 800.0;
        else if (puntajeTotal >= 10) return 500.0;
        else return 0.0;
    }
}

