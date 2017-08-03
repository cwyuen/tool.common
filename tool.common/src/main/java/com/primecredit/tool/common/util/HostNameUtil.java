package com.primecredit.tool.common.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostNameUtil {

	public static String getMachineHostName() {
		String hostname = "Unknown";

		try
		{
		    InetAddress addr;
		    addr = InetAddress.getLocalHost();
		    hostname = addr.getHostName();
		}
		catch (UnknownHostException ex)
		{
		   
		}
		
		return hostname;
	}
}
