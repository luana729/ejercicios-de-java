import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class frm02 {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Ingresa los números separados por comas:");
        String[] partes = input.split(",");
        List<Integer> numeros = new ArrayList<>();
        for (String parte : partes) {
            numeros.add(Integer.parseInt(parte.trim()));
        }

        StringBuilder resultado = new StringBuilder();
        generarCombinaciones(numeros, 0, new ArrayList<>(), resultado);
        JOptionPane.showMessageDialog(null, "Las combinaciones son:\n" + resultado.toString());
    }

    public static void generarCombinaciones(List<Integer> numeros, int inicio, List<Integer> combinacion, StringBuilder resultado) {
        if (inicio <= numeros.size()) {
            resultado.append(combinacion).append("\n");
        }

        for (int i = inicio; i < numeros.size(); i++) {
            combinacion.add(numeros.get(i));
            generarCombinaciones(numeros, i + 1, combinacion, resultado);
            combinacion.remove(combinacion.size() - 1);
        }
    }
}
