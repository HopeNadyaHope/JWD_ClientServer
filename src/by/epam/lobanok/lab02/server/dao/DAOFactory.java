package by.epam.lobanok.lab02.server.dao;

import by.epam.lobanok.lab02.server.dao.impl.TextDAOImpl;

public final class DAOFactory {
	
	private static final DAOFactory instance = new DAOFactory();
	private final TextDAO textDAO = new TextDAOImpl();
	
	private DAOFactory() {}

	public TextDAO getTextDAO() {
		return textDAO;
	}

	public static DAOFactory getInstance() {
		return instance;
	}
}