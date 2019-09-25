/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cipherapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author AL
 */
public class PlainTextStatistics {

    Scanner scanner;
    char[] chars;
    String scanLine = null;
    int[] totalcounts = new int[26];

    int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0, count7 = 0, count8 = 0, count9 = 0, count10 = 0, count11 = 0, count12 = 0, count13 = 0, count14 = 0, count15 = 0, count16 = 0, count17 = 0,
            count18 = 0, count19 = 0, count20 = 0, count21 = 0, count22 = 0, count23 = 0, count24 = 0, count25 = 0, count26 = 0;

    //cipher analisis fields
    int countC1 = 0, countC2 = 0, countC3 = 0, countC4 = 0, countC5 = 0, countC6 = 0, countC7 = 0, countC8 = 0, countC9 = 0, countC10 = 0, countC11 = 0, countC12 = 0, countC13 = 0, countC14 = 0, countC15 = 0, countC16 = 0, countC17 = 0,
            countC18 = 0, countC19 = 0, countC20 = 0, countC21 = 0, countC22 = 0, countC23 = 0, countC24 = 0, countC25 = 0, countC26 = 0;

    public int[] GetAlphabetStats() throws FileNotFoundException {
        scanner = new Scanner(new File("Vocabulary.txt"));

        while (scanner.hasNextLine()) {
            scanLine = scanner.nextLine();

            chars = scanLine.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                if ((chars[i] != 'a') && (chars[i] != 'b') && (chars[i] != 'c') && (chars[i] != 'd') && (chars[i] != 'e') && (chars[i] != 'f')
                        && (chars[i] != 'g') && (chars[i] != 'h') && (chars[i] != 'i') && (chars[i] != 'j') && (chars[i] != 'k') && (chars[i] != 'l')
                        && (chars[i] != 'm') && (chars[i] != 'n') && (chars[i] != 'o') && (chars[i] != 'p') && (chars[i] != 'q') && (chars[i] != 'r')
                        && (chars[i] != 's') && (chars[i] != 't') && (chars[i] != 'u') && (chars[i] != 'v') && (chars[i] != 'w') && (chars[i] != 'x')
                        && (chars[i] != 'y') && (chars[i] != 'z')) {
                    //System.out.println("Not A or  or C " + chars[i]);
                    chars[i] = ' ';
                } else {
                    System.out.println("Is A or B or C " + chars[i]);
                }
            }
            String mm = String.copyValueOf(chars);
            //System.out.println(scanLine);
            //System.out.println(mm);

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 'a') { //1
                    //System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
                    count1 += 1;
                    totalcounts[0] = count1;
                    System.out.println(count1);
                } else if (chars[i] == 'b') { //2
                    count2 += 1;
                    totalcounts[1] = count2;
                    System.out.println(count2);
                } else if (chars[i] == 'c') { //3
                    count3 += 1;
                    totalcounts[2] = count3;
                    System.out.println(count3);
                } else if (chars[i] == 'd') {//4
                    count4 += 1;
                    totalcounts[3] = count4;
                    System.out.println(count4);
                } else if (chars[i] == 'e') {//5
                    count5 += 1;
                    totalcounts[4] = count5;
                    System.out.println(count5);
                } else if (chars[i] == 'f') {//6
                    count6 += 1;
                    totalcounts[5] = count6;
                    System.out.println(count6);
                } else if (chars[i] == 'g') {//7
                    count7 += 1;
                    totalcounts[6] = count7;
                    System.out.println(count7);
                } else if (chars[i] == 'h') {//8
                    count8 += 1;
                    totalcounts[7] = count8;
                    System.out.println(count8);
                } else if (chars[i] == 'i') {//9
                    count9 += 1;
                    totalcounts[8] = count9;
                    System.out.println(count9);
                } else if (chars[i] == 'j') {//10
                    count10 += 1;
                    totalcounts[9] = count10;
                    System.out.println(count10);
                } else if (chars[i] == 'k') {
                    count11 += 1;
                    totalcounts[10] = count11;
                    System.out.println(count11);
                } else if (chars[i] == 'l') {
                    count12 += 1;
                    totalcounts[11] = count12;
                    System.out.println(count12);
                } else if (chars[i] == 'm') {
                    count13 += 1;
                    totalcounts[12] = count13;
                    System.out.println(count13);
                } else if (chars[i] == 'n') {
                    count14 += 1;
                    totalcounts[13] = count14;
                    System.out.println(count14);
                } else if (chars[i] == 'o') {
                    count15 += 1;
                    totalcounts[14] = count15;
                    System.out.println(count15);
                } else if (chars[i] == 'p') {
                    count16 += 1;
                    totalcounts[15] = count16;
                    System.out.println(count16);
                } else if (chars[i] == 'q') {
                    count17 += 1;
                    totalcounts[16] = count17;
                    System.out.println(count17);
                } else if (chars[i] == 'r') {
                    count18 += 1;
                    totalcounts[17] = count18;
                    System.out.println(count18);
                } else if (chars[i] == 's') {
                    count19 += 1;
                    totalcounts[18] = count19;
                    System.out.println(count19);
                } else if (chars[i] == 't') {
                    count20 += 1;
                    totalcounts[19] = count20;
                    System.out.println(count20);
                } else if (chars[i] == 'u') {
                    count21 += 1;
                    totalcounts[20] = count21;
                    System.out.println(count21);
                } else if (chars[i] == 'v') {
                    count22 += 1;
                    totalcounts[21] = count22;
                    System.out.println(count22);
                } else if (chars[i] == 'w') {
                    count23 += 1;
                    totalcounts[22] = count23;
                    System.out.println(count23);
                } else if (chars[i] == 'x') {
                    count24 += 1;
                    totalcounts[23] = count24;
                    System.out.println(count24);
                } else if (chars[i] == 'y') {
                    count25 += 1;
                    totalcounts[24] = count25;
                    System.out.println(count25);
                } else if (chars[i] == 'z') {
                    count26 += 1;
                    totalcounts[25] = count26;
                    System.out.println(count26);
                }

            }
            ////////////////////////////////////////////end of ifs nad for loop

        }

        for (int j = 0; j < totalcounts.length; j++) {
            System.out.println("Last one");
            System.out.println("totalcounts: " + totalcounts[j]);

        }
        scanner.close();

        return totalcounts;
    }

    public int[] GetCipherStats(String cipherMasterString) {
        int[] cipherStatsCount = new int[26]; //vocab in alphabet
        char[] cipherTextChars = cipherMasterString.toCharArray();

        for (int i = 0; i < cipherTextChars.length; i++) {
            if (cipherTextChars[i] == 'a') { //1
                //System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
                countC1 += 1;
                cipherStatsCount[0] = countC1;
                System.out.println(countC1);
            } else if (cipherTextChars[i] == 'b') { //2
                countC2 += 1;
                cipherStatsCount[1] = countC2;
                System.out.println(countC2);
            } else if (cipherTextChars[i] == 'c') { //3
                countC3 += 1;
                cipherStatsCount[2] = countC3;
                System.out.println(countC3);
            } else if (cipherTextChars[i] == 'd') {//4
                countC4 += 1;
                cipherStatsCount[3] = countC4;
                System.out.println(countC4);
            } else if (cipherTextChars[i] == 'e') {//5
                countC5 += 1;
                cipherStatsCount[4] = countC5;
                System.out.println(countC5);
            } else if (cipherTextChars[i] == 'f') {//6
                countC6 += 1;
                cipherStatsCount[5] = countC6;
                System.out.println(countC6);
            } else if (cipherTextChars[i] == 'g') {//7
                countC7 += 1;
                cipherStatsCount[6] = countC7;
                System.out.println(countC7);
            } else if (cipherTextChars[i] == 'h') {//8
                countC8 += 1;
                cipherStatsCount[7] = countC8;
                System.out.println(countC8);
            } else if (cipherTextChars[i] == 'i') {//9
                countC9 += 1;
                cipherStatsCount[8] = countC9;
                System.out.println(countC9);
            } else if (cipherTextChars[i] == 'j') {//10
                countC10 += 1;
                cipherStatsCount[9] = countC10;
                System.out.println(countC10);
            } else if (cipherTextChars[i] == 'k') {
                countC11 += 1;
                cipherStatsCount[10] = countC11;
                System.out.println(countC11);
            } else if (cipherTextChars[i] == 'l') {
                countC12 += 1;
                cipherStatsCount[11] = countC12;
                System.out.println(countC12);
            } else if (cipherTextChars[i] == 'm') {
                countC13 += 1;
                cipherStatsCount[12] = countC13;
                System.out.println(countC13);
            } else if (cipherTextChars[i] == 'n') {
                countC14 += 1;
                cipherStatsCount[13] = countC14;
                System.out.println(countC14);
            } else if (cipherTextChars[i] == 'o') {
                countC15 += 1;
                cipherStatsCount[14] = countC15;
                System.out.println(countC15);
            } else if (cipherTextChars[i] == 'p') {
                countC16 += 1;
                cipherStatsCount[15] = countC16;
                System.out.println(countC16);
            } else if (cipherTextChars[i] == 'q') {
                countC17 += 1;
                cipherStatsCount[16] = countC17;
                System.out.println(countC17);
            } else if (cipherTextChars[i] == 'r') {
                countC18 += 1;
                cipherStatsCount[17] = countC18;
                System.out.println(countC18);
            } else if (cipherTextChars[i] == 's') {
                countC19 += 1;
                cipherStatsCount[18] = countC19;
                System.out.println(countC19);
            } else if (cipherTextChars[i] == 't') {
                countC20 += 1;
                cipherStatsCount[19] = countC20;
                System.out.println(countC20);
            } else if (cipherTextChars[i] == 'u') {
                countC21 += 1;
                cipherStatsCount[20] = countC21;
                System.out.println(countC21);
            } else if (cipherTextChars[i] == 'v') {
                countC22 += 1;
                cipherStatsCount[21] = countC22;
                System.out.println(countC22);
            } else if (cipherTextChars[i] == 'w') {
                countC23 += 1;
                cipherStatsCount[22] = countC23;
                System.out.println(countC23);
            } else if (cipherTextChars[i] == 'x') {
                countC24 += 1;
                cipherStatsCount[23] = countC24;
                System.out.println(countC24);
            } else if (cipherTextChars[i] == 'y') {
                countC25 += 1;
                cipherStatsCount[24] = countC25;
                System.out.println(countC25);
            } else if (cipherTextChars[i] == 'z') {
                countC26 += 1;
                cipherStatsCount[25] = countC26;
                System.out.println(countC26);
            }

        }

        return cipherStatsCount;
    }
}
