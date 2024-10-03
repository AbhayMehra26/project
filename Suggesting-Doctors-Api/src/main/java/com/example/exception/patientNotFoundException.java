package com.example.exception;

public class patientNotFoundException extends RuntimeException
{
	public patientNotFoundException(String msg)
	{
		super(msg);
	}
}

