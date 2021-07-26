import java.io.*;
import java.util.*;
public class Boggle {
	static ArrayList<String> Dict = new ArrayList<String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'G','I','Z'},
				{'U','E','K'},
				{'Q','S','E'}};
		boolean[][] visited = {{false,false,false},
				{false,false,false},
				{false,false,false}
				
									};
		String word = null;
//		code to import the dictionary
//		ArrayList<String> Dict = new ArrayList<String>();
		try {
			FileReader file = new FileReader("mydictionary.txt");
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine())
			{
				Dict.add(sc.nextLine());
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		for(int row=0;row<3;row++)
		{
			for(int column=0;column<3;column++)
			{
				visited[row][column] = true;
				FindWord(board,visited,0,0,word+board[row][column], Dict /*dictionary*/);
				visited[row][column]=false;
			}
		}
	}
	static int[] pathRow = {0,0,1,1,-1,1,-1,-1};
	static int[] pathColumn = {1,-1,-1,1,1,0,0,-1};
	
	public static void FindWord(char[][] board, boolean[][] visited, int row, int column, String word, ArrayList<String> dict)
	{
		if(dict.contains(word))
		{
			System.out.println(word);
		}
		if(board.length==word.length())
		{
			return;
		}
		for(int i=0;i<pathRow.length;i++)
		{
			int NewRow = row + pathRow[i];
			int NewColumn = column + pathColumn[i];
			if(ifValid(NewRow, NewColumn, visited))
			{
				visited[NewRow][NewColumn] = true;
				FindWord(board, visited, NewRow, NewColumn, word+board[NewRow][NewColumn], Dict);
				visited[NewRow][NewColumn] = false;
			}
		}
	}
	private static boolean ifValid(int NewRow, int NewColumn, boolean[][] visited)
	{
		if((NewRow>=0) && (NewColumn>=0) && (NewRow<3) && (NewColumn<3) && (!visited[NewRow][NewColumn]))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
© 2021 GitHub, Inc.
Terms
Privacy
Security
Status
Docs
Contact GitHub
Pricing
API
Training
Blog
About
