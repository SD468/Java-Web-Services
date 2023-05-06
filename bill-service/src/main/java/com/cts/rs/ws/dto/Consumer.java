package com.cts.rs.ws.dto;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Consumer {
	
	private int biilId;
	private String consumerId;
	private String consumerName;
	private String qName;
	private int consumedUnit;
	public Consumer() {
	}
	public Consumer(int biilId, String consumerId, String consumerName, String qName, int consumedUnit) {
		super();
		this.biilId = biilId;
		this.consumerId = consumerId;
		this.consumerName = consumerName;
		this.qName = qName;
		this.consumedUnit = consumedUnit;
	}
	public Consumer(String consumerId, String consumerName, String qName, int consumedUnit) {
		super();
		this.consumerId = consumerId;
		this.consumerName = consumerName;
		this.qName = qName;
		this.consumedUnit = consumedUnit;
	}
	public int getBiilId() {
		return biilId;
	}
	public void setBiilId(int biilId) {
		this.biilId = biilId;
	}
	public String getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}
	public String getConsumerName() {
		return consumerName;
	}
	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}
	public String getqName() {
		return qName;
	}
	public void setqName(String qName) {
		this.qName = qName;
	}
	public int getConsumedUnit() {
		return consumedUnit;
	}
	public void setConsumedUnit(int consumedUnit) {
		this.consumedUnit = consumedUnit;
	}
	
	

}
