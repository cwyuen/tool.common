package com.primecredit.tool.common.parameter;

public class ApplicationConfig {
	
	private static final String SPEAKER_ID_WS_ROOT = "http://localhost:18761/SpeakerIdentification/";
	private static final String SPEAKER_ID_WS_DIARIZATION = "diarization";	

	private static final String SPEECH_RECOGNITION_WS_ROOT = "http://localhost:18762/SpeechRecognition/";
	private static final String SPEECH_RECOGNITION_WS_CONVERT = "recognition";

	private static final String SPEECH_STATISTICS_WS_ROOT = "http://localhost:18763/SpeechStatistics/";
	private static final String SPEECH_STATISTICS_WS_NL_STATISTICS = "nlStatistics";
	private static final String SPEECH_STATISTICS_WS_FQ_STATISTICS = "fqStatistics";
	
	private static final String NATURAL_LANGUAGE_WS_ROOT = "http://localhost:18762/NaturalLanguage/";
	private static final String NATURAL_LANGUAGE_WS_CONVERT = "analyzeEntities";

	public static String getSpeakerIdentificationDiarizationServiceUrl() {
		StringBuilder sb = new StringBuilder();
		sb.append(SPEAKER_ID_WS_ROOT);
		sb.append(SPEAKER_ID_WS_DIARIZATION);

		return sb.toString();
	}
	
	public static String getSpeechRecognitionConvertServiceUrl() {
		StringBuilder sb = new StringBuilder();
		sb.append(SPEECH_RECOGNITION_WS_ROOT);
		sb.append(SPEECH_RECOGNITION_WS_CONVERT);

		return sb.toString();
	}
	
	public static String getSpeechNatualLangStatisticsServiceUrl() {
		StringBuilder sb = new StringBuilder();
		sb.append(SPEECH_STATISTICS_WS_ROOT);
		sb.append(SPEECH_STATISTICS_WS_NL_STATISTICS);

		return sb.toString();
	}
	
	public static String getSpeechFreqWordStatisticsServiceUrl() {
		StringBuilder sb = new StringBuilder();
		sb.append(SPEECH_STATISTICS_WS_ROOT);
		sb.append(SPEECH_STATISTICS_WS_FQ_STATISTICS);

		return sb.toString();
	}
	
	public static String getNaturalLanguageAnalyzeEntitiesUrl() {
		StringBuilder sb = new StringBuilder();
		sb.append(NATURAL_LANGUAGE_WS_ROOT);
		sb.append(NATURAL_LANGUAGE_WS_CONVERT);

		return sb.toString();
	}
}
