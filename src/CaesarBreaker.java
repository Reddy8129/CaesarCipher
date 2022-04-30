public class CaesarBreaker 
{
	private String alphabets="abcdefghijklmnopqrstuvwxyz";
	private void countLetters(int[] counts, String message)
	{
		for (int i = 0; i < message.length(); i++) 
		{
			int idx = alphabets.indexOf(message.toLowerCase().charAt(i));
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
	
	String decrypt(String encrypted)
	{
		CaesarCipher cc = new CaesarCipher();
		int[] counts = new int[26];
		countLetters(counts, encrypted);
		int maxDex= maxIndex(counts);
		int dKey= maxDex-4;
		if(maxDex<4)
			dKey=26-(4-maxDex);
		return cc.encrypt(encrypted, 26-dKey);
		
	}
	
	String decryptTwoKeys(String encrypted)
	{
		CaesarCipher cc = new CaesarCipher();
		String[] words = encrypted.split(" ");
		String firstHalf="";
		String secondHalf="";
		for (int i = 0; i < words.length; i++) 
		{
			firstHalf+=halfOfString(words[i],0);
			secondHalf+=halfOfString(words[i],1);
		}
		int key1= 26-findKey(firstHalf);
		int key2 = 26-findKey(secondHalf);
		
		return cc.encryptTwoKey(encrypted, key1, key2);
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
	
	private String halfOfString(String message, int start)
	{
		String half="";
			for(int i=start;i<message.length();i+=2)
			{
				half+=message.charAt(i);
			}
			return half;
	}
	
	public static void main(String[] args) 
	{
		CaesarBreaker cb= new CaesarBreaker();
		WordLengths wl = new WordLengths();
//		int[] counts = new int[26];
//		cb.countLetters(counts,"Prashantha_Reddy K N");
//		for (int i = 0; i < counts.length; i++) {
//			System.out.println(cb.alphabets.charAt(i) +" --> "+counts[i]);
//		}
		System.out.println(cb.decrypt("Za ewwl ew lmwkvsq sl hsjc "));
		//System.out.println(cb.halfOfString("Qbkm Zgis", 1));
		//System.out.println(cb.decryptTwoKeys(wl.getFileContent2("Files\\small.txt")));
		//System.out.println(cb.findKey(cb.halfOfString(wl.getFileContent2("Files\\small.txt"), 1)));
		//System.out.println(wl.getFileContent2("Files\\small.txt"));
	}
}
