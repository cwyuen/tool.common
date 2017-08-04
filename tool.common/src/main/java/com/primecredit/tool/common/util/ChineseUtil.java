package com.primecredit.tool.common.util;

import java.lang.Character.UnicodeBlock;
import java.util.HashSet;
import java.util.Set;

public class ChineseUtil {

	public static String removeNonChinese(String input) {
		StringBuilder sbResult = new StringBuilder();

		@SuppressWarnings("serial")
		Set<UnicodeBlock> chineseUnicodeBlocks = new HashSet<UnicodeBlock>() {
			{
				add(UnicodeBlock.CJK_COMPATIBILITY);
				add(UnicodeBlock.CJK_COMPATIBILITY_FORMS);
				add(UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS);
				add(UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT);
				add(UnicodeBlock.CJK_RADICALS_SUPPLEMENT);
				add(UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION);
				add(UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS);
				add(UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A);
				add(UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B);
				add(UnicodeBlock.KANGXI_RADICALS);
				add(UnicodeBlock.IDEOGRAPHIC_DESCRIPTION_CHARACTERS);

			}
		};

		for (char c : input.toCharArray()) {
			if (chineseUnicodeBlocks.contains(UnicodeBlock.of(c))) {
				sbResult.append(c);
			}
		}

		return sbResult.toString();
	}
}
