
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestCaesarCipher 
{
    void simpleTests()
    {
        FileResource resource = new FileResource("data/small.txt");
        String encrypted;
        String decrypted;
        String message="";
        for(String s:resource.words())
            message+=s+" ";
        CaesarCipher cc = new CaesarCipher(18);
        encrypted=cc.encrypt(message);
        System.out.println("Encrypted message -->"+encrypted);
        System.out.println("Decrypted message -->"+breakCaesarCipher(encrypted));
    }
    private String breakCaesarCipher(String input)
    {
        int[] counts = new int[26];
	countLetters(counts, input);
	int maxDex= maxIndex(counts);
	int dKey= maxDex-4;
	if(maxDex<4)
		dKey=26-(4-maxDex);
	CaesarCipher cc = new CaesarCipher(dKey);
	return cc.decrypt(input);
    }
    private void countLetters(int[] counts, String message)
    {
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	for (int i = 0; i < message.length(); i++) 
	{
		int idx = alphabets.indexOf(message.toUpperCase().charAt(i));
		if(idx!=-1)
			counts[idx]++;
	}
    }
    private int maxIndex(int[] freqs)
    {
	int max=0;
	int maxDex=0;
	for (int i = 0; i < freqs.length; i++) {
		if(freqs[i]>max){
			max=freqs[i];
			maxDex=i;
		}
	}
	return maxDex;
    }
}
