package com.example.app.controller;

import com.example.app.entity.Todo;
import com.example.app.repository.TodoRepository;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class TodoController {

  private TodoRepository todoRepository;
  private HttpSession session;

  //Topの表示(Get)
  @GetMapping("/")
  public String index(Model model){
    model.addAttribute("title", "Hello TodoApp!");
    model.addAttribute("msg", "以下の画面からTodoアプリを作成してください");
    return "index";
  }

  //一覧画面の表示(Get)
  @GetMapping("/todo")
  public ModelAndView showTodo(ModelAndView mav){
    mav.setViewName("todoList");
    mav.addObject("title", "一覧画面");
    List<Todo> todoList = todoRepository.findAll();
    mav.addObject("todoList", todoList);
    return mav;
  }

  //新規作成画面の表示(Get)
  @GetMapping("/todo/create")
  public String CreateTodo(Model model, @ModelAttribute Todo hogehoge) {
    model.addAttribute("title", "新規作成");
    session.setAttribute("mode", "create");
    return "todoForm";
  }

  //新規追加の処理(Post)
  @PostMapping("/todo/create")
  public String CreateTodo(
      @ModelAttribute @Validated Todo todo,
      BindingResult bindingResult,
      Model model) {
    if (bindingResult.hasErrors()) {
      model.addAttribute("title", "新規作成");
      return "todoForm";
    }
    todoRepository.saveAndFlush(todo);
    return "redirect:/todo";
  }

  //編集画面(Get)
  @GetMapping("/todo/{id}")
  public ModelAndView EditTodo(
      @PathVariable("id") int id,
      ModelAndView mav) {
    mav.setViewName("todoForm");
    mav.addObject("todo", todoRepository.findById(id).get());
    mav.addObject("title", "編集画面");
    session.setAttribute("mode", "update");
    return mav;
  }

  //編集の処理(Post)
  @PostMapping("/todo/update")
  public String UpdateTodo(
      @ModelAttribute @Validated Todo todo,
      BindingResult bindingResult,
      Model model
  ){
    if(bindingResult.hasErrors()) {
      model.addAttribute("title", "編集画面");
      return "todoForm";
    }
    todoRepository.saveAndFlush(todo);
    return "redirect:/todo";
  }

  //削除確認画面(Get)
  @PostMapping("/todo/check")
  public ModelAndView CheckTodo(
      @ModelAttribute Todo todo,
     ModelAndView mav
  ){
    mav.setViewName("todoCheck");
    mav.addObject("todoList", todo);
    mav.addObject("msg", "本当に以下を削除しますか？");
    return mav;
  }

  //削除の処理(Post)
  @PostMapping("/todo/delete")
  public String DeleteTodo(@ModelAttribute Todo todo){
    todoRepository.deleteById(todo.getId());
    return "redirect:/todo";
  }
  

  //キャンセルの処理
  @GetMapping("/cancel")
  public String cancel() {
    return "redirect:/";
  }

  //キャンセルの処理
  @PostMapping("/todo/cancel")
  public String cancelTodo() {
    return "redirect:/todo";
  }


}
