package com.core;

import java.util.Arrays;

/**
 * Created by agaspari on 6/14/2017.
 */
public class Encrypter {
    private Integer[] primes = new Integer[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251};

    public Encrypter(){}

    public String encryptText(String plaintext){
        String ciphertext = "";
        String[] words = plaintext.split(" ");
        for(int i = 0; i < words.length; i++){
            ciphertext += encryptWord(words[i] + " ");
        }
        return ciphertext;
    }

    private String encryptWord(String plaintext){
        String ciphertext = "";
        String[] letters = plaintext.split("");

        for(int i = 0; i < letters.length; i++){
            if(letters.length == 0 || letters[i].getBytes().length == 0) {
                return "";
            }
            int tempByte = letters[i].getBytes()[0];
            String tempBinary = Integer.toBinaryString(tempByte);
            for(int j = 0; j < tempBinary.length(); j++){
                if(tempBinary.substring(j, j + 1).equals("1")){
                    ciphertext += primes[(int) (Math.random() * primes.length)] + " ";
                }else{
                    int tempNum;
                    do{
                        tempNum = (int)(Math.random() * 100);
                    }while(Arrays.asList(primes).contains(tempNum));
                    ciphertext += tempNum + " ";
                }
            }
            ciphertext += "\n";
        }
        return ciphertext;
    }

    public String decryptText(String ciphertext){
        String plaintext = "";
        String[] letters = ciphertext.split("\n");
        for(int i = 0; i < letters.length; i++){
            plaintext = plaintext + decryptLetter(letters[i]);
        }
        return plaintext;
    }

    private String decryptLetter(String ciphertext){
        String letter;
        String[] bytes = ciphertext.split(" ");

        String binary = "";
        for(int i = 0; i < bytes.length; i++){
            int myByte = Integer.parseInt(bytes[i]);
            if(Arrays.asList(primes).contains(myByte)){
                binary += "1";
            }else if(!Arrays.asList(primes).contains(myByte)){
                System.out.println("Non Prime: " + bytes[i]);
                binary += "0";
            }
        }
        int decimalValue = Integer.parseInt(binary, 2);
        byte[] myByte = new byte[]{(byte)decimalValue};
        letter = new String(myByte);
        return letter;
    }
}
