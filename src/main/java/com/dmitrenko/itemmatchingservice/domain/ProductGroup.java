package com.dmitrenko.itemmatchingservice.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Entity(name = "PRODUCT_GROUP")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@AttributeOverride(name = "id", column = @Column(name = "PRODUCT_GROUP_ID"))
public class ProductGroup extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "GROUP_INDEX")
	private Long groupIndex;

	@Column(name = "NAME")
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "productGroup")
	private List<CompanyItem> companyItems = new LinkedList<>();

	public ProductGroup(Long id) {
		this.id = id;
	}

	@Override
	public ProductGroup setId(Long id) {
		this.id = id;
		return this;
	}

	@Override
	public ProductGroup setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
		return this;
	}

	@Override
	public ProductGroup setModifiedDateTime(LocalDateTime modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
		return this;
	}
}
