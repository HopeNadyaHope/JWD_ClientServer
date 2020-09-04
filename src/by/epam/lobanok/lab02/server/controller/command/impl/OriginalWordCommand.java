package by.epam.lobanok.lab02.server.controller.command.impl;

import by.epam.lobanok.lab02.bean.elements.Text;
import by.epam.lobanok.lab02.bean.elements.TextElement;
import by.epam.lobanok.lab02.bean.elements.Word;
import by.epam.lobanok.lab02.client.view.Printer;
import by.epam.lobanok.lab02.server.controller.command.Command;
import by.epam.lobanok.lab02.server.service.ServiceFactory;
import by.epam.lobanok.lab02.server.service.TextWorkerService;
import by.epam.lobanok.lab02.server.service.exception.ServiceException;

public class OriginalWordCommand implements Command {

	@Override
	public TextElement execute(Text text) throws ServiceException {
		ServiceFactory factory = ServiceFactory.getInstance();			
		TextWorkerService textWorkerService = factory.getTextWorkerService();

		Word word = textWorkerService.findOriginalWordFromFirstSentence(text);
		Printer printer = Printer.getInstance();
		printer.printTextElement(word);
		return word;
	}
}