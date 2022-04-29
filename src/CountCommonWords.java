import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountCommonWords 
{
	Scanner getFile(String filename) throws FileNotFoundException
	{
		File file = new File(filename);
		Scanner sc= null;
		sc= new Scanner(file);
		return sc;

	}

	String[] getCommon() throws FileNotFoundException
	{
		String[] common = new String[20];
		Scanner sc= getFile("Files\\common.txt");
		int index=0;
		while(sc.hasNextLine())
		{
			common[index]=sc.nextLine();
			index++;
		}
		return common;
	}

	void countShakespeare() throws FileNotFoundException
	{
		//String[] plays = {"small.txt"};
		String[] plays = {"caesar.txt", "errors.txt", "hamlet.txt", "likeit.txt", "macbeth.txt", "romeo.txt"};
		String[] common = getCommon();
		int[] counts = new int[common.length];
		for(int k= 0; k<plays.length;k++)
		{
			Scanner sc = getFile("Files\\"+plays[k]);
			countWords(sc,common,counts);
			System.out.println("done with "+plays[k]);
		}
		for (int i = 0; i < counts.length; i++) {
			System.out.println(common[i]+ " ---> "+counts[i]);
		}

	}

	void countWords(Scanner sc, String[] common, int[] counts) 
	{
		String[] words = getWords(sc).split(" ");
		String word;
		for (int i = 0; i < words.length; i++) 
		{
			word= words[i].toLowerCase();
			int index =indexOf(common, word);
			if(index!=-1)
				counts[index]++;
		}
	}
	
	int indexOf(String[] common, String word) 
	{
		for (int i = 0; i < common.length; i++) 
		{
			if(common[i].equals(word))
				return i;	
		}
		return -1;
		
	}

	String getWords(Scanner sc)
	{
		String words=" ";
		while(sc.hasNextLine())
		{
			words += sc.nextLine();
		}
		//System.out.println("from getWords "+words);
		return words;
	}


public static void main(String[] args) throws FileNotFoundException 
{
	CountCommonWords ccw = new CountCommonWords();
	//Scanner sc=ccw.getFile("Files\\small.txt");
	//String s= ccw.getWords(sc);
	ccw.countShakespeare();
}

}
