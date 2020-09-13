package dao;

import exception.FolderExceptions;
import model.Folder;

public class FolderDAOImpl implements FolderDAO {
	
	
	private static Folder root = new Folder("Root");
	public FolderDAOImpl()
	{
		// TODO Auto-generated method stub
	}

	@Override
	public Folder getfolder(String name) throws FolderExceptions {
		
		String[] hierarchy = name.trim().split("/");
		if(hierarchy.length==0)
		{
			return root;
		}
		else
		{
			Folder current = root;
			for(String s : hierarchy)
			{
				Folder next  = current.getFolders().getOrDefault(s,null);
				if(next == null)
				{
					throw new FolderExceptions("The folder path is invalid");
				}
				current = next;
			}
			return current;
		}
	}

	

	@Override
	public Folder getroot() {
		
		return root;
	}

}
