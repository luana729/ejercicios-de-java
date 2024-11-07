import javax.swing.*;
import java.util.HashSet;

public class frm08{
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Ingresa una cadena:");
        HashSet<String> palindromos = new HashSet<>();
        generarPalindromos("", input, palindromos);
        JOptionPane.showMessageDialog(null, "Palíndromos generados:\n" + palindromos);
    }

    public static void generarPalindromos(String prefijo, String resto, HashSet<String> palindromos) {
        if (resto.isEmpty()) {
            if (esPalindromo(prefijo)) {
                palindromos.add(prefijo);
            }
        }

        for (int i = 0; i < resto.length(); i++) {
            generarPalindromos(prefijo + resto.charAt(i), resto.substring(0, i) + resto.substring(i + 1), palindromos);
        }
    }

    public static boolean esPalindromo(String str) {
        int inicio = 0;
        int fin = str.length() - 1;
        while (inicio < fin) {
            if (str.charAt(inicio) != str.charAt(fin)) {
                return false;
            }
            inicio++;
            fin--;
        }
        return true;
    }
}
