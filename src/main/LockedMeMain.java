package main;

import java.util.Scanner;

import exception.FolderExceptions;
import model.Folder;
import service.FolderService;
import service.FolderServiceImpl;

public class LockedMeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to LockedMe.com V1.0");
		System.out.println("------------------------------------");
		int ch = 0;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		FolderService service = new FolderServiceImpl();
		try {
			service.addfolder("/", new Folder("FirstFolder"));
			service.addfolder("FirstFolder", new Folder("SecondFolder"));
			service.addfolder("/", new Folder("FirstFolder"));
		} catch (FolderExceptions e2) {
			System.out.println(e2.getMessage());
		}
		//SuperHeroService service = new SuperHeroServiceImpl();
		do {
			System.out.println("\nMain Menu");
			System.out.println("===================");
			System.out.println("1)Display files in current working directory");
			System.out.println("2)Other options");
			System.out.println("3)Close LockedMe.com");
			System.out.println("Please Enter your appropriate choice(1-3)");
			try {
				ch = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {

			}
			switch (ch) {
			case 1 : 
					System.out.println("Displaying the current files and folders");
					try {
						service.createfile("FirstFolder/SecondFolder", "Firstfile");
					} catch (FolderExceptions e1) {
						System.out.println(e1.getMessage());
					}
					service.printAll();
					break;
			case 2 : 
					System.out.println("Other options");
					System.out.println("===================");
					int ch_next = 0;
					System.out.println("1) Add a file to existing directory");
					System.out.println("2) Delete a file from existing directory");
					System.out.println("3) Search a file from main directory");
					System.out.println("4) Go back to Main menu");
					System.out.println("Please Enter your appropriate choice(1-4)");
					try {
						ch_next = Integer.parseInt(scanner.nextLine());
					} catch (NumberFormatException e) {
		
					}
					switch(ch_next)
					{
					case 1: System.out.println("Provide Folder path");
							String path = scanner.nextLine();
							System.out.println("Please give the name of file");
							String name = scanner.nextLine();
							try {
								service.createfile(path, name);
							} catch (FolderExceptions e) {
								System.out.println(e.getMessage());
							}
							break;
					case 2: System.out.println("Provide Folder path");
							path = scanner.nextLine();
							System.out.println("Please give the name of file");
							name = scanner.nextLine();
							try {
								service.deletefile(path, name);
							} catch (FolderExceptions e) {
								System.out.println(e.getMessage());
							}
							break;
							
					case 3:	System.out.println("Provide File path");
							path = scanner.nextLine();
							try {
								service.searchfile(path);
							} catch (FolderExceptions e) {
								System.out.println("Search Unsuccessful"+e.getMessage());
							}
							break;
					
					case 4: System.out.println("Taking you to main menu.....");
					}
					break;
			case 3 :
					System.out.println("Thankyou for using LockedMe.com. Hope to see you soon.");
					break;
					 
			
			}
		}
		while(ch!=3);

	}

}
