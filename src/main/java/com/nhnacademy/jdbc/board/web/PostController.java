package com.nhnacademy.jdbc.board.web;

import com.nhnacademy.jdbc.board.CookieManager;
import com.nhnacademy.jdbc.board.exception.ValidationFailedException;
import com.nhnacademy.jdbc.board.page.Page;
import com.nhnacademy.jdbc.board.post.domain.Post;
import com.nhnacademy.jdbc.board.valueobject.PostVo;
import com.nhnacademy.jdbc.board.post.service.PostService;
import com.nhnacademy.jdbc.board.valueobject.ReplyVo;
import com.nhnacademy.jdbc.board.reply.service.ReplyService;
import com.nhnacademy.jdbc.board.request.PostModifyRequest;
import com.nhnacademy.jdbc.board.request.PostRegisterRequest;
import com.nhnacademy.jdbc.board.valueobject.SessionUser;
import com.nhnacademy.jdbc.board.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;

@Slf4j
@Controller
@RequestMapping("/post")
public class PostController {

    private final PostService postService;
    private final ReplyService replyService;
    private final UserService userService;

    public PostController(PostService postService, ReplyService replyService, UserService userService) {
        this.postService = postService;
        this.replyService = replyService;
        this.userService = userService;
    }

    @ModelAttribute("sessionUser")
    public SessionUser getSessionUser(HttpServletRequest request){

        try{
            Cookie cookie = CookieManager.getCookie(request);
            String userInfo = cookie.getValue();

            StringTokenizer st = new StringTokenizer(userInfo,"|");

            String name = st.nextToken();
            long userId = Long.parseLong(st.nextToken());
            boolean admin = userService.adminCheck(userId);

            log.info(""+admin);

            return new SessionUser(name,userId,admin);
        }catch (Exception e){
            log.info(""+e);
        }

        return null;
    }

    @GetMapping(value = {"/","/list"})
    public String redirectPostList(@ModelAttribute("sessionUser") SessionUser user,
                                   @RequestParam(value = "page", required = false) Optional<Long> page,
                                   Model model){
        long pageNo;

        if (page.isEmpty() || page.get() < 1){
            pageNo = 1;
        }else {
            pageNo = page.get();
        }

        Page<PostVo> posts = postService.getAllPostByPage(pageNo);

        model.addAttribute("sessionUser",user);
        model.addAttribute("posts",posts.getContent());
        model.addAttribute("pages",posts.getPageCount());
        model.addAttribute("currentPage",pageNo);

        return "post/list";
    }

    @GetMapping("/register")
    public String redirectPostRegister(@ModelAttribute("sessionUser") SessionUser user,
                                       Model model){

        model.addAttribute("sessionUser",user);

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

        PostVo post = postService.getPostById(postId);
        List<ReplyVo> replies = replyService.getRepliesByPostId(postId);


        mav.addObject("post",post);
        mav.addObject("replies",replies);
        mav.addObject("sessionUser",sessionUser);

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

    @GetMapping("/delete")
    public String removePost(@RequestParam("postId") long postId){
        postService.hidePostById(postId);

        return "redirect:/post/list";
    }

    @GetMapping("/restore")
    public String restorePost(@RequestParam("postId") long postId){
        postService.restorePostById(postId);

        return "redirect:/post/list";
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
}
