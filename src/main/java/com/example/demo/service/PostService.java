package com.example.demo.service;

import com.example.demo.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<Post> findAll();
    void save(Post post);
    Optional<Post> findById(int id);
    boolean isExists(int id);
    void delete(Post post);



//
//     <div th:each:="el : ${posts}" class="alert alert-info mt-2">
//        <h3 th:text="${el.title}"/>
//        <p th:text="${el.anons}"/>
//        <a th:href="'/blog/'+ ${el.id}">Detail</a>
//
//    </div>



}
