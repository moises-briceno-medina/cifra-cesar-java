package ExecicioCifraDeCesar;

import ExecicioCifraDeCesar.constants.MensagensConstants;
import ExecicioCifraDeCesar.utils.ScanUtils;

import java.util.Arrays;
import java.util.List;

public class CesarCipher {
    public static void main(String[] args) {
            cesarCipherSolution();
    }

    private static void cesarCipherSolution() {
        ScanUtils scan = new ScanUtils();

//        lista de letras
        final List<String> alphabetList = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");

        System.out.println(MensagensConstants.MENSAGENS_CESAR_CIPHER.CESAR_CIPHER);

        //Recebe uma mensagem
        String message = scan.coletaTexto(MensagensConstants.MENSAGENS_SCANNER.TYPE_THE_TEXT);

        //Recebe um numero inteiro Natural
        int key = scan.coletaInt(MensagensConstants.MENSAGENS_SCANNER.NATURAL_NUMBER);
        do {
            if (key < 0) {
                System.out.println(MensagensConstants.MENSAGENS_CESAR_CIPHER.INVALID_NUMBER);
                key = scan.coletaInt(MensagensConstants.MENSAGENS_SCANNER.NATURAL_NUMBER);
            }
        } while (key < 0);

        //Faz a escolha
        int choice = scan.coletaInt(MensagensConstants.MENSAGENS_CESAR_CIPHER.CHOICE);
        switch (choice) {
            case 1:
                String finalTextEncry = encryptText(alphabetList, message, key);
                System.out.println(MensagensConstants.MENSAGENS_CESAR_CIPHER.ENCRYPTED_TEXT + finalTextEncry);
                break;
            case 2:
                String finalTextDecry = decryptText(alphabetList, message, key);
                System.out.println(MensagensConstants.MENSAGENS_CESAR_CIPHER.DECRYPTED_TEXT + finalTextDecry);
                break;
            default:
                System.out.println(MensagensConstants.MENSAGENS_CESAR_CIPHER.NO_OPTIONS_CHOSEN);
                break;
        }
    }

    private static String encryptText(List<String> alphabet, String message, int key) {
        String encryptedText = "";

        message = message.toUpperCase();// para converter tudo maiuscula

        for (int i = 0; i < message.length(); i++) {
            char caracter = message.charAt(i); //charAt() Essa função permite obter o caractere em uma posição específica dentro de uma string

            int position = alphabet.indexOf(Character.toString(caracter));//através da chamada do método estático toString() da classe Character, que converte um caractere para uma string, //indexOf retorna a pocisação onde esta o caracter

            encryptedText += (position == -1) ? caracter : alphabet.get((position + key) % alphabet.size());
        }
        return encryptedText;
    }

    private static String decryptText(List<String> alphabet, String message, int key) {

        String decryptedText = "";

        message = message.toUpperCase();

        char caracter;
        for (int i = 0; i < message.length(); i++) {
            caracter = message.charAt(i);

            int position = alphabet.indexOf(Character.toString(caracter));

            if (position == -1) {
                decryptedText += caracter;
            } else {
                int index = position - (key % alphabet.size());
                decryptedText += alphabet.get(index < 0 ? alphabet.size() + index : index);
            }
        }
        return decryptedText;
    }
}