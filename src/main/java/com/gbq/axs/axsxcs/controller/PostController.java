package com.gbq.axs.axsxcs.controller;


import com.gbq.axs.axsxcs.pojo.Posting;
import com.gbq.axs.axsxcs.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.attribute.PosixFileAttributes;
import java.util.List;

@Api(tags = "帖子增删改查")
@RestController
@RequestMapping("/account")
public class PostController {

    @Autowired
    private PostService postService;

    @ApiOperation("查询所有帖子")
    @PostMapping("/login")
    public List<Posting> getAllPosting(@RequestBody Posting posting){
        return postService.grtAllPosting(posting);
    }
}
