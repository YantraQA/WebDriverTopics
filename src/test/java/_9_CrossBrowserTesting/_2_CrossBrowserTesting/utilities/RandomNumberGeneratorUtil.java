package _9_CrossBrowserTesting._2_CrossBrowserTesting.utilities;

import java.util.Random;

import net.bytebuddy.utility.RandomString;

public class RandomNumberGeneratorUtil {
	
	public int randomNumberGengerator_000_00()
	{
		Random rand = new Random();
		int random_integer = rand.nextInt(99999);
		return random_integer;
	}
	
	public int randomNumberGengerator_00()
	{
		Random rand = new Random();
		int random_integer = rand.nextInt(9);
		return random_integer;
	}
	
	public String randomStringGenerator()
	{
		Random rand = new Random();
		String randomName = "";
		
		for (int i = 0; i < 10; i++) 
		{
			char characterRandom = (char)(rand.nextInt(26)+97);
			if (rand.nextBoolean()) {
				characterRandom = Character.toUpperCase(characterRandom);
				randomName = randomName + characterRandom;
			}	
		}	
		return randomName;
	}

}
