package exception;

@SuppressWarnings("serial")
public class FolderExceptions extends  Exception {
	public FolderExceptions()
	{
		
	}
	public FolderExceptions(final String message)
	{
		System.out.println(message);
	}

}
