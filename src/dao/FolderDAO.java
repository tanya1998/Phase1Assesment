package dao;


import java.util.Set;
import java.util.Map.Entry;

import exception.FolderExceptions;
import model.File;

public interface FolderDAO {
	
	public void searchFile(String name) throws FolderExceptions;
	public void addFile(File file) throws FolderExceptions;
	public void deleteFile(String name) throws FolderExceptions;
	public Set<Entry<String, File>> getAllFile() throws FolderExceptions;

}
