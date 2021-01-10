package com.mycompany;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	@SpringBean
	private SpringSampleBean springSampleBean;

	public HomePage(final PageParameters parameters) {
		super(parameters);
		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));
		add(new Label("success_note", springSampleBean.getText()));

		// TODO Add your page's components here

	}
}
