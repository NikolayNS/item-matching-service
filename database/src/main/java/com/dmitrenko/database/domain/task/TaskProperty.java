package com.dmitrenko.database.domain.task;

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
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Entity(name = "TASK_PROPERTY")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "TASK_PROPERTY_ID"))
public class TaskProperty extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "PATH", nullable = false)
	private String path;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "property")
	private List<Task> tasks = Collections.emptyList();

	public TaskProperty(Long id) {
		this.id = id;
	}

	@Override
	public TaskProperty setId(Long id) {
		this.id = id;
		return this;
	}

	@Override
	public TaskProperty setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
		return this;
	}

	@Override
	public TaskProperty setModifiedDateTime(LocalDateTime modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
		return this;
	}
}
