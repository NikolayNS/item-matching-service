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

@Entity(name = "TRADEMARK_FIELD")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@AttributeOverride(name = "id", column = @Column(name = "TRADEMARK_ID"))
public class Trademark extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@Column(name = "NAME")
	private String name;

	public Trademark(Long id) {
		this.id = id;
	}

	@Override
	public Trademark setId(Long id) {
		this.id = id;
		return this;
	}

	@Override
	public Trademark setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
		return this;
	}

	@Override
	public Trademark setModifiedDateTime(LocalDateTime modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
		return this;
	}
}
