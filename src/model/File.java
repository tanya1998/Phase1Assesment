package model;

public class File {
	String name;
	Long size;
	String date;
	public File()
	{
		
	}
	public File(String name, Long size, String date) {
		super();
		this.name = name;
		this.size = size;
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public boolean equals(Object o)
	{
		File file = (File)o;
		if(file.name == this.name)
			return true;
		return false;
	}
	
	@Override
	public String toString()
	{
		return (name + "/t" + size +"/t" + "date");
	}
}
