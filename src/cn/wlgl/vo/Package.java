package cn.wlgl.vo;

import java.io.Serializable;
import java.sql.Date;

public class Package implements Serializable {
	private static final long serialVersionUID = 1L;
	private int enumber;
	private int pnumber;
	private String sendaddress;
	private String getaddress;
	private Date sendtime;
	private Date gettime;
	private float money;
	private String phone;
	private boolean sign;

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

	public Date getGettime() {
		return gettime;
	}

	public void setGettime(Date gettime) {
		this.gettime = gettime;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean getSign() {
		return sign;
	}

	public void setSign(boolean sign) {
		this.sign = sign;
	}
}
