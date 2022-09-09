/*
package com.localweb.thelogin.thelogin.dao;

import com.localweb.thelogin.thelogin.entities.Role;
import com.localweb.thelogin.thelogin.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query("select r from Role r where r.user=?1")
    Role findRoleByUser(User user);

}
*/
