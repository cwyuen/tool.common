package com.primecredit.tool.common.util;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

public class WavFileHandler {
	
	private static final int MAX_PLAYTIME_PER_FILE = 10; // second

	private static WavFileHandler instance = null;

	public static WavFileHandler getInstance() {
		if (instance == null) {
			instance = new WavFileHandler();
		}
		return instance;
	}

	public List<String> listWavFiles(String dir) {
		return FileUtils.listFiles(dir, "wav");
	}

	
	
	public List<String> splitWavFile(String sourceFileName, String destPath) throws Exception {
		List<String> resultList = new ArrayList<String>();

		
		File srcFile = new File(sourceFileName);

		AudioInputStream srcClip = null;
				
		try{
			srcClip= AudioSystem.getAudioInputStream(new File(sourceFileName));
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
		}finally{		
			if(srcClip != null){
				srcClip.close();
			}
		}

		return resultList;
	}

	
	public void copyWavAudioBySecond(String sourceFileName, String destinationFileName, 
			double startSecond,
			double secondsToCopy) throws Exception {
		
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
			throw new Exception(e);
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
	
	public void convertULAW2PCM(String sourceFileName, String destinationFileName) {
		AudioInputStream inputStream = null;
		AudioInputStream shortenedStream = null;
		try {
			File pcmFile = new File(destinationFileName);
			File ulawFile = new File(sourceFileName);
			AudioInputStream ais = null;
			AudioFormat format = null;

			ais = AudioSystem.getAudioInputStream(ulawFile);
			format = ais.getFormat();

			if (AudioFormat.Encoding.ULAW.equals(format.getEncoding()) || 
					AudioFormat.Encoding.ALAW.equals(format.getEncoding())) {
				
				 AudioFormat newFormat = new AudioFormat(
						 AudioFormat.Encoding.PCM_SIGNED,
						 format.getSampleRate(),
						 format.getSampleSizeInBits() * 2,
						 format.getChannels(),
						 format.getFrameSize() * 2,
						 format.getFrameRate(),
						 true);

				//ais = AudioSystem.getAudioInputStream(format, ais);

				AudioInputStream audioInputStreamAIS = AudioSystem.getAudioInputStream(newFormat, ais);
				AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
				int nWrittenFrames = 0;
				nWrittenFrames = AudioSystem.write(audioInputStreamAIS, fileType, pcmFile);
				
				if(nWrittenFrames <= 0) {
					System.out.println("Failed: No Frame Written" );
				}
				
			}else {
				long framesLenght = ais.getFrameLength();
				double time = framesLenght / format.getFrameRate();
				this.copyWavAudioBySecond(sourceFileName, destinationFileName, 0, time);
			}

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
