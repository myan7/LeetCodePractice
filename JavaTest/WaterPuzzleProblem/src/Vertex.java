
public class Vertex
{	
	int[] combo = new int[3];

	public Vertex(int[] combo) 
	{
		super();
		this.combo = combo;
	}

	public boolean equals(Vertex test)
	{
		return test.combo.equals(combo);
	}
	
	public void output()
	{
		System.out.print("("+combo[0]+ ", " + combo[1]+", "+ combo[2]+")");
	}
	
	
	
	
	
}
