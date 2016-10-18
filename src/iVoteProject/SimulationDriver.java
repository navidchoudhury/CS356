package iVoteProject;

import java.util.*;

public class SimulationDriver {

	public static void main(String[] args) {
		
		List<String> oneAnswer = new ArrayList<String>();
		List<String> multAnswer = new ArrayList<String>();
	
		List<String> oneOption = new ArrayList<String>();
		List<String> multOption = new ArrayList<String>();
		
		oneOption.add("Right");
		oneOption.add("Wrong");
		oneOption.add("A");
		oneOption.add("B");
		oneOption.add("C");
		oneOption.add("D");
		oneAnswer.add(oneOption.get(0));
		
		multOption.add("Right");
		multOption.add("Wrong");
		multOption.add("A");
		multOption.add("B");
		multOption.add("C");
		multOption.add("D");
		multAnswer.add(multOption.get(0));
		multAnswer.add(multOption.get(1));
		multAnswer.add(multOption.get(2));
		multAnswer.add(multOption.get(3));
		multAnswer.add(multOption.get(4));
		multAnswer.add(multOption.get(5));
		
		TestRun("OneAnswer","Is this question correct: 2+2 =4?",oneOption,oneAnswer,15);
		
		TestRun("MultipleAnswers", "Green is made from which colors? A.Blue, B. Yellow,C.Red",multOption,multAnswer,10);

	}
	public static List<String> randAnswers(List<String> choice, String type)
	{
		Random rand = new Random();
		Integer numAnswer =1;
		ArrayList<String> answer = new ArrayList<String>();
		if(type.equals("MultipleAnswers"))
		{
			numAnswer = rand.nextInt(choice.size()-1)+1;
		}
		for(Integer i = 0; i < numAnswer; i++)
		{
			answer.add(choice.get(rand.nextInt(choice.size())));
		}
		return answer;
	}
	public static void TestRun(String questionType, String question,List<String> choice,List<String> answer, Integer numberStudents)
	{
		Question q;
		IVote ivote;
		Student[] students = new Student[numberStudents];
		
		if(questionType.equals("OneAnswer"))
		{
			q = new SingleQuestion(question,choice,answer);

		}
		else
		{
			q = new MultipleChoice(question,choice,answer);
		}
		ivote = new IVoteService(q);
		
		for(int i = 0; i < students.length; i++)
		{
			students[i]=new Student();
			students[i].entered(randAnswers(choice,questionType));
			ivote.entered(students[i].getId(),students[i].getEntered());
		}
		ivote.end();
		System.out.println(ivote.stats());
	}

}
