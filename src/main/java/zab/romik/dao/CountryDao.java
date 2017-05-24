package zab.romik.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import zab.romik.entity.Counrty;

public interface CountryDao extends JpaRepository<Counrty, Integer> {
//	Counrty  findByName(String name);
//    @Query("select  r from Country r left join fetch r.commodity where r.id=:id")
//	List<Commodity>  findCountryWithCommodity(@Param("id")int id);
}
