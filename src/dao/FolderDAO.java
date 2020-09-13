package dao;


import exception.FolderExceptions;
import model.Folder;

public interface FolderDAO {
	
	public Folder getfolder(String name) throws FolderExceptions;
	public Folder getroot();

}
