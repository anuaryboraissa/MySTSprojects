package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException {
 private String resource_name;
 private String field;
 private Object value;
public ResourceNotFound(String resource_name, String field, Object value) {
	super(String.format("Data is not found....", resource_name,field,value));
	this.resource_name = resource_name;
	this.field = field;
	this.value = value;
}

public String getResource_name() {
	return resource_name;
}

public String getField() {
	return field;
}

public Object getValue() {
	return value;
}

}
