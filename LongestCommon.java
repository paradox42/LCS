package assign2part5;

public class LongestCommon
{
	/********************************************************************************/
	private char[] u;
	private char[] v;
	private int[][] table;
	
	public LongestCommon(char[] u, char[] v)
	{
		this.u = u;
		this.v = v;
		table = new int[u.length+1][v.length+1];
	}
	/********************************************************************************/
	public void solve()
	{
		constructTable();
		findSubsequence();
		findLength();
	}
	/********************************************************************************/
	private void constructTable()
	{
		for(int i=0;i<=u.length;i++)
		{
			table[i][0]=0;
		}
		for(int j=0;j<=v.length;j++)
		{
			table[0][j] = 0;
		}
		for(int i=1;i<=u.length;i++)
		{
			for(int j=1;j<=v.length;j++)
			{
				if(u[i-1]==v[j-1])
				{
					table[i][j] = table[i-1][j-1]+1;
				}
				else
				{
					if(table[i-1][j]>=table[i][j-1])
					{
						table[i][j] = table[i-1][j];
					}
					else
					{
						table[i][j] = table[i][j-1]; 
					}
				}
			}
		}
	}
	/********************************************************************************/
	private void findSubsequence()
	{
		boolean[] select = new boolean[u.length];
		for(int k=0;k<u.length;k++)
		{
			select[k] = false;
		}
		int i=u.length;
		int j=v.length;
		while(i >= 1 && j>= 1)
		{
			if(u[i-1] == v[j-1])
			{
				select[i-1] = true;
				i=i-1;
				j=j-1;
			}
			else
			{
				if(table[i-1][j]>= table[i][j-1])
				{
					i = i-1;
				}
				else
				{
					j=j-1;
				}
			}
		}
		System.out.println("The LCS is ");
		for(int k=0;k<u.length;k++)
		{
			if(select[k])
			{
				System.out.print(u[k]);
			}
		}
		System.out.println();
	}
	/********************************************************************************/
	private void findLength()
	{
		System.out.println("The LCS length is "+table[u.length][v.length]);
	}
}
