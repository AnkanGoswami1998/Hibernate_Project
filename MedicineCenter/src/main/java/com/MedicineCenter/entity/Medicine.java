package com.MedicineCenter.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Medicine_Details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medicine {
	
	@Id
	private int m_id;
	private String m_name;
	private double price;
	private String expiry_date;
	

}
