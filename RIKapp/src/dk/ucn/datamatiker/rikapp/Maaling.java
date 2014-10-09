package dk.ucn.datamatiker.rikapp;

public class Maaling{
	
	private int id;
	private String time;
	private String date;
	private int ml;
	private String note;
	
	public Maaling(){
		
	}
	
	public Maaling(int id, String time, String date, int ml, String note)
	{
		
		this.id = id;
		this.time = time;
		this.date = date;
		this.ml = ml;
		this.note = note;
	}
	
	public Maaling(String time, String date, int ml, String note)
	{
		this.time = time;
		this.date = date;
		this.ml = ml;
		this.note = note;
	}
	
	public Maaling(String time, String date, int ml)
	{
		this.time = time;
		this.date = date;
		this.ml = ml;
	}
	
	public void setNote(String note)
	{
		this.note = note;
	}
	
	public String getNote()
	{
		return this.note;
	}
	
	public String getTime()
	{
		return this.time;
	}
	
	public String getDate()
	{
		return this.date;
	}
	
	public int getMl()
	{
		return this.ml;
	}

}
