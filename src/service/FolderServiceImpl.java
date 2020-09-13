package service;

import java.util.Set;

import dao.FolderDAO;
import dao.FolderDAOImpl;
import exception.FolderExceptions;
import model.Folder;

public class FolderServiceImpl implements FolderService {

	private FolderDAO dao = new FolderDAOImpl();
	@Override
	public void createfile(String f, String name) throws FolderExceptions {
		Folder folder = dao.getfolder(f);
		if(folder!=null)
		{
			folder.addFiles(name);
		}
		
	}

	@Override
	public void deletefile(String f, String name) throws FolderExceptions {
		Folder folder = dao.getfolder(f);
		if(folder!=null)
		{
			Set<String> files = folder.getFiles();
			if(!files.remove(name))
			{
				throw new FolderExceptions("The file name doesn't exist in the specified folder");
			}
			else
			{
				System.out.println("The specified file has been deleted.");
			}
		}
		
	}

	@Override
	public void searchfile(String name) throws FolderExceptions {
		int file_break = name.trim().lastIndexOf('/');
		Folder folder = null;
		if(file_break == -1)
		{
			folder = dao.getroot();
		}
		else
		{
			folder = dao.getfolder(name.substring(0, file_break));
		}
		if(folder!=null)
		{
			if(folder.getFiles().contains(name.substring(file_break+1)))
				System.out.println("Search succesful. File exists at the given path");
			else
				System.out.println("Search unsuccessful. The given file can't be found");
			
		}
		
	}
	@Override
	public void addfolder(String parent, Folder folder) throws FolderExceptions {
		Folder par = dao.getfolder(parent);
		if(par!=null)
		{
			par.addFolders(folder);
		}
		
	}
	@Override
	public void printAll() {
		
		Folder root =  dao.getroot();
		System.out.println(root.toString());
		
	}
	

}
