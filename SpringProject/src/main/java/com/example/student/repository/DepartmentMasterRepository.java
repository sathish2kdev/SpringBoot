package com.example.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.student.entity.DepartmentMasterEntity;

@Repository
public interface DepartmentMasterRepository extends JpaRepository<DepartmentMasterEntity, Long>{

	@Query(value = "select department_name from departmant_master WHERE status='active';",nativeQuery = true)
	List<String> getDepartmentname();
	
	@Query(value = "select * from departmant_master WHERE status='active' and department_name =:name ;",nativeQuery = true)
	DepartmentMasterEntity getDepartmentDetails(@Param("name") String name);
}
