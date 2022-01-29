package com.gbq.axs.axsxcs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gbq.axs.axsxcs.mapper.*;
import com.gbq.axs.axsxcs.pojo.*;
import com.gbq.axs.axsxcs.service.PostService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private TagsMapper tagsMapper;
    @Autowired
    private TagsPosMapper tagsPosMapper;
    @Autowired
    private LikesMapper likesMapper;

    @Override
    public ResPageBean getAllPosting1(Integer currentPage) {
        //开启分页
//        Page<Posting> page = new Page<>(currentPage, 10);
        System.out.println("进入service"+currentPage);
        List<Posting> postingIPage = postMapper.getAllPosting();

        List<Posting> collect = postingIPage.stream().skip((currentPage - 1) * 10).limit(10).collect(Collectors.toList());


        ResPageBean resPageBean = new ResPageBean(postingIPage.size(), collect);
        return resPageBean;
}

    /*获取帖子详情*/
    @Override
    public ResBean getPostingById(Integer id) {

        Posting ps = postMapper.getPostingById(id);
        return ResBean.success("查询成功",ps);
    }

    @Override
    @Transactional
    public ResBean doLike(Integer uid, Integer pid) {
        LocalDate now = LocalDate.now();
       Integer num1 =  postMapper.doLike(uid,pid,now);
       Integer num2 = postMapper.updateLikesNum(pid);
       if (num1 > 0 && num2 > 0){
          return ResBean.success("点赞成功");
       }
       return ResBean.error("点赞失败");

    }

    @Override
    @Transactional
    public ResBean dontLike(Integer uid, Integer pid) {
        Integer num1 =  postMapper.dontLike(uid,pid);
        Integer num2 = postMapper.updateLikesNum2(pid);
        if (num1 > 0 && num2 > 0){
            return ResBean.success("取消点赞成功");
        }
        return ResBean.error("取消点赞失败");
    }

    @Override
    @Transactional
    public ResBean remarkPosting(Comments comments) {
        comments.setTime(new Date());
        int insert = commentMapper.insert(comments);
        int x = postMapper.updateCommentNum(comments.getPostingId());
        if (insert > 0 && x > 0){
            return ResBean.success("评论成功");
        }
        return ResBean.error("评论失败");
    }

    @Override
    public ResBean getMyLike(Integer uid) {
       List<Posting> postingList = postMapper.getMyLike(uid);
        return ResBean.success("查询成功",postingList);
    }

    @Override
    @Transactional
    public ResBean insertPosting(Posting posting) {
        posting.setTime(new Date());
        int insert = postMapper.insert(posting);
        if (posting.getTagsId() != 0){
            Tagpos tagpos = new Tagpos();
            tagpos.setPid(posting.getId());
            tagpos.setTid(posting.getTagsId());
            tagsPosMapper.insert(tagpos);
        }
        if (insert > 0){
            return ResBean.success("发布成功",posting);
        }
        return ResBean.error("发布失败");
    }

    @Override
    public ResPageBean getMyPosting(Integer uid, Integer curPage) {
        List<Posting> postingIPage = postMapper.getMyPosting(uid);
        List<Posting> collect = postingIPage.stream().skip((curPage - 1) * 10).limit(10).collect(Collectors.toList());
        ResPageBean resPageBean = new ResPageBean(postingIPage.size(), collect);
        return resPageBean;
    }

    @Override
    public ResBean getAllTags() {
        List<Tags> tagsList = tagsMapper.selctAll();

        return ResBean.success("查询成功",tagsList);
    }

    @Override
    @Transactional
    public ResBean delPosting(Integer pid) {
        int id = postMapper.deleteById(pid);
        tagsPosMapper.deleteByIds(pid);
        commentMapper.deleteComments(pid);
        likesMapper.deleteLikes(pid);
        return ResBean.success("删除成功");
    }

    @Override
    public ResBean getMyComPostin(Integer uid) {
        List<Posting> postingList= postMapper.getMyComPosting(uid);
        return ResBean.success("查询成功",postingList);
    }

    @Override
    @Transactional
    public ResBean delComment(Integer cid,Integer pid) {
        int i = commentMapper.deleteById(cid);
        int m = postMapper.updateCommentNum2(pid);
        if (i > 0 && m > 0){
            return ResBean.success("删除成功");
        }
        return ResBean.success("删除失败");
    }
}
