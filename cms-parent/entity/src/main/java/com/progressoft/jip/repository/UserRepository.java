package com.progressoft.jip.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.progressoft.jip.entity.UserEntity;
import com.progressoft.jip.entity.view.UserView;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {
	public static final String LOGIN_QUERY = "select u from UserEntity u where u.userName=:userName and u.password=:password";

	<U extends UserView> U findByUserName(String userName);

	@Query(LOGIN_QUERY)
	UserEntity login(@Param("userName") String userName, @Param("password") String password);
}
