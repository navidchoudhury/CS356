package iVoteProject;
import java.util.*;

public class SingleQuestion extends Question {
	public SingleQuestion(String q, List<String> answer, List<String> rightAnswer)
	{
		super(q,answer,rightAnswer);
		if(rightAnswer.size()!=1)
		{
			throw new IllegalArgumentException("There is only one answer");
		}
	}
    public String verify(List<String>entered)
    {
    	if(entered.size()!=1)
    	{
    		return "There is only one answer";
    	}
    	else
    	{
    		if(this.rightAnswers.get(0).compareTo(entered.get(0))==0)
    		{
    			return "Correct Answer";
    		}
    		else
    		{
    			return "Incorrect Answer. Correct Answer: " + this.rightAnswers.get(0);
    		}
    	}
    }
}
