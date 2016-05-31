package com.liferay.bnd.test.impl;

import org.osgi.service.component.annotations.Component;

import com.liferay.bnd.test.api.ExampleProviderInterface;

@Component(immediate=true)
public class ExampleProviderImpl implements ExampleProviderInterface {

	@Override
	public String provide(String key) {
		return "foo".equals(key) ? "bar" : "null";
	}

}
