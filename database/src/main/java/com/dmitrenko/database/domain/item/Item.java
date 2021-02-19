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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "item")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "item_id"))
public class Item extends BaseEntity {

	@Column(name = "barcode")
	private String barcode;

	@Column(name = "name", nullable = false)
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "price_id")
	private Price price;

	@Column(name = "item_type", nullable = false)
	@Enumerated(value = EnumType.STRING)
	private ItemType itemType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_id")
	private BrandName brandName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reference_field_id")
	private ReferenceField referenceField;

	public Item(Long id) {
		this.id = id;
	}
}
