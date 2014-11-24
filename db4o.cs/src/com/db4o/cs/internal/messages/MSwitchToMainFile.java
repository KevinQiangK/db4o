/* Copyright (C) 2007  Versant Inc.  http://www.db4o.com */

package com.db4o.cs.internal.messages;

import com.db4o.cs.internal.*;


/**
 * @exclude
 */
public class MSwitchToMainFile extends Msg implements ServerSideMessage {

	public void processAtServer() {
		ServerMessageDispatcher serverThread = serverMessageDispatcher();
		serverThread.switchToMainFile();
	}
}
