package com.mycompany.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.pojo.TradingViewInteraction;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Transactional
@Repository
public class TradingViewInteractionDao extends AbstractGenericDao<TradingViewInteraction> implements ITradingViewInteractionDao{

    @PersistenceContext
    private EntityManager em;	
	
	@Override
	public List<TradingViewInteraction> findAll() {
        String hql = "Select * from tradingviewinteractions";
        Query query = em.createQuery(hql);
        return query.getResultList();
	}
	
	@Override
	public void setDefaults(TradingViewInteraction tradingViewInteraction) {		
	}
}
