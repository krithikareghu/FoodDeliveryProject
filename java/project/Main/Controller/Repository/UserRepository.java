package project.Main.Controller.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import project.Main.Controller.Model.UserData;
@Repository
public interface UserRepository  extends CrudRepository<UserData,Long>
{
	//UserData findByEmail(String email);

}
