package model;

import java.util.Objects;

public class Conexion {

	private String sHost, sDbName, sUsername, sUserpass;
	private int iPort;
	
	public Conexion() {
		this.sHost = "";
		this.sDbName = "";
		this.sUsername = "";
		this.sUserpass = "";
		this.iPort = -1;
	}
	
	public Conexion(String sHost, String sDbName, String sUsername, String sUserpass, int iPort) {
		setsHost(sHost);
		setsDbName(sDbName);
		setsUsername(sUsername);
		setsUserpass(sUserpass);
		setiPort(iPort);
	}


	public String getsHost() {
		return sHost;
	}


	public void setsHost(String sHost) {
	
		if (sHost == null) {
			this.sHost = "127.0.0.1";
		} else {
			this.sHost = sHost;
		}
	}


	public String getsDbName() {
		return sDbName;
	}


	public void setsDbName(String sDbName) {
		
		if (sDbName == null) {
			this.sHost = "ORCL";
		} else {
			this.sDbName = sDbName;
		}
	}


	public String getsUsername() {
		return sUsername;
	}


	public void setsUsername(String sUsername) {
		if (sUsername == null) {
			this.sHost = "123456";
		} else {
			this.sUsername = sUsername;
		}
	}


	public String getsUserpass() {
		return sUserpass;
	}


	public void setsUserpass(String sUserpass) {
		this.sUserpass = sUserpass;
	}


	public int getiPort() {
		return iPort;
	}


	public void setiPort(int iPort) {
		this.iPort = iPort;
	}


	@Override
	public int hashCode() {
		return Objects.hash(iPort, sDbName, sHost, sUsername, sUserpass);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conexion other = (Conexion) obj;
		return iPort == other.iPort && Objects.equals(sDbName, other.sDbName) && Objects.equals(sHost, other.sHost)
				&& Objects.equals(sUsername, other.sUsername) && Objects.equals(sUserpass, other.sUserpass);
	}


	@Override
	public String toString() {
		return "Conexion [sHost=" + sHost + ", sDbName=" + sDbName + ", sUsername=" + sUsername + ", sUserpass="
				+ sUserpass + ", iPort=" + iPort + "]";
	}
	
	
	
	
}
