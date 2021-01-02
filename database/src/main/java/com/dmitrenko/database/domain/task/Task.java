package com.dmitrenko.database.domain.task;

import com.dmitrenko.database.domain.BaseEntity;
import com.dmitrenko.database.domain.user.User;
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

@Entity(name = "TASK")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "TASK_ID"))
public class Task extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TASK_TYPE_ID")
	private TaskType type;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TASK_PROPERTY_ID")
	private TaskProperty property;

	public Task(Long id) {
		this.id = id;
	}

	@Override
	public Task setId(Long id) {
		this.id = id;
		return this;
	}

	@Override
	public Task setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
		return this;
	}

	@Override
	public Task setModifiedDateTime(LocalDateTime modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
		return this;
	}
}
