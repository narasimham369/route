package com.route21.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.route21.ws.bean.UserLogin;

/**
 * 
 * This is user login repository interface.
 * 
 * It extends JpaRepository.
 * 
 * It has queries which is used to get data base values.
 * 
 * It has abstract methods which are implemented in another class.
 * 
 * @author admin-pc
 *
 */
public interface UserLoginRepository extends JpaRepository<UserLogin, Long>{

	@Query(value="SELECT ul FROM UserLogin ul WHERE ul.loginId=:loginId and ul.loginPassword=:loginPass")
	public UserLogin findUserLogin(@Param("loginId")String loginId,@Param("loginPass")String loginPass);
	
	public UserLogin findByLoginId(String loginId);

	@Query(value="SELECT user FROM UserLogin user WHERE user.loginId=:email")
	public UserLogin findEmailExist(@Param("email")String email);
	
	@Query(value="SELECT us FROM UserLogin us WHERE us.loginId=:loginId and us.verifyCode=:verifyCode")
	public UserLogin findUserByIdandVerifycode(@Param("loginId")String loginId,@Param("verifyCode")String verifyCode);
	
	@Query("SELECT ul FROM UserLogin ul WHERE ul.party.id=:id")
	public UserLogin findByPartyId(@Param("id") Long id);
}
