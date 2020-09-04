package by.epam.lobanok.lab02.server.service;

import by.epam.lobanok.lab02.server.service.impl.TextCreatorServiceImpl;
import by.epam.lobanok.lab02.server.service.impl.TextWorkerServiceImpl;

public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();
	
	private final TextCreatorService textCreatorService = new TextCreatorServiceImpl();
	private final TextWorkerService textWorkerService = new TextWorkerServiceImpl();
	
	private ServiceFactory() {}

	public static ServiceFactory getInstance() {
		return instance;
	}

	public TextCreatorService getTextCreatorService() {
		return textCreatorService;
	}

	public TextWorkerService getTextWorkerService() {
		return textWorkerService;
	}
}
