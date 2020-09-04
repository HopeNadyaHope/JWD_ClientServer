package by.epam.lobanok.lab02.server.dao.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epam.lobanok.lab02.bean.elements.Sentence;
import by.epam.lobanok.lab02.bean.elements.SentenceElement;

public class SentenceParser {
	
	private final String DELIMETERS;	
	private final Pattern DELIMETERS_PATTERN;
	
	public SentenceParser(){
		this.DELIMETERS = "[.!?]+\\n*";
		this.DELIMETERS_PATTERN = Pattern.compile(DELIMETERS);
	}
	
	public List<Sentence> getSentences(String line){
		List<Sentence> readySentences = new ArrayList<Sentence>();
		
		String[] sentences;
		sentences = line.split(DELIMETERS);		
		int ind;
		ind = 0;
	
		ParserFactory parserFactory = ParserFactory.getInstance();
		SentenceElementParser sentenceElementParser = parserFactory.getSentenceElementParser();
		Matcher matcher = DELIMETERS_PATTERN.matcher(line);
		List<SentenceElement> elements;
		String sign;
		
		while(matcher.find()) {
			sign = matcher.group();
			elements = sentenceElementParser.getSentenceElements(sentences[ind++]);
			
			Sentence sentence = new Sentence(elements, sign);
			readySentences.add(sentence);
		}
		while( ind != sentences.length) {
			sign = "";
			elements = sentenceElementParser.getSentenceElements(sentences[ind++]);
			
			Sentence sentence = new Sentence(elements, sign);
			readySentences.add(sentence);
		}
		
		return readySentences;
	}
}