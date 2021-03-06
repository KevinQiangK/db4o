/* Copyright (C) 2004 - 2006  Versant Inc.  http://www.db4o.com */

package com.db4o.config.annotations.reflect;

/**
 * @exclude
 * @sharpen.ignore
 */
@decaf.Ignore(unlessCompatible=decaf.Platform.JDK15)
public class MaximumActivationDepthConfigurator extends Db4oConfigurator {
	private String _className;

	private int _max;

	public MaximumActivationDepthConfigurator(String name, int max) {
		this._className = name;
		this._max =max;
	}

	@Override
	protected void configure() {
		objectClass(_className).maximumActivationDepth(_max);
	}

}
