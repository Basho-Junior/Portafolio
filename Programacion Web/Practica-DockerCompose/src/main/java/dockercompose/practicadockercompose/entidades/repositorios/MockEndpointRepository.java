package dockercompose.practicadockercompose.entidades.repositorios;

import dockercompose.practicadockercompose.entidades.MockEndpoint;
import dockercompose.practicadockercompose.entidades.composite.MockEndpointPK;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;

public interface MockEndpointRepository  extends CrudRepository<MockEndpoint, MockEndpointPK> {
    public void deleteAllByExpirationLessThan(Timestamp now);
}
