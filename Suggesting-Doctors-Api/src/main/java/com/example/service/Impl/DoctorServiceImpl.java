package com.example.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Doctor;
import com.example.repository.DoctorRepository;
import com.example.service.DoctorService;

import jakarta.validation.Valid;
@Service
public class DoctorServiceImpl implements DoctorService
{
 @Autowired private DoctorRepository dr;

@Override
public void saveDoctor(@Valid Doctor doc) 
{
	dr.save(doc);
}



}
