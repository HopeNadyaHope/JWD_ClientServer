package by.epam.lobanok.lab02.server.service.impl;


import by.epam.lobanok.lab02.bean.elements.Text;
import by.epam.lobanok.lab02.server.dao.DAOFactory;
import by.epam.lobanok.lab02.server.dao.TextDAO;
import by.epam.lobanok.lab02.server.dao.exception.DAOException;
import by.epam.lobanok.lab02.server.service.TextCreatorService;
import by.epam.lobanok.lab02.server.service.exception.ServiceException;

public class TextCreatorServiceImpl implements TextCreatorService{

	public Text create(String path) throws ServiceException {
		DAOFactory factory;
		TextDAO textDAO;
		Text text;
		
		try {
			factory = DAOFactory.getInstance();
			textDAO = factory.getTextDAO();
			text = textDAO.createText(path);
		}catch (DAOException e) {
			throw new ServiceException(e);		
		}
		return text;
	}
}