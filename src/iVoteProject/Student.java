package iVoteProject;

import java.util.*;


public class Student {
	private static int count = 0;
	
	private String userID;
	private List<String> choice;
	
	public Student()
	{
		count +=1;
		this.userID = "" + count;
	}

	public String getId()
	{
		return userID;
	}
	
	public boolean entered(List<String> answer)
	{
		this.choice = answer;
		return true;
	}
	
	public List<String>getEntered()
	{
		return choice;
	}
}
