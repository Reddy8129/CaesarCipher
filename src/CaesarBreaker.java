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
		if(dKey<4)
			dKey=26-(4-maxDex);
		return cc.encrypt(encrypted, 26-dKey);
		
	}
	
	public static void main(String[] args) 
	{
		CaesarBreaker cb= new CaesarBreaker();
//		int[] counts = new int[26];
//		cb.countLetters(counts,"Prashantha_Reddy K N");
//		for (int i = 0; i < counts.length; i++) {
//			System.out.println(cb.alphabets.charAt(i) +" --> "+counts[i]);
//		}
		System.out.println(cb.decrypt("tttttttttttttttttttttttttttttttt Pi cddc qt xc iwt rdcutgtcrt gddb lxiw ndjg wpi dc udg p hjgegxht epgin. NTAA ADJS!"));
	}
}
