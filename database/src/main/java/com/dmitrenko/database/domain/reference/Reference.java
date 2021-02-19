package com.dmitrenko.database.domain.reference;

import com.dmitrenko.database.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Collections;
import java.util.List;

@Entity(name = "reference")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true, exclude = "fields")
@EqualsAndHashCode(callSuper = true, exclude = "fields")
@AttributeOverride(name = "id", column = @Column(name = "reference_id"))
public class Reference extends BaseEntity {

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "reference_type", nullable = false)
	@Enumerated(value = EnumType.STRING)
	private ReferenceType referenceType;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "reference")
	private List<ReferenceField> fields = Collections.emptyList();

	public Reference(Long id) {
		this.id = id;
	}
}
