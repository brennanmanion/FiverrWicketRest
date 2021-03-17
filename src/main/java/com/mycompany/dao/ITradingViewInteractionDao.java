package com.mycompany.dao;

import java.util.List;

import com.mycompany.pojo.TradingViewInteraction;

public interface ITradingViewInteractionDao extends IGenericDao<TradingViewInteraction>{
	List<TradingViewInteraction> findAll();
}
