package com.test.restserver;

import java.util.List;

public class RESTChildObject<T>
{
	private List<T> someList;

	public List<T> getSomeList()
	{
		return someList;
	}

	public void setSomeList(List<T> someList)
	{
		this.someList = someList;
	}

}
