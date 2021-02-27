package com.mycompany.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.mycompany.SpringSampleBean;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	@SpringBean
	private SpringSampleBean springSampleBean;

	public HomePage(final PageParameters parameters) {
		super(parameters);
		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));
		add(new Label("success_note", springSampleBean.getText()));

		final Link<Void> linkToAnnotationPage = new Link<Void>("linkToAnnotationPage")
				{
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						setResponsePage(TestAnnotationPage.class);
					}			
				};
		add(linkToAnnotationPage);
		// TODO Add your page's components here

	}
}
