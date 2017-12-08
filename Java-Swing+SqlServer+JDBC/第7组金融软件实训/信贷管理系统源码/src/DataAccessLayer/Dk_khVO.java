package DataAccessLayer;

public class Dk_khVO{
private int khid;
private String name;
private String khzl;
private String khdz;
private String khdh;
private String zjhm;
private String post;
private String email;
private String account;
private String dkje;
private String khhmc;
private String jbhzh;
private String jszh;
private int xypj;
private String sjdw;
private int xdyh;

public Dk_khVO()
{//TODO 生成最初的数据等
	 this.khid=1;
	 this.name="张三";
	 this.khzl="1";
	 this.khdz="1";
	 this.khdh="1";
	 this.zjhm="1";
	 this.post="1";
	 this.email="@126";
	 this.account="1";
	 this.dkje="1";
	 this.khhmc="1";
	 this.jbhzh="1";
	 this.jszh="1";
	 this.xypj=1;
	 this.sjdw="1"; 
	 this.xdyh=1;
	}
public Dk_khVO(
int khid
, String name
, String khzl
, String khdz
, String khdh
, String zjhm
, String post
, String email
, String account
, String dkje
, String khhmc
, String jbhzh
, String jszh
, int xypj
, String sjdw
, int xdyh){
	 this.khid=khid;
	 this.name=name;
	 this.khzl=khzl;
	 this.khdz=khdz;
	 this.khdh=khdh;
	 this.zjhm=zjhm;
	 this.post=post;
	 this.email=email;
	 this.account=account;
	 this.dkje=dkje;
	 this.khhmc=khhmc;
	 this.jbhzh=jbhzh;
	 this.jszh=jszh;
	 this.xypj=xypj;
	 this.sjdw=sjdw; 
	 this.xdyh=xdyh;
}
public int getKhid()
{
	return khid;}
public String getName()
{
	return name;}
public String getKhzl()
{
	return khzl;}
public String getKhdz()
{
	return khdz;}
public String getKhdh()
{
	return khdh;}
public String getZjhm()
{
	return zjhm;}
public String getPost()
{
	return post;}
public String getEmail()
{
	return email;}
public String getAccount()
{
	return account;}
public String getDkje()
{
	return dkje;}
public String getKhhmc()
{
	return khhmc;}
public String getJbhzh()
{
	return jbhzh;}
public String getJszh()
{
	return jszh;}
public int getXypj()
{
	return xypj;}
public String getSjdw()
{
	return sjdw;}
public int getXdyh()
{
	return xdyh;}



//此处开始为SET部分
public void setKhid(int khid)
{
	this.khid=khid;}
public void setName(String name)
{
	this.name=name;}
public void setKhzl(String khzl)
{
	this.khzl=khzl;}
public void setKhdz(String khdz)
{
	this.khdz=khdz;}
public void setKhdh(String khdh)
{
	this.khdh=khdh;}
public void setZjhm(String zjhm)
{
	this.zjhm=zjhm;}
public void setPost(String post)
{
	this.post=post;}
public void setEmail(String email)
{
	this.email=email;}
public void setAccount(String account)
{
	this.account=account;}
public void setDkje(String dkje)
{
	this.dkje=dkje;}
public void setKhhmc(String khhmc)
{
	this.khhmc=khhmc;}
public void setJbhzh(String jbhzh)
{
	this.jbhzh=jbhzh;}
public void setJszh(String jszh)
{
	this.jszh=jszh;}
public void setXypj(int xypj)
{
	this.xypj=xypj;}
public void setSjdw(String sjdw)
{
	this.sjdw=sjdw;}
public void setXdyh(int xdyh)
{
	this.xdyh=xdyh;}
}