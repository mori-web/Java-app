package com.example.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.sql.Date;
import lombok.Data;

@Entity
@Data
@Table(name="todo5")
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private Integer id;

  @Column(name="title")
  @NotBlank(message="未入力です")
  private String title ;

  @Column(name="importance")
  private Integer importance;

  @Column(name="urgency")
  private Integer urgency;

  @Column(name="deadline")
  private Date deadline;

  @Column(name="done")
  private String done;


}
