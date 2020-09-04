package by.epam.lobanok.lab02.server.service;

import java.util.Set;

import by.epam.lobanok.lab02.bean.elements.Text;
import by.epam.lobanok.lab02.bean.elements.Word;
import by.epam.lobanok.lab02.server.service.exception.ServiceException;

public interface TextWorkerService {
	
	public void changeFirstAndLastWords(Text text) throws ServiceException;
	public Set<Word> getWordsFromQuestions(Text text, int length) throws ServiceException;
	public Word findOriginalWordFromFirstSentence(Text text) throws ServiceException;
}
