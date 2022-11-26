package com.nhnacademy.jdbc.board.web;

import com.nhnacademy.jdbc.board.exception.ValidationFailedException;
import com.nhnacademy.jdbc.board.post.domain.Post;
import com.nhnacademy.jdbc.board.post.service.PostService;
import com.nhnacademy.jdbc.board.reply.domain.Reply;
import com.nhnacademy.jdbc.board.reply.service.ReplyService;
import com.nhnacademy.jdbc.board.request.PostModifyRequest;
import com.nhnacademy.jdbc.board.request.PostRegisterRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    PostService postService;
    ReplyService replyService;

    public PostController(PostService postService, ReplyService replyService) {
        this.postService = postService;
        this.replyService = replyService;
    }

    @GetMapping(value = {"/","/list"})
    public String redirectPostList(){
        return "post/list";
    }

    @GetMapping("/register")
    public String redirectPostRegister(){
        return "post/register";
    }

    @GetMapping("/modify")
    public ModelAndView redirectPostModify(@RequestParam("postId") String postId){

        ModelAndView mav = new ModelAndView();

        mav.setViewName("post/modify");

        return mav;
    }

    @GetMapping("/view")
    public ModelAndView redirectPostView(@RequestParam("postId") long postId){
        ModelAndView mav = new ModelAndView();

        Post post = postService.getPostById(postId);

        List<Reply> replies = replyService.getReplyByPostId(postId);

        mav.addObject("post",post);
        mav.addObject("replys",replies);

        mav.setViewName("post/view");

        return mav;
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute PostRegisterRequest request,
                               BindingResult result,
                               Model model){

        if(result.hasErrors()){
            throw new ValidationFailedException(result);
        }

        int postId = postService.registerPost(request);

        Post post = postService.getPostById(postId);

        model.addAttribute("post",post);

        return "post/view";
    }

    @PostMapping("/modify")
    public String modifyPost(@ModelAttribute PostModifyRequest request,
                             BindingResult result,
                             Model model){

        if(result.hasErrors()){
            throw new ValidationFailedException(result);
        }

        Post post = postService.modifyPost(request);

        model.addAttribute("post",post);

        return "post/view";
    }

}
