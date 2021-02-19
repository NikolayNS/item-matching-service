package com.dmitrenko.database.domain.item;

import com.dmitrenko.database.domain.BaseEntity;
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
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Entity(name = "PRICE")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true, exclude = "items")
@EqualsAndHashCode(callSuper = true, exclude = "items")
@AttributeOverride(name = "id", column = @Column(name = "PRICE_ID"))
public class Price extends BaseEntity {

	@Column(name = "COST")
	private BigDecimal cost;

	@Column(name = "CURRENCY")
	@Enumerated(value = EnumType.STRING)
	private CurrencyEnum currency;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "price")
	private List<Item> items = Collections.emptyList();

	public Price(Long id) {
		this.id = id;
	}
}
