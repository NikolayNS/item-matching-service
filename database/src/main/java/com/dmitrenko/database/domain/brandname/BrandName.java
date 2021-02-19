package com.dmitrenko.database.domain.brandname;

import com.dmitrenko.database.domain.BaseEntity;
import com.dmitrenko.database.domain.item.Item;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Collections;
import java.util.List;

@Entity(name = "brand_name")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true, exclude = "items")
@EqualsAndHashCode(callSuper = true, exclude = "items")
@AttributeOverride(name = "id", column = @Column(name = "brand_name_id"))
public class BrandName extends BaseEntity {

	@Column(name = "name", nullable = false)
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "brand")
	private List<Item> items = Collections.emptyList();

	public BrandName(Long id) {
		this.id = id;
	}
}
