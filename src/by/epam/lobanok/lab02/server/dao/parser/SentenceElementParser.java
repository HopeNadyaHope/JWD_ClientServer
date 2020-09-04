package by.epam.lobanok.lab02.server.dao.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epam.lobanok.lab02.bean.elements.SentenceElement;
import by.epam.lobanok.lab02.bean.elements.Sign;
import by.epam.lobanok.lab02.bean.elements.Word;

public class SentenceElementParser {

	private final String SENTENCE_ELEMENT_REGEX;
	private final Pattern SENTENCE_ELEMENT_PATTERN;
	
	public  SentenceElementParser() {
		this.SENTENCE_ELEMENT_REGEX = "(?<Word>\\w+)" + "|" + "(?<Sign>\\W+)";
		this.SENTENCE_ELEMENT_PATTERN = Pattern.compile(SENTENCE_ELEMENT_REGEX);
	}
	
	
	public List<SentenceElement> getSentenceElements(String sentence) {
		List<SentenceElement> elements = new ArrayList<SentenceElement>();
		Matcher matcher = SENTENCE_ELEMENT_PATTERN.matcher(sentence);
		String word;
		String sign;
		
		while(matcher.find()) {
			if((word = matcher.group("Word")) != null) {
				elements.add(new Word(word));
			}
			if((sign = matcher.group("Sign")) != null) {
				elements.add(new Sign(sign));
			}
		}		
		return elements;
	}
}
