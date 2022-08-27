package com.vivek.crud.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vivek.crud.model.Master;

@Repository
public interface MasterRepository extends JpaRepository<Master, Long>{

}
