package com.mycompany.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

import com.mycompany.SpringSampleBean;

@MountPath("testAnnotationPage")
public class TestAnnotationPage extends WebPage {
	private static final long serialVersionUID = 1L;

	@SpringBean
	private SpringSampleBean springSampleBean;

	public TestAnnotationPage(final PageParameters parameters) {
		super(parameters);
		add(new Label("title", "Test Annotation Page").setRenderBodyOnly(true));
		add(new Label("success_note", springSampleBean.getText()));

		// TODO Add your page's components here

	}
}
