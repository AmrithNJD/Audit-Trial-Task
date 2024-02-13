package com.example.QubitsDemo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Feilds {
	@Id
	@GeneratedValue
	private int tenantId;
	private String tenantName;
	private String tenantShortCode;
	private String Country;
	public int getTenantId() {
		return tenantId;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public String getTenantShortCode() {
		return tenantShortCode;
	}

	public void setTenantShortCode(String tenantShortCode) {
		this.tenantShortCode = tenantShortCode;
	}
}
