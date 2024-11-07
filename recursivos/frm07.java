import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm07 {
    private static int[][] tablero;
    private static final int TAMANIO = 10;
    private static final int INTERVALO = 1000; // 1 segundo

    public static void main(String[] args) {
        tablero = new int[TAMANIO][TAMANIO];
        inicializarTablero();
        JFrame frame = new JFrame("Juego de la Vida");
        JButton btnSiguiente = new JButton("Siguiente");
        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                siguienteGeneracion();
                frame.repaint();
            }
        });

        frame.setLayout(new BorderLayout());
        frame.add(btnSiguiente, BorderLayout.SOUTH);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Timer timer = new Timer(INTERVALO, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                siguienteGeneracion();
                frame.repaint();
            }
        });
        timer.start();

        frame.add(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                dibujarTablero(g);
            }
        }, BorderLayout.CENTER);
    }

    public static void inicializarTablero() {
        // Inicializar con algunas células vivas (1) y muertas (0)
        tablero[1][2] = 1;
        tablero[2][3] = 1;
        tablero[3][1] = 1;
        tablero[3][2] = 1;
        tablero[3][3] = 1;
    }

    public static void siguienteGeneracion() {
        int[][] nuevoTablero = new int[TAMANIO][TAMANIO];

        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                int vecinasVivas = contarVecinasVivas(i, j);
                if (tablero[i][j] == 1) {
                    nuevoTablero[i][j] = (vecinasVivas == 2 || vecinasVivas == 3) ? 1 : 0;
                } else {
                    nuevoTablero[i][j] = (vecinasVivas == 3) ? 1 : 0;
                }
            }
        }
        tablero = nuevoTablero;
    }

    public static int contarVecinasVivas(int fila, int col) {
        int cuenta = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; // Ignorar la célula misma
                int nuevaFila = fila + i;
                int nuevaCol = col + j;
                if (nuevaFila >= 0 && nuevaFila < TAMANIO && nuevaCol >= 0 && nuevaCol < TAMANIO) {
                    cuenta += tablero[nuevaFila][nuevaCol];
                }
            }
        }
        return cuenta;
    }

    public static void dibujarTablero(Graphics g) {
        int cellSize = 30;
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                if (tablero[i][j] == 1) {
                    g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                } else {
                    g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);
                }
            }
        }
    }
}

    
