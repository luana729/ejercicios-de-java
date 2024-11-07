import javax.swing.*;

public class frm09 {
    private static int[][] tablero;
    private static StringBuilder soluciones = new StringBuilder();

    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Ingresa el número de reinas:");
        int n = Integer.parseInt(input);
        tablero = new int[n][n];
        resolverNReinas(n, 0);
        JOptionPane.showMessageDialog(null, "Soluciones encontradas:\n" + soluciones.toString());
    }

    public static void resolverNReinas(int n, int fila) {
        if (fila == n) {
            agregarSolucion(n);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (puedeColocarReina(fila, col, n)) {
                tablero[fila][col] = 1;
                resolverNReinas(n, fila + 1);
                tablero[fila][col] = 0; // Deshacer la acción
            }
        }
    }

    public static boolean puedeColocarReina(int fila, int col, int n) {
        for (int i = 0; i < fila; i++) {
            if (tablero[i][col] == 1) return false; // Misma columna
            if (col - (fila - i) >= 0 && tablero[i][col - (fila - i)] == 1) return false; // Diagonal izquierda
            if (col + (fila - i) < n && tablero[i][col + (fila - i)] == 1) return false; // Diagonal derecha
        }
        return true;
    }

    public static void agregarSolucion(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                soluciones.append(tablero[i][j] == 1 ? "R " : ". ");
            }
            soluciones.append("\n");
        }
        soluciones.append("\n");
    }
}

