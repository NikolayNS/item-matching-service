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

@Entity(name = "BRAND")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@AttributeOverride(name = "id", column = @Column(name = "BRAND_ID"))
public class Brand extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@Column(name = "NAME")
	private String name;

	public Brand(Long id) {
		this.id = id;
	}

	@Override
	public Brand setId(Long id) {
		this.id = id;
		return this;
	}

	@Override
	public Brand setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
		return this;
	}

	@Override
	public Brand setModifiedDateTime(LocalDateTime modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
		return this;
	}
}
