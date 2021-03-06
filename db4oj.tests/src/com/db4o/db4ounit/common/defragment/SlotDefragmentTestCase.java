/* Copyright (C) 2006  Versant Inc.  http://www.db4o.com */

package com.db4o.db4ounit.common.defragment;

import java.io.*;

import com.db4o.*;
import com.db4o.config.*;
import com.db4o.defragment.*;
import com.db4o.foundation.*;
import com.db4o.query.*;

import db4ounit.*;

public class SlotDefragmentTestCase extends DefragmentTestCaseBase {
	
	public void testPrimitiveIndex() throws Exception {
		SlotDefragmentFixture.assertIndex(SlotDefragmentFixture.PRIMITIVE_FIELDNAME, sourceFile(), freshDb4oConfigurationProvider());
	}

	public void testWrapperIndex() throws Exception {
	
		SlotDefragmentFixture.assertIndex(
								SlotDefragmentFixture.WRAPPER_FIELDNAME, 
								sourceFile(), 
								freshDb4oConfigurationProvider());
	}

	private Closure4<EmbeddedConfiguration> freshDb4oConfigurationProvider() {
		return new Closure4<EmbeddedConfiguration>() { public EmbeddedConfiguration run() {
			return newConfiguration();
		}};
	}

	public void testTypedObjectIndex() throws Exception {
		SlotDefragmentFixture.forceIndex(sourceFile(), newConfiguration());
		
		Defragment.defrag(newDefragmentConfig(sourceFile(), backupFile()));
		ObjectContainer db=Db4oEmbedded.openFile(newConfiguration(), sourceFile());
		Query query=db.query();
		query.constrain(SlotDefragmentFixture.Data.class);
		query.descend(SlotDefragmentFixture.TYPEDOBJECT_FIELDNAME).descend(SlotDefragmentFixture.PRIMITIVE_FIELDNAME).constrain(new Integer(SlotDefragmentFixture.VALUE));
		ObjectSet result=query.execute();
		Assert.areEqual(1,result.size());
		db.close();
	}


	public void testNoForceDelete() throws Exception {
		Defragment.defrag(newDefragmentConfig(sourceFile(), backupFile()));
		Assert.expect(IOException.class, new CodeBlock() {
			public void run() throws Throwable {
				Defragment.defrag(sourceFile(),backupFile());
			}
		});
	}	

	public void setUp() throws Exception {
		new File(sourceFile()).delete();
		new File(backupFile()).delete();
		SlotDefragmentFixture.createFile(sourceFile(), newConfiguration());
	}
	
	private DefragmentConfig newDefragmentConfig(final String sourceFile, final String backupFile) {
		final DefragmentConfig config = new DefragmentConfig(sourceFile, backupFile);
		config.db4oConfig(newConfiguration());
		
		return config;
	}
}
