package com.primecredit.tool.common.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	public static void deleteFiles(String path) {

		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		for (File file : listOfFiles) {
			file.delete();
		}

	}
	
	public static List<String> listFiles(String dir, String fileExt){
		List<String> results = new ArrayList<String>();
		File folder = new File(dir);
		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File dir, String filename) {
				return filename.endsWith("." + fileExt);
			}

		};

		File[] listOfFiles = folder.listFiles(filter);
		for (File file : listOfFiles) {
			results.add(file.getAbsolutePath());
		}

		return results;
	}
	
	
}
