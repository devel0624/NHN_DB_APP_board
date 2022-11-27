package com.nhnacademy.jdbc.board.web;

import com.nhnacademy.jdbc.board.reply.service.ReplyService;
import com.nhnacademy.jdbc.board.request.ReplyRegisterRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("reply")
public class ReplyController {

    ReplyService replyService;

    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }

    @PostMapping
    public String registerReply(@Valid @ModelAttribute ReplyRegisterRequest replyRegisterRequest){
        replyService.insertReply(replyRegisterRequest);

        return "redirect:/post/view?postId="+replyRegisterRequest.getPostId();
    }

    @GetMapping("/delete")
    public String deleteReply(@RequestParam("replyId") long replyId,
                              @RequestParam("postId") long postId){

        replyService.hideReplyById(replyId);

        return "redirect:/post/view?postId="+postId;
    }

    @GetMapping("/restore")
    public String restoreReply(@RequestParam("replyId") long replyId,
                              @RequestParam("postId") long postId){

        replyService.restoreReplyById(replyId);

        return "redirect:/post/view?postId="+postId;
    }
}
