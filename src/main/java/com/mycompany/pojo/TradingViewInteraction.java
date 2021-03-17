package com.mycompany.pojo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.mycompany.data.enums.TradeAction;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tradingViewInteractions")
public class TradingViewInteraction extends BaseModel{	
	
	@Getter
    @Setter
    @Column(name = "ticker")	
	public String ticker;

    @Getter
    @Setter
    @Column(name = "timeInterval")    
	public Long timeInterval;	
	
    @Getter
    @Setter
    @Column(name = "price")    
	public BigDecimal price;

    @Getter
    @Setter
    @Column(name = "date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	public DateTime date;
    
    @Getter
    @Setter
    @Column(name = "tradeAction")
    @Enumerated(EnumType.STRING)
	public TradeAction tradeAction;
}