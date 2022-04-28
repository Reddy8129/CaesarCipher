import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountCommonWords 
{
	Scanner getFile(String filename) throws FileNotFoundException
	{
		File file = new File(filename);
		Scanner sc= null;
		String[] common = new String[20];
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
		String[] plays = {"caesar.txt", "errors.txt", "hamlet.txt", "likeit.txt", "macbeth.txt", "romeo.txt"};
		String[] common = getCommon();
		int[] counts = new int[common.length];
		for(int k= 0; k<plays.length;k++)
		{
			Scanner sc = getFile("Files\\"+plays[k]);
			countWords(sc,common,counts);
			System.out.println("done with "+plays[k]);
		}

	}

	void countWords(Scanner sc, String[] common, int[] counts) 
	{
		while(sc.hasNextLine())
		{
			String[] sc.nextLine()
		}
	}




}
