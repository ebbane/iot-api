package project.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.iot.model.Temperature;

@Repository
public interface TempRepository extends JpaRepository<Temperature, Long> {

}
