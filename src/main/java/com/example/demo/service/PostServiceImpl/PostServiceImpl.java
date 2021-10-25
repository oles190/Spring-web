package com.example.demo.service.PostServiceImpl;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Override
    public void delete(Post post) {
        repository.delete(post);
    }

    @Autowired
    private PostRepository repository;



    @Override
    public List<Post> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Post post) {
repository.save(post);
    }

    @Override
    public Optional<Post> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public boolean isExists(int id) {
        return repository.existsById(id);
    }
}
