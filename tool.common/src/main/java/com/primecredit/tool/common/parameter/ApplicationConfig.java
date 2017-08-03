package com.primecredit.tool.common.parameter;

public class ApplicationConfig {
	private static final String SPEAKER_ID_WS_ROOT = "http://localhost:18761/SpeakerIdentification/";
	private static final String SPEAKER_ID_WS_DIARIZATION = "diarization";
	//private static final String SPEAKER_ID_WS_TEST = "test";


	public static String getSpeakerIdentificationDiarizationServiceUrl() {
		StringBuilder sb = new StringBuilder();
		sb.append(SPEAKER_ID_WS_ROOT);
		sb.append(SPEAKER_ID_WS_DIARIZATION);

		return sb.toString();
	};
}
