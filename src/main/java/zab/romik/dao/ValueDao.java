package zab.romik.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import zab.romik.entity.Valuess;

public interface ValueDao extends JpaRepository<Valuess, Integer> {

}
