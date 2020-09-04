package by.epam.lobanok.lab02.server.controller.command.impl;

import by.epam.lobanok.lab02.bean.elements.Text;
import by.epam.lobanok.lab02.bean.elements.TextElement;
import by.epam.lobanok.lab02.server.controller.command.Command;
import by.epam.lobanok.lab02.server.service.ServiceFactory;
import by.epam.lobanok.lab02.server.service.TextWorkerService;
import by.epam.lobanok.lab02.server.service.exception.ServiceException;

public class ReplaceCommand implements Command{

	@Override
	public TextElement execute(Text text) throws ServiceException {
		ServiceFactory factory = ServiceFactory.getInstance();			
		TextWorkerService textWorkerService = factory.getTextWorkerService();	
		textWorkerService.changeFirstAndLastWords(text);
		return text;
	}

}
