package com.example.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Doctor;
import com.example.entity.Patient;
import com.example.exception.patientNotFoundException;
import com.example.repository.DoctorRepository;
import com.example.repository.PatientRepository;
import com.example.service.PatientService;
import com.example.utility.Symptom;

import jakarta.validation.Valid;
@Service
public class PatientServiceImpl implements PatientService
{
 @Autowired private PatientRepository pr;
 @Autowired private DoctorRepository dr;

@Override
public void saveDoctor(@Valid Patient pat) 
{
pr.save(pat);	
}



@Override
public List<Doctor> findDoctorListByPatientId(int pid)
{
	Patient pat=pr.findById(pid).orElse(null);
	if(pat==null)
	{
		throw new patientNotFoundException("Patient with id "+pid+" does not exist");
	}
	
	
	String city=pat.getCity();
	if(!(city.equals("Noida")||city.equals("Delhi")|| city.equals("Faridabad")))
	{
		throw new RuntimeException("We are still waiting to expand to your location");
	}
	
	
	String symptom=pat.getSymptom();
	String speciality= Symptom.map.get(symptom);
	List<Doctor> doclist=dr.getDoctorListBySpeciality(speciality,city);
	if(doclist.isEmpty()) 
	{
		throw new RuntimeException("“There isn’t any doctor present at your location for your symptom”");

	}
	return doclist;
 }
}
