package iVoteProject;

import java.util.*;
import java.util.Map.Entry;


public class IVoteService implements IVote {
	
	public Integer correctAmount;
	public boolean done;
	public Question q;
	public Hashtable<String, List<String>> entered;
	
	public IVoteService(Question q)
	{
		this.q = q;
		this.done = false;
		this.correctAmount=0;
		this.entered = new Hashtable<String, List<String>>();
	}
	public void end()
	{
		this.done = true;
	}
	public Integer total()
	{
		return this.entered.size();
	}
	//Stats
	public String stats()
	{
		check();
		String quest = "Question: ";
		quest += this.q.getQuestion();
		quest += "\nStatistics\n";
		
		List<String> pick = this.q.getAnswers();
		for(String p : pick)
		{
			Integer numb = 0;
			for(String userID : entered.keySet())
			{
				if(this.entered.get(userID).contains(p))
				{
					numb++;
				}
			}
			quest += p + "\t" + numb.toString() +"\n";
			
		}
		quest+= "\nTotal Submissions: "+this.total().toString();
		quest+="\nTotal correct: " + this.correctAmount +"\n";
		return quest;
	}
	//Check answers
	public void check()
	{
		if(!this.done)
		{
			return;
		}
		this.correctAmount = 0;
		for(Entry<String, List<String>> entries: entered.entrySet())
		{
			String determine = q.verify(entries.getValue());
			if(determine.compareTo("Correct Answer")==0)
			{
				this.correctAmount++;
			}
		}
	}
	//No same answers
	public List<String> notMultiple(List<String> inputed)
	{
		Set<String> temp = new HashSet<String>(inputed);
		List<String> list1 =  new ArrayList<String>();
		list1.addAll(temp);
		return list1;
	}
	
	public boolean entered(String userId, List<String> submission)
	{
		if(this.done)
		{
			return false;
		}
		if(submission == null)
		{
			return false;
		}
		List<String> accepted = new ArrayList<String>();
		List<String> noMult = notMultiple(submission);
		for(String inp : noMult)
		{
			if(this.q.validAnswers(inp))
			{
				accepted.add(inp);
			}
		}
		this.entered.put(userId,accepted);
		return true;
	}
}
