package com.nhnacademy.jdbc.board.web;

import com.nhnacademy.jdbc.board.CookieManager;
import com.nhnacademy.jdbc.board.exception.ValidationFailedException;
import com.nhnacademy.jdbc.board.post.domain.Post;
import com.nhnacademy.jdbc.board.post.service.PostService;
import com.nhnacademy.jdbc.board.reply.domain.Reply;
import com.nhnacademy.jdbc.board.reply.domain.ReplyVo;
import com.nhnacademy.jdbc.board.reply.service.ReplyService;
import com.nhnacademy.jdbc.board.request.PostModifyRequest;
import com.nhnacademy.jdbc.board.request.PostRegisterRequest;
import com.nhnacademy.jdbc.board.user.domain.SessionUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.StringTokenizer;

@Slf4j
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
    public String redirectPostRegister(HttpServletRequest request,
                                       Model model){

        SessionUser sessionUser = getSessionUser(request);

        model.addAttribute("writerName",sessionUser.getName());
        model.addAttribute("writerId",sessionUser.getId());

        return "post/register";
    }

    @GetMapping("/modify")
    public ModelAndView redirectPostModify(@RequestParam("postId") String postId){

        ModelAndView mav = new ModelAndView();

        mav.setViewName("post/modify");

        return mav;
    }

    @GetMapping("/view")
    public ModelAndView redirectPostView(@RequestParam("postId") long postId,
                                         HttpServletRequest request){
        ModelAndView mav = new ModelAndView();

        SessionUser sessionUser = getSessionUser(request);

        Post post = postService.getPostById(postId);
        List<ReplyVo> replies = replyService.getRepliesByPostId(postId);



        mav.addObject("post",post);
        mav.addObject("replies",replies);
        mav.addObject("writer",sessionUser);

        mav.setViewName("post/view");

        return mav;
    }

    @PostMapping("/register")
    public String registerPost(@Valid @ModelAttribute PostRegisterRequest request,
                               BindingResult result,
                               Model model){

        if(result.hasErrors()){
            throw new ValidationFailedException(result);
        }


        Post post = postService.registerPost(request);

        model.addAttribute("post",post);

        return "redirect:/post/view?postId="+post.getPostId();
    }

    @PostMapping("/modify")
    public String modifyPost(@Valid @ModelAttribute PostModifyRequest request,
                             BindingResult result,
                             Model model){

        if(result.hasErrors()){
            throw new ValidationFailedException(result);
        }

        Post post = postService.modifyPost(request);

        model.addAttribute("post",post);

        return "post/view";
    }

    public SessionUser getSessionUser(HttpServletRequest request){
        Cookie cookie = CookieManager.getCookie(request);

        String userInfo = cookie.getValue();

        StringTokenizer st = new StringTokenizer(userInfo,"|");

        return new SessionUser(st.nextToken(),Long.parseLong(st.nextToken()));
    }

}
