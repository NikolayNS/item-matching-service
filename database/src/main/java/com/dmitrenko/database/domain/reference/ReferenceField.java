package com.dmitrenko.database.domain.reference;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Collections;
import java.util.List;

@Entity(name = "reference_field")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true, exclude = "items")
@EqualsAndHashCode(callSuper = true, exclude = "items")
@AttributeOverride(name = "id", column = @Column(name = "reference_field_id"))
public class ReferenceField extends BaseEntity {

	@Column(name = "barcode", nullable = false)
	private String barcode;

	@Column(name = "name", nullable = false)
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reference_id")
	private Reference reference;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "referenceField")
	private List<Item> items = Collections.emptyList();

	public ReferenceField(Long id) {
		this.id = id;
	}
}
