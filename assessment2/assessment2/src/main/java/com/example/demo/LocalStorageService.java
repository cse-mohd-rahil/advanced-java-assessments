package com.example.demo;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("localStorage")
@Scope("singleton")
@Lazy
public class LocalStorageService implements StorageService{
	public LocalStorageService() {
		System.out.println("LocalStorageService Bean Created");
	}

	@Override
	public void storeFile(String fileName) {
		System.out.println("File stored in local storage: "+fileName);
	}
	

}
