package com.vivek.crud.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vivek.crud.model.Master;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface MasterRepository extends JpaRepository<Master, Long>{
  @Query("select m from Master m where lower(m.name) like lower(concat('%', :nameToFind,'%'))")
	List<Master> findByNameLike(@Param("nameToFind") String name);
}
