package com.test.restserver;

public class RESTChildObject<T>
{
	private ListWrapper<T> someList;

	public ListWrapper<T> getSomeList()
	{
		return someList;
	}

	public void setSomeList(ListWrapper<T> someList)
	{
		this.someList = someList;
	}

}
