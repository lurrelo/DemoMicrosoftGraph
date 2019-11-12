package Utilidades;

import org.apache.commons.codec.binary.Base64;

public class AzureTokenBase64 {
    public static String Codificar(String tokenSinCodificar)
    {
        String encode = ":"+tokenSinCodificar;
        byte[] encodedBytes = Base64.encodeBase64(encode.getBytes());
        return "Basic "+ new String(encodedBytes);
    }
}
