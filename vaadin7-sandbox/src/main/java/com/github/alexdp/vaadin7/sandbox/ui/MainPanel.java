package com.github.alexdp.vaadin7.sandbox.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.alexdp.vaadin7.sandbox.service.HibernateExampleService;
import com.github.alexdp.vaadin7.sandbox.util.spring.SpringDependencyInjector;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.Reindeer;

public class MainPanel extends Panel {

	private Panel fullPagePanel;
	private Panel workPanel;
	
	@Autowired
	private HibernateExampleService service;


	public MainPanel() {
		super();
		SpringDependencyInjector.getInjector().inject(this);
		setContent(getFullPagePanel());
		setStyleName(Reindeer.PANEL_LIGHT);
		setSizeFull();
	}



	private Panel getFullPagePanel() {
		if (this.fullPagePanel == null) {
			this.fullPagePanel = new Panel();
			VerticalLayout layout = new VerticalLayout();
			layout.setSizeFull();
			layout.setSpacing(false);
			layout.setMargin(false);
			layout.addComponent(getWorkPanel());
			layout.addComponent(new Label("Hello World"));

			Button myButton = new Button("Click here", new Button.ClickListener() {
				
				@Override
				public void buttonClick(ClickEvent event) {
					Notification.show("Button clicked!", Type.WARNING_MESSAGE);
					
				}
			});
			layout.addComponent(myButton);
			this.fullPagePanel.setContent(layout);
			this.fullPagePanel.setSizeFull();
			this.fullPagePanel.setStyleName(Reindeer.PANEL_LIGHT);
		}
		return this.fullPagePanel;
	}

	private Panel getWorkPanel() {
		if (this.workPanel == null) {
			this.workPanel = new Panel();
			VerticalLayout layout = new VerticalLayout();
			layout.setSizeFull();
			layout.setSpacing(false);
			layout.setMargin(false);
			this.workPanel.setContent(layout);
			this.workPanel.setSizeFull();
			this.workPanel.setStyleName(Reindeer.PANEL_LIGHT);
		}
		return this.workPanel;
	}


}
