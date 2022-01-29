package com.gbq.axs.axsxcs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gbq.axs.axsxcs.pojo.Likes;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesMapper extends BaseMapper<Likes> {
    void deleteLikes(Integer pid);
}
