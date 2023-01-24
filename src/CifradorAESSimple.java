import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class CifradorAESSimple {
    //CONTIENE UN METODO MAIN QUE GENERA LA CLAVE, CIFRA UN TEXTO Y LO ALMACENA EN UN FICHERO
    public static void main(String[] args) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        final int LONGITUD_BLOQUE = 16; //EXPRESADO EN BYTES
        final String NOMBRE_FICHERO = "mensaje_cifrado.txt";
        final String PASSWORD = "MeLlamoSpiderman";
        final String TEXTO_EN_CLARO = "La clave secreta de la caja futura es 38465254";
        try{
            Key clave = AESSimpleManager.obtenerClave(PASSWORD,LONGITUD_BLOQUE);
            String textoEnClaro = TEXTO_EN_CLARO;
            String textoCifrado = AESSimpleManager.cifrar(textoEnClaro,clave);
            PrintWriter pw = new PrintWriter(NOMBRE_FICHERO);
            pw.write(textoCifrado);
            pw.close();
            System.out.println("EL mensaje se ha cifrado correctamente");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
