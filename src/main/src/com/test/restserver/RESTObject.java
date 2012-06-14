package com.test.restserver;

public class RESTObject<T>
{
	private ListWrapper<T> objects;

	public ListWrapper<T> getObjects()
	{
		return objects;
	}

	public void setObjects(ListWrapper<T> objects)
	{
		this.objects = objects;
	}
}
