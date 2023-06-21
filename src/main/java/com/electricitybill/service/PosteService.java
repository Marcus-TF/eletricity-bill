package com.electricitybill.service;

import com.electricitybill.entity.PosteEntity;

import java.sql.SQLException;
import java.util.List;

public interface PosteService {

    List<PosteEntity> findAll();

    PosteEntity findById(int id);

    PosteEntity save(PosteEntity entity);

    boolean update(int id, PosteEntity entity) throws SQLException;

    boolean delete(int id) throws SQLException;
}
