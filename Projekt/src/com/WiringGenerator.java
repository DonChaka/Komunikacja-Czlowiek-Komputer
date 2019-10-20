package com;

import java.lang.String;

public class WiringGenerator
{
    public static void main(String[] args)
    {
        String[] alphabets = {"ekmflgdqvzntowyhxuspaibrcj",
                                "AJDKSIRUXBLHWTMCQGZNPYFVOE",
                                "BDFHJLCPRTXVZNYEIWGAKMUSQO",
                                "E S O V P Z J A Y Q U I R H X L N F T G K D C M W B",
                                "V Z B R G I T Y U P S D N H L X A W M J Q O F E C K",
                                "YRUHQSLDPXNGOKMIEBFZCWVJAT"};

        for (String alphabet : alphabets)
        {
            alphabet = alphabet.replaceAll("\\s+", "");
            StringBuilder output = new StringBuilder();

            output.append("{");
            for(int i = 'A'; i <= (int)'Z'; i++)
                output.append(String.format("%d,", (int) alphabet.charAt(i % (int) 'A') % 65));

            output.deleteCharAt(output.length()-1);
            output.append("};");
            System.out.println(output);
        }

    }

}
