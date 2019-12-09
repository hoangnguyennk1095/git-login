package com.hiber.dao;

import java.util.List;

import com.hiber.entity.Accounts;
import com.hiber.entity.product;




public interface accountDAO {

	List<Accounts> findAll();
Accounts findbyUer(String username);
Accounts creatAccount(Accounts entity);
void update(Accounts entity);
List<Accounts> findAccountCus();
Accounts delete(String username);
}
