package stage.etude.ilefinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import stage.etude.ilefinfo.model.LogoDB;
@Repository
public interface LogoDBRepository extends JpaRepository<LogoDB, String> {

}
