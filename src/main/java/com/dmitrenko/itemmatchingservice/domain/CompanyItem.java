package com.dmitrenko.itemmatchingservice.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity(name = "COMPANY_ITEM")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@AttributeOverride(name = "id", column = @Column(name = "COMPANY_ITEM_ID"))
public class CompanyItem extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@Column(name = "BARCODE")
	private String barcode;

	@Column(name = "NAME")
	private String name;

	public CompanyItem(Long id) {
		this.id = id;
	}

	@Override
	public CompanyItem setId(Long id) {
		this.id = id;
		return this;
	}

	@Override
	public CompanyItem setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
		return this;
	}

	@Override
	public CompanyItem setModifiedDateTime(LocalDateTime modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
		return this;
	}
}
