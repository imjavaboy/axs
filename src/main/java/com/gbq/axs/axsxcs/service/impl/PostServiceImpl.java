package com.gbq.axs.axsxcs.service.impl;

import com.gbq.axs.axsxcs.mapper.PostMapper;
import com.gbq.axs.axsxcs.pojo.Posting;
import com.gbq.axs.axsxcs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Override
    public List<Posting> grtAllPosting(Posting posting) {
        return postMapper.getAllPosting(posting);
    }
}
