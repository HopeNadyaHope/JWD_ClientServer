package by.epam.lobanok.lab02.server.controller.command.impl;

import by.epam.lobanok.lab02.bean.elements.Sentence;
import by.epam.lobanok.lab02.bean.elements.Sign;
import by.epam.lobanok.lab02.bean.elements.Text;
import by.epam.lobanok.lab02.bean.elements.TextElement;
import by.epam.lobanok.lab02.bean.elements.Word;
import by.epam.lobanok.lab02.server.controller.command.Command;
import by.epam.lobanok.lab02.server.service.exception.ServiceException;

public class NoSuchCommand implements Command{

	@Override
	public TextElement execute(Text text) throws ServiceException {
		Sentence sentence = new Sentence();
		sentence.addSentenceElement(new Word("no"));
		sentence.addSentenceElement(new Sign(" "));
		sentence.addSentenceElement(new Word("such"));
		sentence.addSentenceElement(new Sign(" "));
		sentence.addSentenceElement(new Word("command"));
		return sentence;
	}
}
