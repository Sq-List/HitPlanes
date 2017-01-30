package entity;


public class Score
{
	private int user_score;
	
	public int getUser_score()
	{
		return user_score;
	}
	
	public void setUser_score(int user_score)
	{
		this.user_score = user_score;
	}
	
	@Override
	public String toString()
	{
		return user_score + "";
	}
}
