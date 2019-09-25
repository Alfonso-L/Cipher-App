/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cipherapp;

/**
 *
 * @author AL
 */
public class CipherLogic {

    public char alphabetCharacters[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
        'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
        'w', 'x', 'y', 'z'};

    public String doEncryption(String s, int key) {
        char cipherText[] = new char[(s.length())];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                cipherText[i] = ' ';
                //System.out.println(" ");
            } else {
                for (int j = 0; j < alphabetCharacters.length; j++) {
                    if (alphabetCharacters[j] == s.charAt(i)) {
                        cipherText[i] = alphabetCharacters[(j + key) % 26];
                        // System.out.println(c[i]);
                    }
                }
            }
        }
        return (new String(cipherText));
    }

    public String doDecryption(String s, int key) {
        char decyptionText[] = new char[(s.length())];
        int index;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                decyptionText[i] = ' ';
            } else {
                for (int j = 0; j < 26; j++) {
                    if (alphabetCharacters[j] == s.charAt(i)) {
                        index = j - key;
                        if (index < 0) {
                            index += 26;
                        }
                        decyptionText[i] = alphabetCharacters[index];
                    }
                }
            }
        }
        return (new String(decyptionText));
    }

    public char[] getAlphabetCharacters() {
        return alphabetCharacters;
    }

    public void setAlphabetCharacters(char[] alphabetCharacters) {
        this.alphabetCharacters = alphabetCharacters;
    }
}
