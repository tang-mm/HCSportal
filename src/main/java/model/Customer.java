package model;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.validation.constraints.NotNull;

public class Customer {

	@NotNull
	private String name;
	@NotNull
	private String ipMain;
	@NotNull
	private int prefixLength;

	private String ipFinesseA;
	private String ipFinesseB;
	private String ipCuicA;
	private String ipCuicB;
	private String ipEimwimA;
	private String ipEimwimB;
	private String ipMediasenseA;
	private String ipMediasenseB;
	private String ipScriptEditorA;
	private String ipScriptEditorB;

	private String description;
	
	public Customer() {
	}

	public Customer(String name, String ipMain, int prefixLength) {
		this.setName(name);
		this.setIpMain(ipMain);
		this.setPrefixLength(prefixLength);
	} 
	
	/**
	 * obtain the IP address for a specific server
	 * @param suffix
	 * @return
	 * @throws UnknownHostException
	 */
	public String constructServiceIp(int suffix) throws UnknownHostException {

		if (prefixLength == 24) {
			// replace the last byte
			if (suffix <= 255) {
				String[] strIp = ipMain.split("\\.");
				String newIp = strIp[0] + "." + strIp[1] + "." + strIp[2] + "."
						+ suffix;
				System.out.println(newIp);
				return newIp;
			}
		} else {
			// format ip binary string
			byte[] addr = InetAddress.getByName(ipMain).getAddress();
			for (int i = 0; i < addr.length; i++)
				System.out.println(addr[i]);

			String strIpBinary = "";
			for (byte b : addr) {
				strIpBinary = strIpBinary.concat(Integer.toBinaryString(
						b & 255 | 256).substring(1));
				System.out.println("strIpBinary: " + strIpBinary);
			}

			// format suffix binary string
			String formatPattern = "%" + (32 - prefixLength) + "s";
			String strSuffix = String.format(formatPattern,
					Integer.toBinaryString(suffix)).replace(' ', '0');
			System.out.println("strSuffix: " + strSuffix);

			String strFinalIpBinary = strIpBinary
					.substring(0, prefixLength) + strSuffix;
			System.out.println("strFinalIpBinary: " + strFinalIpBinary);

			String strFinalIp = Integer.parseInt(
					strFinalIpBinary.substring(0, 8), 2)
					+ "."
					+ Integer.parseInt(strFinalIpBinary.substring(8, 16), 2)
					+ "."
					+ Integer.parseInt(strFinalIpBinary.substring(16, 24), 2)
					+ "."
					+ Integer.parseInt(strFinalIpBinary.substring(24, 32), 2); 
			
			return strFinalIp;
		}
		return null; 
	}

	public String getIpMain() {
		return ipMain;
	}

	public void setIpMain(String ipMain) {
		this.ipMain = ipMain;
	}

	public int getPrefixLength() {
		return prefixLength;
	}

	public void setPrefixLength(int prefixLength) {
		this.prefixLength = prefixLength;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIPfinesseA() {
		return ipFinesseA;
	}

	public void setIPfinesseA(String iPfinesseA) {
		ipFinesseA = iPfinesseA;
	}

	public String getIPfinesseB() {
		return ipFinesseB;
	}

	public void setIPfinesseB(String iPfinesseB) {
		ipFinesseB = iPfinesseB;
	}

	public String getIPcuicA() {
		return ipCuicA;
	}

	public void setIPcuicA(String iPcuicA) {
		ipCuicA = iPcuicA;
	}

	public String getIPcuicB() {
		return ipCuicB;
	}

	public void setIPcuicB(String iPcuicB) {
		ipCuicB = iPcuicB;
	}

	public String getIPeimwimA() {
		return ipEimwimA;
	}

	public void setIPeimwimA(String iPeimwimA) {
		ipEimwimA = iPeimwimA;
	}

	public String getIPeimwimB() {
		return ipEimwimB;
	}

	public void setIPeimwimB(String iPeimwimB) {
		ipEimwimB = iPeimwimB;
	}

	public String getIPmediasenseA() {
		return ipMediasenseA;
	}

	public void setIPmediasenseA(String iPmediasenseA) {
		ipMediasenseA = iPmediasenseA;
	}

	public String getIPmediasenseB() {
		return ipMediasenseB;
	}

	public void setIPmediasenseB(String iPmediasenseB) {
		ipMediasenseB = iPmediasenseB;
	}

	public String getIPscriptEditorA() {
		return ipScriptEditorA;
	}

	public void setIPscriptEditorA(String iPscriptEditorA) {
		ipScriptEditorA = iPscriptEditorA;
	}

	public String getIPscriptEditorB() {
		return ipScriptEditorB;
	}

	public void setIPscriptEditorB(String iPscriptEditorB) {
		ipScriptEditorB = iPscriptEditorB;
	}

	public void setDescription(String desc) {
		description = desc;
	}
	
	public String getDescription() {
		return description;
	}
}
