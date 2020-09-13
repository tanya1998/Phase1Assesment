package model;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import exception.FolderExceptions;

public class Folder {
	private Map<String,Folder> folders;
	private Set<String> files;
	private String name;
	public Folder() {

	}
	public Folder(String name) {
		this.name = name;
		folders = new HashMap<String,Folder>();
		files = new HashSet<String>();
	}
	public Map<String,Folder> getFolders() {
		return folders;
	}
	public void addFolders(Folder folder) throws FolderExceptions {
		if(folder==null)
		{
			throw new FolderExceptions("Folder can't be null object");
		}
		if(this.folders.containsKey(folder.getName()))
			throw new FolderExceptions("Duplicate folder name.");
		this.folders.put(folder.getName(),folder);
			
	}
	public Set<String> getFiles() {
		return files;
	}
	public void addFiles(String file) throws FolderExceptions {
		if(!files.add(file))
		{
			throw new FolderExceptions("File already exists. Try another file name");
		}
		else
		{
			System.out.println("File added to specified folder succesfully");
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString()
	{
		String s = name + ":- \n"+ folders.values().toString() + "\n" +files.toString();
		return s;
	}
	@Override
	public boolean equals(Object o)
	{
		Folder f = (Folder)o;
		if(f.getName() == this.getName())
			return true;
		return false;
		
	}
	
	

}
