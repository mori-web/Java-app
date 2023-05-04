package com.example.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
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
//  @NotBlank()
  private String title ;

  @Column(name="importance")
  @NotNull(message="チェックを入れて下さい")
//  @NotNull
  private Integer importance;

  @Column(name="urgency")
  @NotNull(message="選択してください")
//  @NotNull
  private Integer urgency;

  @Column(name="deadline")
//  @NotNull(message="期限を入力してください")
  @NotNull
  @DateTimeFormat(pattern ="yyyy-MM-dd")
  private Date deadline;

  @Column(name="done")
  private String done;

}
