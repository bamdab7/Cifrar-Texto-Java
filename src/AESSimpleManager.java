import com.sun.source.tree.ReturnTree;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AESSimpleManager {
    //ESTA CLASE IMPLEMENTA LA GENERACION DE CLAVE A PARTIR DE LA CONTRASEÑA DE USUARIO

    //GENERA LA CLAVE DEL CIFRADO Y DESCIFRADO A PARTIR DE LA CONTRASEÑA DE USUARIO
    public static Key obtenerClave(String password, int longitud){
        //LA LONGITUD PUEDE SER DE 16,24 O 32 BYTES
        Key clave  = new SecretKeySpec(password.getBytes(),0, longitud, "AES");
        return clave;
    }

    //CIFRA UN STRING
    public static String cifrar(String textoEnClaro, Key key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE,key);
        byte[] cipherText = cipher.doFinal(textoEnClaro.getBytes());
        return Base64.getEncoder().encodeToString(cipherText);
    }

    //DESCIFRA UN STRING
    public static String descifrar(String textoCifrado,Key key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher= Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE,key);
        byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(textoCifrado));
        return new String(plainText);
    }
}
