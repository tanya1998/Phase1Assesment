package service;

import dao.FolderDAO;
import dao.FolderDAOImpl;
import exception.FolderExceptions;
import model.File;

public class FolderServiceImpl implements FolderService {

	private FolderDAO dao = new FolderDAOImpl();

	@Override
	public void addFile(File file) throws FolderExceptions {
		if(!isValidName(file.getName()))
		{
			throw new FolderExceptions(file.getName()+" contains invalid characters");
		}
		if(!isValidSize(file.getSize()))
		{
			throw new FolderExceptions(file.getSize()+ "is too large for the memory alloted to directory");
		}
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
		return false;
	}
	public boolean isValidSize(long size)
	{
		return false;
	}
}
