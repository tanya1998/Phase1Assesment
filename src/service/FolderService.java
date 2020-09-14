package service;

import exception.FolderExceptions;
import model.File;

public interface FolderService {
	public void addFile(File file) throws FolderExceptions;
	public void deleteFile(String name) throws FolderExceptions;
	public void searchFile(String name) throws FolderExceptions;
	public void getAllFile() throws FolderExceptions;
	
}
