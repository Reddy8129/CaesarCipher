
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestCaesarCipherTwo 
{
    private String halfOfString(String message, int start)
    {
        String half="";
        for(int i=start;i<message.length();i+=2)
            half+=message.charAt(i);
        return half;
    }
    
    private void countLetters(int[] counts,String message)
    {
        String alphabets="abcdefghijklmnopqrstuvwxyz";
        for(int i=0;i<message.length();i++)
        {
            char ch= Character.toLowerCase(message.charAt(i));
            int idx = alphabets.indexOf(ch);
            if(idx!=-1)
                counts[idx]++;
        }
    }
    
    private int maxIndex(int[] freqs)
    {
    int max=0;
    int maxDex=0;
    for (int i = 0; i < freqs.length; i++) 
    {
        if(freqs[i]>max)
        {
            max=freqs[i];
        maxDex=i;
            }   
    }
    return maxDex;
    }
    
    void simpleTests()
    {
        FileResource resource = new FileResource("data/small.txt");
        String encrypted;
        String decrypted;
        String message="";
        for(String s:resource.words())
            message+=s+" ";
        CaesarCipherTwo cct = new CaesarCipherTwo(2,20);
        //encrypted=cct.encrypt(message);
        //System.out.println(cct.decrypt("Top ncmy qkff vi vguv vbg ycpx"));
        //System.out.println("Encrypted message -->"+encrypted);
        System.out.println("Decrypted message -->"+breakCaesarCipher(message));
        
    }
    
    private String breakCaesarCipher(String input)
    {
        
        String firstHalf=halfOfString(input,0);
        String secondHalf=halfOfString(input,1);
        int key1= findKey(firstHalf);
        int key2= findKey(secondHalf);
        System.out.println("key1 and key2  "+key1+" "+key2);
        CaesarCipherTwo cct = new CaesarCipherTwo(key1,key2);
        return cct.decrypt(input);
    }
    private int findKey(String message)
    {
        int[] counts = new int[26];
        countLetters(counts, message);
        int maxDex= maxIndex(counts);
        int dKey= maxDex-4;
        if(maxDex<4)
            dKey=26-(4-maxDex);
        return dKey;
    }

    
    
}
