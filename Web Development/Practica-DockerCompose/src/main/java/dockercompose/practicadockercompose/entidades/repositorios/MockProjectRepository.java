package dockercompose.practicadockercompose.entidades.repositorios;

import dockercompose.practicadockercompose.entidades.MockProject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MockProjectRepository extends CrudRepository<MockProject, String> {
    public List<MockProject> findAllByUsuarioId(String usuarioId);

    public Boolean existsByIdAndUsuarioId(String id, String usuarioId);
}
