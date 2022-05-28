import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;



public class cifrado_cesar {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String texto;
        int codigo;
        char opcion;

        do {
            System.out.print("Introduce un texto");
            //texto= JOptionPane.showInputDialog("Introduce un texto");
            texto = sc.nextLine();
        }while (texto.isEmpty());

        do {
            System.out.print("Introduce el codigo");
            codigo = sc.nextInt();
        }while (codigo < 1);

        // cifrar y descrifar

        do {
            sc.nextLine();
            System.out.print("(C) cifrar o (D) descrifrar: ");
            opcion = (char) System.in.read();
        }while (Character.toUpperCase(opcion) != 'C' && Character.toUpperCase(opcion) != 'D');
        if (Character.toUpperCase(opcion) == 'C') {
            System.out.println("Texto cifrado: " + cifrado_cesar(texto, codigo));
        }else {
            System.out.println("Texto descifrado: "+ descifrado_cesar(texto, codigo));
        }

    }
    public static String cifrado_cesar(String texto, int codigo) {
        StringBuilder cifrado = new StringBuilder();
        codigo = codigo % 26;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                if ((texto.charAt(i) + codigo) > 'z') {
                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + codigo));
                }
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                if ((texto.charAt(i) + codigo) > 'Z') {
                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + codigo));
                }
            }
        }
        return cifrado.toString();
    }
    public static String descifrado_cesar(String texto, int codigo) {
        StringBuilder cifrado = new StringBuilder();
        codigo = codigo % 26;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                if ((texto.charAt(i) - codigo) < 'a') {
                    cifrado.append((char) (texto.charAt(i) - codigo + 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) - codigo));
                }
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                if ((texto.charAt(i) - codigo) < 'A') {
                    cifrado.append((char) (texto.charAt(i) - codigo + 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) - codigo));
                }
            }
        }
        return cifrado.toString();
    }

}
