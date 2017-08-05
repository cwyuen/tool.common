package com.primecredit.tool.common.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

public class WavFileHandler {
	
	private static final int MAX_PLAYTIME_PER_FILE = 40; // second

	private static WavFileHandler instance = null;

	public static WavFileHandler getInstance() {
		if (instance == null) {
			instance = new WavFileHandler();
		}
		return instance;
	}

	public List<String> listWavFiles(String dir) {
		return FileUtil.listFiles(dir, "wav");
	}

	public File generateFile(String path, String fileName, byte[] data) throws Exception {
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
	
	public List<String> splitWavFile(String sourceFileName, String destPath) throws Exception {
		List<String> resultList = new ArrayList<String>();

		
		File srcFile = new File(sourceFileName);

		AudioInputStream srcClip = AudioSystem.getAudioInputStream(new File(sourceFileName));
		AudioFormat audioFormat = srcClip.getFormat();
		long framesLenght = srcClip.getFrameLength();
		double time = framesLenght / audioFormat.getFrameRate();

		int numberofSplit = (int) (time / MAX_PLAYTIME_PER_FILE) + 1;

		if (numberofSplit == 1) {
			// File srcFile = new File(fileName);
			File distFile = new File(destPath + srcFile.getName());
			Files.copy(srcFile.toPath(), distFile.toPath());
			resultList.add(distFile.getAbsolutePath());
		} else {

			int count = 1;
			int startLen = 0;
			while (count <= numberofSplit) {
				long now = System.currentTimeMillis();
				String distFileName = destPath + count + "_" + now + "_" + srcFile.getName();
				copyWavAudioBySecond(sourceFileName, distFileName, startLen, MAX_PLAYTIME_PER_FILE);
				resultList.add(distFileName);
				count++;
				startLen = startLen + MAX_PLAYTIME_PER_FILE;
			}

		}

		return resultList;
	}

	
	public void copyWavAudioBySecond(String sourceFileName, String destinationFileName, 
			double startSecond,
			double secondsToCopy) {
		AudioInputStream inputStream = null;
		AudioInputStream shortenedStream = null;
		try {
			File file = new File(sourceFileName);
			AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(file);
			AudioFormat format = fileFormat.getFormat();
			inputStream = AudioSystem.getAudioInputStream(file);
			int bytesPerSecond = format.getFrameSize() * (int) format.getFrameRate();
			inputStream.skip((long) startSecond * bytesPerSecond);
			long framesOfAudioToCopy = (long) (secondsToCopy *  format.getFrameRate());
			shortenedStream = new AudioInputStream(inputStream, format, framesOfAudioToCopy);
			File destinationFile = new File(destinationFileName);
			AudioSystem.write(shortenedStream, fileFormat.getType(), destinationFile);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null)
				try {
					inputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			if (shortenedStream != null)
				try {
					shortenedStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}

}
