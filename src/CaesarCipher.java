import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CaesarCipher {
	
	static String encrypt(String input, int key)
	{
		char currChar,newChar;
		//creating new mutable string and pass input string to it by converting to upper case 
		StringBuilder encrypted = new StringBuilder(input.toUpperCase());
		String alphabet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		//alphabets after shifting number of key characters to the beginning of alphabets
		String shiftedAlphabet= alphabet.substring(key)+alphabet.substring(0,key);
		//loop from 0 to length of encrypted string
		for(int i=0;i<encrypted.length();i++)
		{
			currChar = encrypted.charAt(i);	//store i'th character in currChar
			int idx= alphabet.indexOf(currChar);	//get the position of currChar from alphabets
			if(idx!=-1)	//check character present in alphabets or not
			{
				if(Character.isLowerCase(input.charAt(i)))	//check if character is in lower case in the original string
					//get the encrypted character in lower case using idx(position of character in alphabets))
					newChar=shiftedAlphabet.toLowerCase().charAt(idx); 
				else
					//get the encrypted character in upper case using idx(position of character in alphabets))
					newChar=shiftedAlphabet.charAt(idx);
				//change the original character with new encrypted character
				encrypted.setCharAt(i, newChar);
			}
		}
		return encrypted.toString();
	}
	static String encryptTwoKey(String input, int key1,int key2)
	{
		char currChar,newChar;
		StringBuilder encrypted = new StringBuilder(input.toUpperCase());
		String alphabet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String shiftedAlphabetKey1= alphabet.substring(key1)+alphabet.substring(0,key2);
		
		String shiftedAlphabetKey2= alphabet.substring(key2)+alphabet.substring(0,key2);
		
		for(int i=0;i<encrypted.length();i++)
		{
			if(i%2==0)
			{
				currChar = encrypted.charAt(i);
				int idx= alphabet.indexOf(currChar);
				if(idx!=-1)
				{
					if(Character.isLowerCase(input.charAt(i)))
						newChar=shiftedAlphabetKey1.toLowerCase().charAt(idx);
					else
						newChar=shiftedAlphabetKey1.charAt(idx);
					encrypted.setCharAt(i, newChar);
				}
			}
			else
			{
				currChar = encrypted.charAt(i);
				int idx= alphabet.indexOf(currChar);
				if(idx!=-1)
				{
					if(Character.isLowerCase(input.charAt(i)))
						newChar=shiftedAlphabetKey2.toLowerCase().charAt(idx);
					else
						newChar=shiftedAlphabetKey2.charAt(idx);
					encrypted.setCharAt(i, newChar);
				}
			}
		}
		return encrypted.toString();
	}
	
	
	
	public static void main(String[] args) 
	{
		String text = new String();
		File file = new File("C:\\Users\\reddy\\Desktop\\test.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(sc.hasNextLine())
		{
			text+=sc.nextLine();
		}
		//System.out.println(text);
		//System.out.println(encrypt(text, 10));
		System.out.println(encrypt("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",15));		
		//System.out.println(encrypt("First Legion",17));
		//System.out.println(encryptTwoKey("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",8,21));
	}

}
