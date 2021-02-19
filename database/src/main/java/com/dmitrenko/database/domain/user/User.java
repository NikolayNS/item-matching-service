package com.dmitrenko.database.domain.user;

import com.dmitrenko.database.domain.BaseEntity;
import com.dmitrenko.database.domain.task.Task;
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

@Entity(name = "user")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true, exclude = "tasks")
@EqualsAndHashCode(callSuper = true, exclude = "tasks")
@AttributeOverride(name = "id", column = @Column(name = "user_id"))
public class User extends BaseEntity {

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "user_type", nullable = false)
	@Enumerated(value = EnumType.STRING)
	private UserType userType;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private List<Task> tasks = Collections.emptyList();

	public User(Long id) {
		this.id = id;
	}
}
