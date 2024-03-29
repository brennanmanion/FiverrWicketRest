package com.mycompany.pages;

import java.math.BigDecimal;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.joda.time.DateTime;
import org.wicketstuff.annotation.mount.MountPath;

import com.mycompany.SpringSampleBean;
import com.mycompany.data.enums.TradeAction;
import com.mycompany.pojo.TradingViewInteraction;
import com.mycompany.pojo.User;
import com.mycompany.services.TradingViewInteractionService;
import com.mycompany.services.UserService;
import com.mycompany.util.SecurityUtil;

@MountPath("testAnnotationPage")
public class TestAnnotationPage extends WebPage {
	private static final long serialVersionUID = 1L;

	@SpringBean
	private SpringSampleBean springSampleBean;
	
	@SpringBean
	private TradingViewInteractionService tradingViewInteractionService;	

	public TestAnnotationPage(final PageParameters parameters) {
		super(parameters);
		add(new Label("success_note", "test"));
	}
}
