package ProjectServer.DataBases.SpringData.Repository;

import ProjectServer.DataBases.SpringData.Entity.TestTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestTableRepository extends JpaRepository<TestTableEntity, Long> {


}
