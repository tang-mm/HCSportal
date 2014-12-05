package com.example.hcsweb.service.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hcsweb.dao.TenantDao;
import com.example.hcsweb.model.Tenant;
import com.example.hcsweb.service.TenantService;
 

@Service("tenantService")
@Transactional
public class TenantServiceImpl implements TenantService{

	@Autowired
	private TenantDao tenantDao;

	@Override
	public Tenant findTenantById(int id) throws HibernateException {
		Tenant tenant = tenantDao.getById(new Integer(id));
		if (tenant == null)
			throw new HibernateException("Tenant not found: id = "+ id);
		return tenant;
	}

	@Override
	public Tenant findTenantByName(String tenantName) throws HibernateException {
		Tenant tenant = tenantDao.getTenantByName(tenantName);
		if (tenant == null)
			throw new HibernateException("Tenant not found: name = "+ tenantName);
		return tenant;
	}

	@Override
	public void saveTenant(Tenant tenant) {
		tenantDao.saveOrUpdate(tenant);
	}

	@Override
	public void deleteTenant(int id) throws HibernateException {
		tenantDao.delete(new Integer(id));
	}

	@Override
	public List<Tenant> getAllTenants() {
		return tenantDao.getAll();
	}

	@Override
	public List<Tenant> findTenantsByCustomerId(int custId) {
		return tenantDao.findTenantsByCustomerId(custId);
	}
 
	
	
	/* ******** OTHERS ********************/
	/**
	 * obtain the IP address for a specific server
	 * @param suffix
	 * @return
	 * @throws UnknownHostException
	 */
	public String constructServiceIp(Tenant tenant, int suffix) throws UnknownHostException {
		
		int prefixLength = tenant.getPrefixLength();
		String ipMain = tenant.getIpMain();
		
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

	
}
