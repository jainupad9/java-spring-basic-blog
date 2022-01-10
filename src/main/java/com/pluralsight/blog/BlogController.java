package com.pluralsight.blog;

import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BlogController {
    public BlogController(PostRepository pr){
        postRepository = pr;
    }

    @RequestMapping("/")
    public String listPosts(ModelMap mm){
        List<Post> posts = postRepository.getAllPosts();

        mm.put("posts", posts);
        return "home";
    }

    @RequestMapping("/post/{id}")
    public String postDetails(@PathVariable Long id, ModelMap modelMap){
        Post post = postRepository.findById(id);

        modelMap.put("post", post);

        return "post-details";
    }

    private PostRepository postRepository;

}
