
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipherTwo 
{
    private String alphabets,shiftedAlphabets1,shiftedAlphabets2;
    private int key1,key2;
    public CaesarCipherTwo(int key1,int key2)
    {
        this.key1=key1;
        this.key2=key2;
        alphabets="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabets1=alphabets.substring(key1)+alphabets.substring(0,key1);
        shiftedAlphabets2=alphabets.substring(key2)+alphabets.substring(0,key2);
        
    }
    
    public String encrypt(String input)
    {
        char currChar,newChar;
        StringBuilder encrypted = new StringBuilder(input.toUpperCase());
        
        for(int i=0;i<encrypted.length();i++)
        {
            currChar = encrypted.charAt(i);
            if(i%2==0)
            {
                int idx=alphabets.indexOf(currChar);
                if(idx!=-1)
                {
                    if(Character.isLowerCase(input.charAt(i)))
                        newChar=shiftedAlphabets1.toLowerCase().charAt(idx);
                    else
                        newChar=shiftedAlphabets1.charAt(idx);
                    encrypted.setCharAt(i,newChar);
                }
            }
            else
            {
                int idx=alphabets.indexOf(currChar);
                if(idx!=-1)
                {
                    if(Character.isLowerCase(input.charAt(i)))
                        newChar=shiftedAlphabets2.toLowerCase().charAt(idx);
                    else
                        newChar=shiftedAlphabets2.charAt(idx);
                    encrypted.setCharAt(i,newChar);
                }
            }
            
        }
        return encrypted.toString();
    }
    public String decrypt(String input)
    {
        CaesarCipherTwo cct = new CaesarCipherTwo(26-key1,26-key2);
        return cct.encrypt(input);
    }
}
