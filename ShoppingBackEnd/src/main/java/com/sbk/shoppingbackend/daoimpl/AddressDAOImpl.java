package com.sbk.shoppingbackend.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sbk.shoppingbackend.dao.AddressDAO;
import com.sbk.shoppingbackend.dto.Address;

@Repository("addressDAO")
@Transactional
public class AddressDAOImpl implements AddressDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addAddress(Address address) {
		
		try {
			sessionFactory.getCurrentSession().persist(address);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			}
	}

	

}
