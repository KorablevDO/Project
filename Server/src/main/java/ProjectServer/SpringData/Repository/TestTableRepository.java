package ProjectServer.SpringData.Repository;

import ProjectServer.SpringData.Entity.TestTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 1 on 18.02.2018.
 */
public interface TestTableRepository extends JpaRepository<TestTableEntity, Long> {
}
