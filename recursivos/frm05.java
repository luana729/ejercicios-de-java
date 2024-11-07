import javax.swing.*;

public class frm05 {
    private static final int[][] laberinto = {
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 1, 0}
    };

    private static StringBuilder rutas = new StringBuilder();

    public static void main(String[] args) {
        StringBuilder resultado = new StringBuilder();
        buscarRuta(0, 0, "", resultado);
        JOptionPane.showMessageDialog(null, "Rutas encontradas:\n" + resultado.toString());
    }

    public static void buscarRuta(int x, int y, String ruta, StringBuilder resultado) {
        // Verifica si está fuera de los límites o si es una celda no transitables
        if (x < 0 || x >= laberinto.length || y < 0 || y >= laberinto[0].length || laberinto[x][y] == 1) {
            return;
        }

        // Si llegamos a la esquina inferior derecha
        if (x == laberinto.length - 1 && y == laberinto[0].length - 1) {
            resultado.append(ruta).append(" -> (").append(x).append(", ").append(y).append(")\n");
            return;
        }

        // Marca la celda como visitada
        laberinto[x][y] = 1;

        // Explora las cuatro direcciones
        buscarRuta(x + 1, y, ruta + " -> (" + x + ", " + y + ")", resultado); // Abajo
        buscarRuta(x, y + 1, ruta + " -> (" + x + ", " + y + ")", resultado); // Derecha
        buscarRuta(x - 1, y, ruta + " -> (" + x + ", " + y + ")", resultado); // Arriba
        buscarRuta(x, y - 1, ruta + " -> (" + x + ", " + y + ")", resultado); // Izquierda

        // Desmarca la celda
        laberinto[x][y] = 0;
    }
}

