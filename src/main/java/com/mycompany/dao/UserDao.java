package com.mycompany.dao;

import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.pojo.User;
import com.mycompany.util.SecurityUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Transactional
@Repository
public class UserDao extends AbstractGenericDao<User> implements IUserDao{

    @PersistenceContext
    private EntityManager em;	
	
	@Override
	public List<User> findAll() {
        String hql = "Select * from users";
        Query query = em.createQuery(hql);
        return query.getResultList();
	}
	
	@Override
	public void setDefaults(User user) {
		user.setEmail("someEmail@email.com");
		hashAndSaltUserPassword(user);
	}
	private void hashAndSaltUserPassword(final User user)
	{
		// need to think about a more appropriate way to deal with this
		// I want to freely set my user's password, but I don't want to accidentally hash an already hashed pw
		Map<String, String> credMap = SecurityUtil.hashPassword(user.getPassword());
		
		user.setPassword(credMap.get(SecurityUtil.HASHED_PASSWORD_KEY));
		user.setSalt(credMap.get(SecurityUtil.SALT_KEY));
		
		credMap.clear();
	}
}
