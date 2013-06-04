package com.github.alexdp.vaadin7.sandbox;

import com.github.alexdp.vaadin7.sandbox.ui.MainPanel;
import com.github.alexdp.vaadin7.sandbox.util.spring.SpringDependencyInjector;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

public class ApplicationUI extends UI {
	
	public ApplicationUI() {
		super();
		SpringDependencyInjector.getInjector().inject(this);
	}

	public void init(VaadinRequest request) {
		getContent().setSizeFull();
		getContent().addComponent(new MainPanel());
	}
	


}
