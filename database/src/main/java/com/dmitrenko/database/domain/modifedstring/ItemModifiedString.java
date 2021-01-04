package com.dmitrenko.database.domain.modifedstring;

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
import java.time.LocalDateTime;

@Entity(name = "ITEM_MODIFIED_STRING")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "ITEM_MODIFIED_STRING_ID"))
public class ItemModifiedString extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ITEM_ID")
	private Item item;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MODIFIED_STRING_ID")
	private ModifiedString modifiedString;

	public ItemModifiedString(Long id) {
		this.id = id;
	}

	@Override
	public ItemModifiedString setId(Long id) {
		this.id = id;
		return this;
	}

	@Override
	public ItemModifiedString setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
		return this;
	}

	@Override
	public ItemModifiedString setModifiedDateTime(LocalDateTime modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
		return this;
	}
}
