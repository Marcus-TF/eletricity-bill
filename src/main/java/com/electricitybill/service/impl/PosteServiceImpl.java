package com.electricitybill.service.impl;

import com.electricitybill.entity.PosteEntity;
import com.electricitybill.repository.PosteRepository;
import com.electricitybill.service.PosteService;
import jakarta.persistence.NoResultException;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class PosteServiceImpl implements PosteService {

    private final PosteRepository posteRepository;

    @Override
    public List<PosteEntity> findAll() {
        if (posteRepository.findAll().isEmpty()) {
            return new ArrayList<>();
        }
        return posteRepository.findAll();
    }

    @Override
    public PosteEntity findById(int id) {
        if (Objects.isNull(posteRepository.findById(id))) {
            throw new NoResultException("Individual search not found!");
        }
        return posteRepository.findById(id);
    }

    @Override
    public PosteEntity save(PosteEntity entity) {
        return posteRepository.save(entity);
    }

    @Override
    public boolean update(int id, PosteEntity entity) throws SQLException {
        if (Objects.isNull(posteRepository.findById(id))) {
            throw new NoResultException("Post not found!");
        }
        return posteRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        if (Objects.isNull(posteRepository.findById(id))) {
            throw new NoResultException("Post not found!");
        }
        return posteRepository.delete(id);
    }
}
