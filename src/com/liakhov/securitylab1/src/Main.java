package com.liakhov.securitylab1.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {

	public static void main(String[] args) {
		if(args.length != 1) {
			System.err.println("Error input params!");
			return;
		}

		try(BufferedReader br = new BufferedReader(new FileReader(args[0]));
			FileWriter fileWrite = new FileWriter("result.txt")) {

			String sCurrentLine;
			
			Alphabet alphabet = new Alphabet();
			Bigram bigram = new Bigram();
			String alphabetResult, bigramResult;

			while ((sCurrentLine = br.readLine()) != null) {
				alphabet.addString(sCurrentLine);
				bigram.addString(sCurrentLine);
			}
            alphabetResult = alphabet.toString();
            bigramResult = bigram.toString();

            fileWrite.write(alphabetResult);
            fileWrite.write(bigramResult);

			System.out.println(alphabetResult);
			System.out.println(bigramResult);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
