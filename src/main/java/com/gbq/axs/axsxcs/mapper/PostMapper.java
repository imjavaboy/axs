package com.gbq.axs.axsxcs.mapper;

import com.gbq.axs.axsxcs.pojo.Posting;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostMapper {
    public List<Posting> getAllPosting(Posting posting);
}
