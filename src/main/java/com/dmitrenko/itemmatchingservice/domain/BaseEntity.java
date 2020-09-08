package com.dmitrenko.itemmatchingservice.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

import static org.hibernate.id.enhanced.SequenceStyleGenerator.CONFIG_PREFER_SEQUENCE_PER_ENTITY;
import static org.hibernate.id.enhanced.SequenceStyleGenerator.CONFIG_SEQUENCE_PER_ENTITY_SUFFIX;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Accessors(chain = true)
@NoArgsConstructor
@MappedSuperclass
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ApiModel(value = "Base entity")
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ToString.Include
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @GenericGenerator(name = "sequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
                    @Parameter(name = CONFIG_PREFER_SEQUENCE_PER_ENTITY, value = "true"),
                    @Parameter(name = CONFIG_SEQUENCE_PER_ENTITY_SUFFIX, value = "_SEQ")
            })
    @EqualsAndHashCode.Include
    @Column(name = "ID")
    @ApiModelProperty(value = "ID")
    protected Long id;

    @CreationTimestamp
    @Column(name = "CREATED", nullable = false, updatable = false)
    @ApiModelProperty(value = "created entity time")
    protected LocalDateTime createdDateTime;

    @UpdateTimestamp
    @Column(name = "MODIFIED", nullable = false)
    @ApiModelProperty(value = "modified entity time")
    protected LocalDateTime modifiedDateTime;
}