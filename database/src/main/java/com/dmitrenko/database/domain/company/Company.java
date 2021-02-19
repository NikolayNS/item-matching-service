package com.dmitrenko.database.domain.company;

import com.dmitrenko.database.domain.BaseEntity;
import com.dmitrenko.database.domain.item.Item;
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

@Entity(name = "company")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true, exclude = "items")
@EqualsAndHashCode(callSuper = true, exclude = "items")
@AttributeOverride(name = "id", column = @Column(name = "company_id"))
public class Company extends BaseEntity {

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "company_type")
	@Enumerated(value = EnumType.STRING)
	private CompanyTypeEnum companyType;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "company")
	private List<Item> items = Collections.emptyList();

	public Company(Long id) {
		this.id = id;
	}
}
