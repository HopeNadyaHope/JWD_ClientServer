package by.epam.lobanok.lab02.server.service;

import by.epam.lobanok.lab02.bean.elements.Text;
import by.epam.lobanok.lab02.server.service.exception.ServiceException;

public interface TextCreatorService {	
	
	Text create(String path) throws ServiceException;	
}