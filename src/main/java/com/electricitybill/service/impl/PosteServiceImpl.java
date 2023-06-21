package com.electricitybill.service.impl;

import com.electricitybill.entity.PosteEntity;
import com.electricitybill.repository.PosteRepository;
import com.electricitybill.service.PosteService;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class PosteServiceImpl implements PosteService {

    private final PosteRepository posteRepository;

    @Override
    public List<PosteEntity> findAll() {
        return posteRepository.findAll();
    }

    @Override
    public PosteEntity findById(int id) {
        return posteRepository.findById(id);
    }

    @Override
    public PosteEntity save(PosteEntity entity) {
        return posteRepository.save(entity);
    }

    @Override
    public boolean update(int id, PosteEntity entity) throws SQLException {
        return posteRepository.update(id, entity);
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return posteRepository.delete(id);
    }
}
