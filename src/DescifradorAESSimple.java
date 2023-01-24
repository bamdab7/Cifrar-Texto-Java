import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class DescifradorAESSimple {
    //GENERA LA CLAVE, LEE EL CONTENIDO DEL FICHERO Y LO DESCIFRA
    public static void main(String[] args) {
        final int LONGITUD_BLOQUE = 16; //EXPRESADO EN BYTES
        final String NOMBRE_FICHERO = "mensaje_cifrado.txt";
        final String PASSWORD = "MeLlamoSpiderman";
        try {
            File file = new File(NOMBRE_FICHERO);
            Key clave = AESSimpleManager.obtenerClave(PASSWORD,LONGITUD_BLOQUE);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String textoCifrado = br.readLine();
            String textoEnClaro = AESSimpleManager.descifrar(textoCifrado,clave);
            br.close();
            System.out.println("El texto cifrado es: " + textoEnClaro);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }
}
