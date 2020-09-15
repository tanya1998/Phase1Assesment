package service;

import dao.FolderDAO;
import dao.FolderDAOImpl;
import exception.FolderExceptions;
import model.File;

public class FolderServiceImpl implements FolderService {

	private FolderDAO dao = new FolderDAOImpl();

	@Override
	public void addFile(File file) throws FolderExceptions {
		
		dao.addFile(file);
		
	}

	@Override
	public void deleteFile(String name) throws FolderExceptions {
		dao.deleteFile(name);
		
	}

	@Override
	public void searchFile(String name) throws FolderExceptions {
		dao.searchFile(name);
		
	}

	@Override
	public void getAllFile() throws FolderExceptions{
		System.out.println(dao.getAllFile().toString());
		
	}
	
	public boolean isValidName(String name)
	{
		if(name.trim().matches("[a-zA-Z_{}() ]{3,80}")) {
			return true;
		}
		return false;
	}
	public boolean isValidSize(long size)
	{
		if(size<=1000000000 && size>=0)
			return true;
		return false;
	}
}
