package com.gbq.axs.axsxcs.service;

import com.gbq.axs.axsxcs.pojo.Comments;
import com.gbq.axs.axsxcs.pojo.Posting;
import com.gbq.axs.axsxcs.pojo.ResBean;
import com.gbq.axs.axsxcs.pojo.ResPageBean;

import java.util.List;

public interface PostService {

     ResPageBean getAllPosting1(Integer currentPage) ;


     ResBean getPostingById(Integer id);

     ResBean doLike(Integer uid, Integer pid);

     ResBean dontLike(Integer uid, Integer pid);

     ResBean remarkPosting(Comments comments);

     ResBean getMyLike(Integer uid);

    ResBean insertPosting(Posting posting);

     ResPageBean getMyPosting(Integer uid, Integer curPage);

    ResBean getAllTags();

    ResBean delPosting(Integer pid);

    ResBean getMyComPostin(Integer uid);

    ResBean delComment(Integer cid,Integer pid);
}
