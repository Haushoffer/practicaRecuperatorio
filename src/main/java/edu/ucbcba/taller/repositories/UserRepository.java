package edu.ucbcba.taller.repositories;

import edu.ucbcba.taller.entities.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by coreI7 on 30/04/2017.
 */
@Transactional
public interface UserRepository extends CrudRepository<User,Integer> {
}
