class WordPlay 
{
	static boolean isVowel(char ch)
	{	
		String lch= Character.toString(ch).toLowerCase();
		if("aeiou".contains(lch))
			return true;
		else 
			return false;
	}
	
	static String replaceVowels(String phrase, char ch)
	{
		StringBuilder str = new StringBuilder(phrase);
		for(char let:phrase.toCharArray())
		{
			if(isVowel(let))
			{
				int idx = str.toString().indexOf(let);
				str.setCharAt(idx, ch);
			}
		}
		return str.toString();
	}
	
	static String emphasize(String phrase,char ch)
	{
		StringBuilder str = new StringBuilder(phrase);
		for(char let:phrase.toCharArray())
		{
			if(Character.toLowerCase(let)==ch)
			{
				int idx = str.toString().toLowerCase().indexOf(ch);
				if(idx%2==0)
					str.setCharAt(idx, '*' );
				else
					str.setCharAt(idx, '+');
					
			}
		}
		return str.toString();
	}
	public static void main(String[] args) 
	{
//		System.out.println(replaceVowels("ApEpIpOpU",'*'));
//		System.out.println(isVowel('o'));
		System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
	}
}
