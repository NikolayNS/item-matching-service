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

@Entity(name = "REPLACEMENT_WORD_FIELD")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@AttributeOverride(name = "id", column = @Column(name = "REPLACEMENT_WORD_ID"))
public class ReplacementWord extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "REPLACEABLE")
	private String replaceable;

	@Column(name = "REPLACEMENT")
	private String replacement;

	public ReplacementWord(Long id) {
		this.id = id;
	}

	@Override
	public ReplacementWord setId(Long id) {
		this.id = id;
		return this;
	}

	@Override
	public ReplacementWord setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
		return this;
	}

	@Override
	public ReplacementWord setModifiedDateTime(LocalDateTime modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
		return this;
	}
}
