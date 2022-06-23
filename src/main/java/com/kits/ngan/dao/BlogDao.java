package com.kits.ngan.dao;

import java.util.List;

public interface BlogDao<T> {
	T findOne(int id);
	List<T> findAll();
	List<T> find(T arg);
	int insert(T arg);
	void update(T arg);
	void delete(int id);
}