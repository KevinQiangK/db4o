/* Copyright (C) 2004 - 2006 Versant Inc. http://www.db4o.com */

package com.db4o.instrumentation.bloat;

import EDU.purdue.cs.bloat.editor.*;

import com.db4o.instrumentation.api.*;
import com.db4o.instrumentation.util.*;

public class BloatTypeRef extends BloatRef implements TypeRef {
	
	public static Type[] bloatTypes(TypeRef[] types) {
		Type[] result = new Type[types.length];
		for (int i=0; i<types.length; ++i) {
			result[i] = bloatType(types[i]);
		}
		return result;
	}

	public static Type bloatType(TypeRef type) {
		return ((BloatTypeRef)type).type();
	}

	private final Type _type;
	
	BloatTypeRef(BloatReferenceProvider provider, Type type) {
		super(provider);
		_type = type;
	}

	public Type type() {
		return _type;
	}

	public TypeRef elementType() {
		return typeRef(_type.elementType());
	}

	public boolean isPrimitive() {
		return _type.isPrimitive();
	}

	public String name() {
		if (isPrimitive()) {
			return primitiveName();
		}
		return BloatUtil.normalizeClassName(_type);
	}
	
	private String primitiveName() {
		switch (_type.className().charAt(0)) {
		case Type.ARRAY_CHAR:
			return elementType().name() + "[]";
		case Type.CHARACTER_CHAR:
			return "char";
		case Type.BYTE_CHAR:
			return "byte";
		case Type.SHORT_CHAR:
			return "short";
		case Type.INTEGER_CHAR:
			return "int";
		case Type.LONG_CHAR:
			return "long";
		case Type.BOOLEAN_CHAR:
			return "boolean";
		case Type.FLOAT_CHAR:
			return "float";
		case Type.DOUBLE_CHAR:
			return "double";
		}
		throw new IllegalStateException();
	}

	public String toString() {
		return name();
	}
}
