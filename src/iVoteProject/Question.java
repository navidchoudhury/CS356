package iVoteProject;
import java.util.*;

public abstract class Question {
	
	public List<String> answers;
	public List<String> rightAnswers;
	public String q;
	
	public Question(String q,List<String> answers,List<String> rightAnswers)
	{
		this.q=q;
		this.answers=answers;
		this.rightAnswers=rightAnswers;
	}
	
	public String getQuestion()
	{
		return this.q;
	}
	public List<String> getAnswers()
	{
		return this.answers;
	}
	public boolean validAnswers(String inp)
	{
		return this.answers.contains(inp);
	}
	public abstract String verify(List<String> inputAnswers);
}
