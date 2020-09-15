package dao;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import exception.FolderExceptions;
import model.File;

public class FolderDAOImpl implements FolderDAO {
	
	
	private static Map<String,File>  root = new TreeMap<String,File>();

	@Override
	public void searchFile(String name) throws FolderExceptions {
		// TODO Auto-generated method stub
		if(root.containsKey(name))
			{
				System.out.println("File found successfully");
				System.out.println(root.get(name));
			}
		else
			throw new FolderExceptions("The given file name doesn't exist");
		
		
	}

	@Override
	public void addFile(File file) throws FolderExceptions {
		
		if(root.containsKey(file.getName()))
			throw new FolderExceptions("The given file name already exists");
		root.put(file.getName(),file);
		System.out.println("File added succesfully");
	}

	@Override
	public void deleteFile(String name) throws FolderExceptions {
		
		if(!root.containsKey(name))
			throw new FolderExceptions("The file name doesn't exist");
		else
			System.out.println("File deleted successfuly");
		root.remove(name);
		
	}

	@Override
	public Set<Entry<String, File>> getAllFile() throws FolderExceptions {
		if(root.size()==0)
			throw new FolderExceptions("The main directory is Empty. No file to display");
		return root.entrySet();
	}
	
}
