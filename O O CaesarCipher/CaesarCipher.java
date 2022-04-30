
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher 
{
    private String alphabets;
    private String shiftedAlphabets;
    private int mainKey;
    public CaesarCipher(int key)
    {
        alphabets="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabets=alphabets.substring(key)+alphabets.substring(0,key);
        this.mainKey=key;
    }
    
    public String encrypt(String input)
    {
        char currChar,newChar;
	//creating new mutable string and pass input string to it by converting to upper case 
	StringBuilder encrypted = new StringBuilder(input.toUpperCase());
	//loop from 0 to length of encrypted string
	for(int i=0;i<encrypted.length();i++)
	{
		currChar = encrypted.charAt(i);	//store i'th character in currChar
		int idx= alphabets.indexOf(currChar);	//get the position of currChar from alphabets
		if(idx!=-1)	//check character present in alphabets or not
		{
			if(Character.isLowerCase(input.charAt(i)))	//check if character is in lower case in the original string
				//get the encrypted character in lower case using idx(position of character in alphabets))
				newChar=shiftedAlphabets.toLowerCase().charAt(idx); 
			else
				//get the encrypted character in upper case using idx(position of character in alphabets))
				newChar=shiftedAlphabets.charAt(idx);
			//change the original character with new encrypted character
			encrypted.setCharAt(i, newChar);
			}
		}
	return encrypted.toString();
    }
    
    public String decrypt(String encrypted)
    {
	CaesarCipher cc = new CaesarCipher(26-mainKey);
	return cc.encrypt(encrypted);
	
    }
    
    
}
