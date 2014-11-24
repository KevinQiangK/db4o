/* Copyright (C) 2008  Versant Inc.  http://www.db4o.com */

package com.db4o.db4ounit.common.cs.config;

import com.db4o.*;
import com.db4o.config.*;
import com.db4o.cs.*;
import com.db4o.cs.config.*;
import com.db4o.ext.*;

import db4ounit.*;
import db4ounit.extensions.*;
import db4ounit.mocking.*;

/**
 * @sharpen.remove
 */
public class ClientServerConfigurationTestCase extends AbstractDb4oTestCase{
	
	protected void configure(Configuration config) throws Exception {
		// Just make sure no exception is thrown when
		// Class.forName() runs in DotNetSupport. 
		config.add(new DotnetSupport(true));
	}
	
	public void testDotNetSupport(){
		// For now: Just make sure a database file is opened.
		Assert.isTrue(true);
	}
	
	static final class ClientServerFactoryStub extends MethodCallRecorder implements ClientServerFactory {
		public ObjectContainer openClient(ClientConfiguration config,
				String hostName, int port, String user, String password) throws Db4oIOException,
				OldFormatException, InvalidPasswordException {
			
			record(new MethodCall("openClient", new Object[] { config, hostName, port, user, password }));
			return null;
		}

		public ObjectServer openServer(ServerConfiguration config,
				String databaseFileName, int port) throws Db4oIOException,
				IncompatibleFileFormatException, OldFormatException,
				DatabaseFileLockedException, DatabaseReadOnlyException {
			
			record(new MethodCall("openServer", new Object[] { config, databaseFileName, port }));
			return null;
		}
	}
	

	public void testOpenServer() {
		final ClientServerFactoryStub factoryStub = new ClientServerFactoryStub();
		
		final ServerConfiguration config = Db4oClientServer.newServerConfiguration();
		config.networking().clientServerFactory(factoryStub);
		
		Assert.isNull(Db4oClientServer.openServer(config, "file.db4o", 0xdb40));
		
		factoryStub.verify(new MethodCall[] {
			new MethodCall("openServer", new Object[] { MethodCall.IGNORED_ARGUMENT, "file.db4o", 0xdb40 }),
		});
	}

	
	public void testOpenClient() {

		final ClientServerFactoryStub factoryStub = new ClientServerFactoryStub();
		
		final ClientConfiguration config = Db4oClientServer.newClientConfiguration();
		config.networking().clientServerFactory(factoryStub);
		
		Assert.isNull(Db4oClientServer.openClient(config, "foo", 42, "u", "p"));
		
		factoryStub.verify(new MethodCall[] {
			new MethodCall("openClient", new Object[] { MethodCall.IGNORED_ARGUMENT, "foo", 42, "u", "p" }),
		});
	}

}
