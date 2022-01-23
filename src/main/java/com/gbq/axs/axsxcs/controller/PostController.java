package com.gbq.axs.axsxcs.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gbq.axs.axsxcs.pojo.Posting;
import com.gbq.axs.axsxcs.pojo.ResPageBean;
import com.gbq.axs.axsxcs.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@Api(tags = "帖子增删改查")
@RestController
@RequestMapping("/posting")
public class PostController {

    @Autowired
    private PostService postService;

    @ApiOperation("查询所有帖子")
    @GetMapping("/getAllPosting")
    public ResPageBean getAllPosting(@RequestParam(defaultValue = "1") Integer currentPage){
      return postService.getAllPosting(currentPage);

    }
}
