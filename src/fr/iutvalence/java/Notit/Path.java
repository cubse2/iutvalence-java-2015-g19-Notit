package fr.iutvalence.java.Notit;

import java.io.File;

/**
 * 
 * @author G19
 *
 */
public class Path {

	/**
	 * To check the path.
	 * 
	 * @param path
	 * @return boolean
	 */
	public static boolean checkPath(String path) {
		File file = new File(path);
		if (file.exists())
			return true;
		return false;
	}

	/**
	 * To create a path.
	 */
	public static void createPath(String path) {
		File file = new File(path);
		file.mkdirs();
	}

	public static int maxFileInPath(String path) {
		int max;
		File repository = new File(path);
		File[] files = repository.listFiles();
		if(files == null){
			max = 0;
		}
		else{
			max = (int) files[0].getName().charAt(0);
			for (int index = 0; index < files.length; index++) {
				if (max >= (int) files[index].getName().charAt(0))
					max = (int) files[index].getName().charAt(0);
			}
		}
		return max;
	}
}
