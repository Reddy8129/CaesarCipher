import java.util.Random;

public class Dice 
{
	void simulate(int rolls)
	{
		Random random = new Random();
		int[] count = new int[13];
		for (int i = 0; i < rolls; i++) 
		{
			int d1= random.nextInt(6)+1;
			int d2 = random.nextInt(6)+1;
			int idx = d1+d2;
			System.out.println(d1+d2);
			count[idx]++;			
		}
		for(int i=2;i<13;i++)
		{
			System.out.println(i+"'s = "+ count[i] );
		}
	}
	
	public static void main(String[] args) 
	{
		Dice d = new Dice();
		
		d.simulate(10);
	}
}
