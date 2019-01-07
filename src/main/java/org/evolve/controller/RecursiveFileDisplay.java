package org.evolve.controller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class RecursiveFileDisplay {

	public static void main(String[] args) {
		System.out.println(Paths.get(".").toAbsolutePath().normalize().toString());
		System.out.println(System.getProperty("user.dir"));
		File currentDir = new File("."); // current directory
		System.out.println(Paths.get(".").toAbsolutePath().normalize().toString());
		System.out.println(System.getProperty("user.dir"));
		displayDirectoryContents(currentDir);
		
	}

	public static void displayDirectoryContents(File dir) {
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					System.out.println("directory:" + file.getCanonicalPath());
					displayDirectoryContents(file);
				} else {
					System.out.println("     file:" + file.getCanonicalPath());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}