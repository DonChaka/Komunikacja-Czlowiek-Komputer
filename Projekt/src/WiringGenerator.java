import java.lang.String;

public class WiringGenerator
{
    public static void main(String[] args)
    {
        String[] alphabets = {"E K M F L G D Q V Z N T O W Y H X U S P A I B R C J",
                                "A J D K S I R U X B L H W T M C Q G Z N P Y F V O E",
                                "B D F H J L C P R T X V Z N Y E I W G A K M U S Q O",
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
