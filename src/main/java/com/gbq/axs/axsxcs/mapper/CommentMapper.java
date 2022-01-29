package com.gbq.axs.axsxcs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gbq.axs.axsxcs.pojo.Comments;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentMapper extends BaseMapper<Comments> {
    void deleteComments(Integer pid);
}
