package com.example.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student.entity.ImageMasterEntity;
import com.example.student.entity.StudentEntity;

@Repository
public interface ImageMasterMasterRepository extends JpaRepository<ImageMasterEntity,Long> {

	List<ImageMasterEntity> findByStudentId(StudentEntity studentId);
}
