import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordLengths 
{
	String[] getFileContent(String address)
	{
		Scanner sc=null;
		String content=" ";
		String[] words;
		File file = new File(address);
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(sc.hasNextLine())
		{
			content+=sc.nextLine();
		}
		words=content.split(" ");
		return words;
	}
	
	void countWordsLength(String fileAddress, int[] counts)
	{
		String[] words = getFileContent(fileAddress);
		//String[] words = {"hell,"};
		
		for(String word: words)
		{
			int lenOfWord = word.length();
			if(lenOfWord>=1)
			{
				if(!Character.isLetter(word.charAt(0)))
					lenOfWord-=1;
				if(!Character.isLetter(word.charAt(word.length()-1)))
					lenOfWord-=1;
				if(lenOfWord<=30 & lenOfWord>=1)
					counts[lenOfWord]++;
				else if(lenOfWord>30)
					counts[31]++;
			}
			
		}
	}
	
	int indexOfMax(int[] values)
	{
		int max=0;
		int pos=0;
		for (int i = 0; i < values.length; i++) 
		{
			if(values[i]>max){
				max=values[i];
				pos=i;
			}
			
		}
		return pos;
	}
	
	void testCountWordsLength()
	{
		int[] counts = new int[32];
		String fileAdderss="Files\\romeo.txt";
		countWordsLength(fileAdderss, counts);
		for (int i = 1; i <counts.length-1 ; i++) 
		{
			System.out.println(counts[i] +" words of length "+i);
		}
		System.out.println(counts[counts.length-1]+" words of length more than 30");
		System.out.println(indexOfMax(counts));
		
	}
	public static void main(String[] args) 
	{
		WordLengths wl = new WordLengths();
		wl.testCountWordsLength();
	}
	
	String getFileContent2(String address)
	{
		Scanner sc=null;
		String content=" ";
		String[] words;
		File file = new File(address);
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(sc.hasNextLine())
		{
			content+=sc.nextLine();
		}
		words=content.split(" ");
		return content;
	}
	String str;
}
