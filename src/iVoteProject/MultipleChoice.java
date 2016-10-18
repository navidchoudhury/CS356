package iVoteProject;
import java.util.*;

public class MultipleChoice extends Question {
	public MultipleChoice(String q, List<String> answers, List<String> rightAnswers)
	{
		super(q,answers,rightAnswers);
	}
	
	public String verify(List<String> inputAnswers)
	{
		if(inputAnswers.size()<1)
		{
			return "At least once answers is required";
		}
		else
		{
			List<String> temp = new ArrayList<String>(inputAnswers);
			boolean correct = true;
			for(Integer i =0; i<this.rightAnswers.size(); i++)
			{
				correct = temp.remove(this.rightAnswers.get(i));
				if(!correct)
				{
					break;
				}
			}
			if(!correct ||temp.size()!=0)
			{
				return "Incorrect answer. Correct Answers: " + this.rightAnswers.toString();
				
			}
			else
			{
				return "Correct Answer(s)";
			}
		}
	}

}
