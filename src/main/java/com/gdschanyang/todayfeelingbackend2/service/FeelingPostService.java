package com.gdschanyang.todayfeelingbackend2.service;

import com.gdschanyang.todayfeelingbackend2.domain.posts.FeelingPost;
import com.gdschanyang.todayfeelingbackend2.repository.FeelingPostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class FeelingPostService {
    private final FeelingPostRepository feelingPostRepository;

    public FeelingPostService(FeelingPostRepository feelingPostRepository) {
        this.feelingPostRepository = feelingPostRepository;
    }

    @Transactional
    public void save(FeelingPost feelingPost) {
        feelingPostRepository.save(feelingPost);
    }

    @Transactional
    public void update(Long id, FeelingPost feelingPost) {
        FeelingPost feelingPostEntity = feelingPostRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        feelingPostEntity.update(feelingPost.getContent());
    }

    @Transactional
    public FeelingPost findById(Long id) {
        FeelingPost feelingPost = feelingPostRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        return feelingPost;
    }

    @Transactional
    public void delete(Long id) {
        FeelingPost feelingPost = feelingPostRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        feelingPostRepository.delete(feelingPost);
    }



}
