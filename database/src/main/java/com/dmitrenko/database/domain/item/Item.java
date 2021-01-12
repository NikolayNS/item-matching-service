package com.dmitrenko.database.domain.item;

import com.dmitrenko.database.domain.BaseEntity;
import com.dmitrenko.database.domain.brandname.BrandName;
import com.dmitrenko.database.domain.company.Company;
import com.dmitrenko.database.domain.reference.ReferenceField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity(name = "ITEM")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "ITEM_ID"))
public class Item extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "BARCODE")
	private String barcode;

	@Column(name = "NAME", nullable = false)
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRICE_ID")
	private Price price;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TYPE_ID")
	private ItemType type;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPANY_ID")
	private Company company;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BRAND_ID")
	private BrandName brandName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REFERENCE_FIELD_ID")
	private ReferenceField referenceField;

	public Item(Long id) {
		this.id = id;
	}

	@Override
	public Item setId(Long id) {
		this.id = id;
		return this;
	}

	@Override
	public Item setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
		return this;
	}

	@Override
	public Item setModifiedDateTime(LocalDateTime modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
		return this;
	}
}
