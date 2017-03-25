package assign2part5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class part4
{
	public static void main(String[] args) throws FileNotFoundException
	{
		String fileName = "Test/file9";
		String[] sequences = getResult(fileName);
		
		LongestCommon lc = new LongestCommon(sequences[0].toCharArray(),sequences[1].toCharArray());
		System.out.print("In file 9, ");
		lc.solve();
		
		fileName = "Test/file10";
		sequences = getResult(fileName);
		
		lc = new LongestCommon(sequences[0].toCharArray(),sequences[1].toCharArray());
		System.out.print("In file 10, ");
		lc.solve();
	}
	
	public static String[] getResult(String fileName) throws FileNotFoundException
	{
		String[] result = new String[2];
		Scanner s = new Scanner(new File(fileName));
		int index = 0;
		while(s.hasNextLine())
		{
			String line = s.nextLine();
			if(!empty(line))
			{
				result[index] = line;
				index++;
			}
		}
		return result;
	}
	
	public static boolean empty(String s)
	{
		boolean result = true;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i) != ' ')
			{
				result = false;
			}
		}
		return result;
	}
}
