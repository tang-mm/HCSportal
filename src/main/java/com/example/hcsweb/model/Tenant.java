package com.example.hcsweb.model;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.example.hcsweb.model.users.User;

@Entity
@Table(name="tenants")
public class Tenant implements AbstractBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4807641171888366211L;
	
	/* **************** Attributes *****************/
	@NotNull
	private int tenantId;
	private String tenantName;  
	@NotNull
	private String ipMain;
	private List<Service> listService = new ArrayList<Service>();
	private List<WeeklySchedule> listSchedule = new ArrayList<WeeklySchedule>();
	private List<Equipment> listEquipment = new ArrayList<Equipment>();;
	
	private List<User> listUserAccess = new ArrayList<User>();
	private Customer customer;
	
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

	/* **************** Constructors *****************/
	public Tenant() {
	}

	public Tenant(String name, String ipMain, String desc ) {
		this.setTenantName(name);
		this.setIpMain(ipMain);
		this.setDescription(desc);
//		this.setPrefixLength(prefixLength);
	}  



	/* **************** Getters and Setters*****************/
	@Id
	@Column (name = "tenant_id")
	@GeneratedValue
	public int getTenantId() {
		return tenantId;
	}

	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}
	
	@Column (name = "tenant_name")
	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String name) {
		this.tenantName = name;
	}
	
	@Column (name = "description")
	public String getDescription() {
		return description;
	} 
	public void setDescription(String desc) {
		description = desc;
	}

	@ManyToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name = "customer_id")
    @LazyCollection(LazyCollectionOption.TRUE)
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	} 

	@Column (name = "ip_address")
	public String getIpMain() {
		return ipMain;
	}

	public void setIpMain(String ipMain) {
		this.ipMain = ipMain;
	}

    @OneToMany(mappedBy = "tenant")
	public List<Service> getListService() {
		return listService;
	}

	public void setListService(List<Service> listService) {
		this.listService = listService;
	} 

    @OneToMany(mappedBy = "tenant")
	public List<WeeklySchedule> getListSchedule() {
		return listSchedule;
	}

	public void setListSchedule(List<WeeklySchedule> listSchedule) {
		this.listSchedule = listSchedule;
	}

    @OneToMany(mappedBy = "tenant")
	public List<Equipment> getListEquipment() {
		return listEquipment;
	}

	public void setListEquipment(List<Equipment> listEquipment) {
		this.listEquipment = listEquipment;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "listTenant")
	public List<User> getListUserAccess() {
		return listUserAccess;
	}

	public void setListUserAccess(List<User> listUserAccess) {
		this.listUserAccess = listUserAccess;
	}

	/* ************ NOT mapped ******************/ 
	@Transient
	public int getPrefixLength() {
		return prefixLength;
	}

	public void setPrefixLength(int prefixLength) {
		this.prefixLength = prefixLength;
	}

	@Transient
	public String getIPfinesseA() {
		return ipFinesseA;
	}

	public void setIPfinesseA(String iPfinesseA) {
		ipFinesseA = iPfinesseA;
	}

	@Transient
	public String getIPfinesseB() {
		return ipFinesseB;
	}

	public void setIPfinesseB(String iPfinesseB) {
		ipFinesseB = iPfinesseB;
	}

	@Transient
	public String getIPcuicA() {
		return ipCuicA;
	}

	public void setIPcuicA(String iPcuicA) {
		ipCuicA = iPcuicA;
	}

	@Transient
	public String getIPcuicB() {
		return ipCuicB;
	}

	public void setIPcuicB(String iPcuicB) {
		ipCuicB = iPcuicB;
	}

	@Transient
	public String getIPeimwimA() {
		return ipEimwimA;
	}

	public void setIPeimwimA(String iPeimwimA) {
		ipEimwimA = iPeimwimA;
	}

	@Transient
	public String getIPeimwimB() {
		return ipEimwimB;
	}

	public void setIPeimwimB(String iPeimwimB) {
		ipEimwimB = iPeimwimB;
	}

	@Transient
	public String getIPmediasenseA() {
		return ipMediasenseA;
	}

	public void setIPmediasenseA(String iPmediasenseA) {
		ipMediasenseA = iPmediasenseA;
	}

	@Transient
	public String getIPmediasenseB() {
		return ipMediasenseB;
	}

	public void setIPmediasenseB(String iPmediasenseB) {
		ipMediasenseB = iPmediasenseB;
	}

	@Transient
	public String getIPscriptEditorA() {
		return ipScriptEditorA;
	}

	public void setIPscriptEditorA(String iPscriptEditorA) {
		ipScriptEditorA = iPscriptEditorA;
	}

	@Transient
	public String getIPscriptEditorB() {
		return ipScriptEditorB;
	}

	public void setIPscriptEditorB(String iPscriptEditorB) {
		ipScriptEditorB = iPscriptEditorB;
	}

	
}
