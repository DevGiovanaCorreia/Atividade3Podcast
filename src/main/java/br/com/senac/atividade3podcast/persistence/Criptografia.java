
package br.com.senac.atividade3podcast.persistence;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe utilitária responsável por realizar operações de criptografia.
 * 
 * Atualmente fornece método para geração de hash MD5.
 */
public class Criptografia {
    
    /**
     * Gera o hash MD5 de uma String
    * @param texto Texto a ser criptografado
     * @return Hash MD5 em hexadecimal
     */
    public static String gerarMD5(String texto) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(texto.getBytes());

        
            BigInteger bigInt = new BigInteger(1, digest);
            String hash = bigInt.toString(16);

         
            while (hash.length() < 32) {
                hash = "0" + hash;
            }
            return hash;

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao gerar MD5", e);
        }
        
        
    }
}
