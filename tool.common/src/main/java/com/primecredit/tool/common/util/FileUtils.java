package com.primecredit.tool.common.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

	public static void deleteFiles(String path) {

		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		for (File file : listOfFiles) {
			file.delete();
		}

	}

	public static List<String> listFiles(String dir, String fileExt) {
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

	public static File generateFile(String path, String fileName, byte[] data) throws Exception {
		StringBuilder sbPath = new StringBuilder();
		sbPath.append(path);
		if (!path.endsWith(String.valueOf(File.separatorChar))) {
			sbPath.append(File.separatorChar);
		}
		sbPath.append(fileName);

		try (FileOutputStream stream = new FileOutputStream(sbPath.toString());) {
			stream.write(data);
		} catch (FileNotFoundException e) {
			throw new Exception("FileNotFoundException:" + e.getMessage());

		} catch (IOException e) {
			throw new Exception("IOException:" + e.getMessage());
		}

		return new File(sbPath.toString());
	}

	public static boolean moveFile(String sourceFileName, String distFolderName) {
		boolean result = true;
		Path sourcePath = Paths.get(sourceFileName);
		Path distPath = Paths.get(distFolderName);

		try {
			Files.move(sourcePath, distPath.resolve(sourcePath.getFileName()));
		} catch (IOException e) {
			result = false;
		}

		return result;
	}

}
