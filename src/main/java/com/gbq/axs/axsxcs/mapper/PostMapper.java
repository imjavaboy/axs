package com.gbq.axs.axsxcs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gbq.axs.axsxcs.pojo.Account;
import com.gbq.axs.axsxcs.pojo.Posting;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@Mapper
public interface PostMapper extends BaseMapper<Posting> {


   List<Posting> getAllPosting();

    Posting getPostingById(Integer id);

    Integer doLike(@Param("uid") Integer uid, @Param("pid") Integer pid, @Param("now")LocalDate now);

    Integer updateLikesNum(Integer pid);

    Integer dontLike(@Param("uid") Integer uid, @Param("pid") Integer pid);

    Integer updateLikesNum2(Integer pid);

    Integer updateCommentNum(Integer postingId);

 List<Posting> getMyLike(Integer uid);

    List<Posting> getMyPosting(Integer uid);

    List<Posting> getMyComPosting(Integer uid);

    Integer updateCommentNum2(Integer pid);
}
