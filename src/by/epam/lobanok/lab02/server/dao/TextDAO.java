package by.epam.lobanok.lab02.server.dao;

import by.epam.lobanok.lab02.bean.elements.Text;
import by.epam.lobanok.lab02.server.dao.exception.DAOException;

public interface TextDAO {	

	public Text createText(String path) throws DAOException;
}