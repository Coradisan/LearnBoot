package com.pkfare.service;

import com.pkfare.entity.ShoppingSolution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 2017/8/18 0018.
 */
@Service
public class SolutionService {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<ShoppingSolution> getResult() {
        String sql = "select * from shoppingsolution where times = 1";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ShoppingSolution.class));
    }

}
