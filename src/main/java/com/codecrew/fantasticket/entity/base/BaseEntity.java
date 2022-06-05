package com.codecrew.fantasticket.entity.base;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = -4463024877607502307L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
}