package com.test.restserver;

import java.util.List;

public class RESTObject<T>
{
	private List<T> objects;

	public List<T> getObjects()
	{
		return objects;
	}

	public void setObjects(List<T> objects)
	{
		this.objects = objects;
	}
	
}
