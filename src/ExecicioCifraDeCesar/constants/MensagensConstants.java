package ExecicioCifraDeCesar.constants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MensagensConstants {
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MENSAGENS_CESAR_CIPHER {
        String CESAR_CIPHER = """
                        ######################################
                        #---------- Cifra de Cesar ----------#
                        ######################################
                """;
        String INVALID_NUMBER = "Numero invalido!";
        String CHOICE = "Escolha a opção que deseja:\n " + "Criptografar o texto = [1]\n " + "Descriptografar o texto = [2]";
        String ENCRYPTED_TEXT = "Texto criptografado: ";
        String DECRYPTED_TEXT = "Texto descriptografado: ";
        String NO_OPTIONS_CHOSEN = "Nenhuma das opções foi escolhida";
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface MENSAGENS_SCANNER {
        String TYPE_THE_TEXT = "Digte o texto, Por favor: ";
        String NATURAL_NUMBER = "Digite un numero inteiro natural, Por favor: ";
    }
}
