package com.mycompany.services;

import java.util.List;

import com.mycompany.pojo.TradingViewInteraction;

public interface ITradingViewInteractionService {
	List<TradingViewInteraction> findAll();
	void save(final TradingViewInteraction tradingViewInteraction);	
}
