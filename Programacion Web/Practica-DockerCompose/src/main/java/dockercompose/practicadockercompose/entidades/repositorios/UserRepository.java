package dockercompose.practicadockercompose.entidades.repositorios;

import dockercompose.practicadockercompose.entidades.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}
