package com.mycompany.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.dao.ITradingViewInteractionDao;
import com.mycompany.pojo.TradingViewInteraction;

@Service
@Transactional
public class TradingViewInteractionService implements ITradingViewInteractionService{

    @Autowired
    private ITradingViewInteractionDao tradingViewInteractionDao;		

	@Override
	public void save(TradingViewInteraction tradingViewInteraction) {
		tradingViewInteractionDao.save(tradingViewInteraction);
		
	}

	@Override
	public List<TradingViewInteraction> findAll() {
		return tradingViewInteractionDao.findAll();
	}

}
