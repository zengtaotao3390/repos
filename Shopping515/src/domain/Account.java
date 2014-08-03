package domain;

import java.util.Date;

public class Account {
	private int id;
	private int userid;
	private String accountcode;
	private Date accountdate;
	private int execute;
	private String tel;
	private String email;
	private int num;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	private int goodsId;
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public String getAccountcode() {
		return accountcode;
	}
	public void setAccountcode(String accountcode) {
		this.accountcode = accountcode;
	}
	public Date getAccountdate() {
		return accountdate;
	}
	public void setAccountdate(Date accountdate) {
		this.accountdate = accountdate;
	}
	public int getExecute() {
		return execute;
	}
	public void setExecute(int execute) {
		this.execute = execute;
	}
	

}
