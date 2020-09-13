package service;

import exception.FolderExceptions;
import model.Folder;

public interface FolderService {
	public void createfile(String f,String name) throws FolderExceptions;
	public void addfolder(String parent, Folder folder) throws FolderExceptions;
	public void deletefile(String f,String name) throws FolderExceptions;
	public void searchfile(String name) throws FolderExceptions;
	public void printAll();
	
}
