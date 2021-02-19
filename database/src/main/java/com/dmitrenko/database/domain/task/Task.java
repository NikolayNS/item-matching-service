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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "task")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "TASK_ID"))
public class Task extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Column(name = "task_type", nullable = false)
	@Enumerated(value = EnumType.STRING)
	private TaskType taskType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "task_property_id", nullable = false)
	private TaskProperty property;

	public Task(Long id) {
		this.id = id;
	}
}
