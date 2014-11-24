package com.db4o.ta.instrumentation.test.collections;

import java.util.*;

import com.db4o.collections.*;
import com.db4o.internal.*;
import com.db4o.ta.instrumentation.*;
import com.db4o.ta.instrumentation.test.*;

import db4ounit.*;

public class HashMapInstantiationInstrumentationTestCase implements TestCase {

	public void testConstructorIsExchanged() throws Exception {
		Class instrumented = instrument(HashMapFactory.class);
		Object instance = instrumented.newInstance();
		assertReturnsActivatableMap(instance, "createHashMap");
		assertReturnsActivatableMap(instance, "createHashMapWithSize");
		assertReturnsActivatableMap(instance, "createHashMapWithSizeAndLoad");
		assertReturnsActivatableMap(instance, "createHashMapFromMap");
	}
	
	public void testBaseTypeIsExchanged() throws Exception {
		Class instrumented = instrument(MyHashMap.class);
		Map map = (Map)instrumented.newInstance();
		assertActivatableMap(map);
		Map delegateMap = (Map)instrumented.getField("_delegate").get(map);
		assertActivatableMap(delegateMap);
	}

	public void testBaseInvocationIsExchanged() throws Exception {
		Class instrumented = instrument(MyHashMap.class);
		Map map = (Map)instrumented.newInstance();
		map.put("foo", "bar");
		Assert.isTrue(map.containsKey("foo"));
		
		Map delegateMap = (Map)instrumented.getField("_delegate").get(map);
		Assert.isTrue(delegateMap.containsKey("foo"));
		Assert.areEqual("bar", delegateMap.get("foo"));
	}
	
	private void assertActivatableMap(Map delegateMap) {
	    Assert.isInstanceOf(ActivatableHashMap.class, delegateMap);
    }
	
	private void assertReturnsActivatableMap(Object instance, String methodName) {
		Map map = (Map)Reflection4.invoke(instance, methodName);
		assertActivatableMap(map);
	}

	private Class instrument(Class clazz) throws ClassNotFoundException {
		return InstrumentationEnvironment.enhance(clazz, new ReplaceClassOnInstantiationEdit(HashMap.class, ActivatableHashMap.class));
	}
}
