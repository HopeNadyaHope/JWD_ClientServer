package by.epam.lobanok.lab02.server.controller.command;

import by.epam.lobanok.lab02.bean.elements.Text;
import by.epam.lobanok.lab02.bean.elements.TextElement;
import by.epam.lobanok.lab02.server.service.exception.ServiceException;

public interface Command {

	public TextElement execute(Text text) throws ServiceException;
}
