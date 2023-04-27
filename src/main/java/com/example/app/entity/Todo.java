package com.example.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Past;
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
  @NotNull(message="チェックを入れて下さい")
  private Integer importance;

  @Column(name="urgency")
  @NotNull(message="選択してください")
  private Integer urgency;

  @Column(name="deadline")
  @NotNull(message="期限を設定してください")
  private Date deadline;

  @Column(name="done")
  private String done;


}
