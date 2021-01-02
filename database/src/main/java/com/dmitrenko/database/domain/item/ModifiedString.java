package com.dmitrenko.database.domain.item;

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
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Entity(name = "MODIFIED_STRING")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "MODIFIED_STRING_ID"))
public class ModifiedString extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "MODIFIABLE")
	private String modifiable;

	@Column(name = "MODIFYING")
	private String modifying;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "modifiedString")
	private List<ItemModifiedString> itemModifiedStrings = Collections.emptyList();

	public ModifiedString(Long id) {
		this.id = id;
	}

	@Override
	public ModifiedString setId(Long id) {
		this.id = id;
		return this;
	}

	@Override
	public ModifiedString setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
		return this;
	}

	@Override
	public ModifiedString setModifiedDateTime(LocalDateTime modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
		return this;
	}
}
