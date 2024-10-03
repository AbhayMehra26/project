package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>
{
@Query("from Doctor where speciality=:arg1 and city=:arg2")
	List<Doctor> getDoctorListBySpeciality(@Param("arg1")String speciality, @Param("arg2")String city);

}
