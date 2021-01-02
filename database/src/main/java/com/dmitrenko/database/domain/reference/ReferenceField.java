package com.dmitrenko.database.domain.reference;

import com.dmitrenko.database.domain.BaseEntity;
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

@Entity(name = "REFERENCE_FIELD")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "REFERENCE_FIELD_ID"))
public class ReferenceField extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "BARCODE")
	private String barcode;

	@Column(name = "NAME", nullable = false)
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REFERENCE_ID")
	private Reference reference;

	public ReferenceField(Long id) {
		this.id = id;
	}

	@Override
	public ReferenceField setId(Long id) {
		this.id = id;
		return this;
	}

	@Override
	public ReferenceField setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
		return this;
	}

	@Override
	public ReferenceField setModifiedDateTime(LocalDateTime modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
		return this;
	}
}