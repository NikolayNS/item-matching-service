package com.dmitrenko.database.domain.modifedstring;

import com.dmitrenko.database.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "modified_string")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "modified_string_id"))
public class ModifiedString extends BaseEntity {

	@Column(name = "modifiable", nullable = false)
	private String modifiable;

	@Column(name = "modifying", nullable = false)
	private String modifying;

	public ModifiedString(Long id) {
		this.id = id;
	}
}
