package cn.wlgl.vo;

import java.sql.Date;

public class NewPackage {
	private int enumber;
	private int pnumber;
	private String sendaddress;
	private String getaddress;
	private Date sendtime;
	private String phone;

	public int getEnumber() {
		return enumber;
	}

	public void setEnumber(int enumber) {
		this.enumber = enumber;
	}

	public int getPnumber() {
		return pnumber;
	}

	public void setPnumber(int pnumber) {
		this.pnumber = pnumber;
	}

	public String getSendaddress() {
		return sendaddress;
	}

	public void setSendaddress(String sendaddress) {
		this.sendaddress = sendaddress;
	}

	public String getGetaddress() {
		return getaddress;
	}

	public void setGetaddress(String getaddress) {
		this.getaddress = getaddress;
	}

	public Date getSendtime() {
		return sendtime;
	}

	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
