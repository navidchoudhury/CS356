package iVoteProject;
import java.util.*;

public interface IVote {

	public boolean entered(String userID, List<String> submited);
	
	String stats();
	Integer total();
	
	void end();
}
