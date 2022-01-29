package com.gbq.axs.axsxcs.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gbq.axs.axsxcs.pojo.Comments;
import com.gbq.axs.axsxcs.pojo.Posting;
import com.gbq.axs.axsxcs.pojo.ResBean;
import com.gbq.axs.axsxcs.pojo.ResPageBean;
import com.gbq.axs.axsxcs.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@Api(tags = "帖子增删改查")
@RestController
@RequestMapping("/posting")
public class PostController {

    @Autowired
    private PostService postService;

    @ApiOperation("查询所有帖子")
    @GetMapping("/getAllPosting")
    public ResPageBean getAllPosting(@RequestParam(defaultValue = "1") Integer currentPage){
      return postService.getAllPosting1(currentPage);
    }

    @ApiOperation("获取帖子详情")
    @GetMapping("/getPostingById")
    public ResBean getPostingById(Integer id){
        System.out.println("进入-"+id);
        return postService.getPostingById(id);
    }

    @ApiOperation("点赞")
    @PutMapping("/likes/doLike/{uid}/{pid}")
    public ResBean doLike(@PathVariable("pid") Integer pid, @PathVariable("uid") Integer uid){
//        System.out.println(uid+"用户id");
//        System.out.println(pid+"帖子id");
        return postService.doLike(uid,pid);
    }
    @ApiOperation("取消点赞")
    @PutMapping("/likes/dontLike/{uid}/{pid}")
    public ResBean dontLike(@PathVariable("pid") Integer pid, @PathVariable("uid") Integer uid){
//        System.out.println(uid+"用户id");
//        System.out.println(pid+"帖子id");
        return postService.dontLike(uid,pid);
    }
    @ApiOperation("评论帖子")
    @PutMapping("/comments/insertComments")
    public ResBean remarkPosting(@RequestBody Comments comments){
//        System.out.println("评论对象"+comments);
        return postService.remarkPosting(comments);
    }
    @ApiOperation("我点赞的")
    @GetMapping("/mylike")
    public ResBean getMyLike(Integer uid){
//        System.out.println("评论对象"+comments);
       return postService.getMyLike(uid);
    }

    @ApiOperation("发布帖子")
    @PutMapping("/insertPosting")
    public ResBean insertPosting(@RequestBody Posting posting){
//        System.out.println(posting);
        return postService.insertPosting(posting);
    }

    @ApiOperation("我的帖子")
    @GetMapping("/getMyPosting")
    public ResPageBean getMyPosting(@RequestParam("uid") Integer uid,@RequestParam("curPage") Integer curPage){

        return postService.getMyPosting(uid,curPage);
    }
    @ApiOperation("获得所有标签")
    @GetMapping("/getAlltags")
    public ResBean getAllTags(){
        return postService.getAllTags();
    }

    @ApiOperation("删除帖子")
    @DeleteMapping("/delPosting/{pid}")
    public ResBean delPosting( @PathVariable("pid") Integer pid){
        System.out.println("要删除的帖子id       "+pid);
        return postService.delPosting(pid);
    }
    @ApiOperation("我评论的帖子")
    @GetMapping("/mycomPosting/{uid}")
    public ResBean getMycomPosting(@PathVariable("uid") Integer uid){
        return postService.getMyComPostin(uid);
    }

    @ApiOperation("删除帖子评论")
    @DeleteMapping("/delComment/{cid}/{pid}")
    public ResBean delComment(@PathVariable("cid") Integer cid, @PathVariable("pid") Integer pid){
        return postService.delComment(cid,pid);
    }
}
