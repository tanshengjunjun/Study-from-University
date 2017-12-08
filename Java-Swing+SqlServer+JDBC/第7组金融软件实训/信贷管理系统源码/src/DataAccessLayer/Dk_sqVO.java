package DataAccessLayer;
import java.util.*;

public class Dk_sqVO{
private int dk_sqh;//贷款申请号：自动生成 10:yyyymmdd00
private int dkkhid;
private String dkzl;
private String dkxz;
private String dkyt;
private String dkfw;
private String dkdyp;
private float dypje;//!!将金额类型全部改成了float类型，方便SQL中存储
private int dbrid;
private float dkje;
private int zcglid;


private String sqrq;
private String sprq;
private int fdbz;
private int sprid;
private String dkzh;
private String dkhth;
private float dkhtje;
private float dkhtll;//利率
private String hkfs;//还款方式
private float mqhkje;
private int dcxdyid;

public Dk_sqVO()
{//TODO 生成最初的数据等
	}

public void setDk_sqh(int dk_sqh)
{
	this.dk_sqh=dk_sqh;}
public void setDkkhid(int dkkhid)
{
	this.dkkhid=dkkhid;}
public void setDkzl(String dkzl)
{
	this.dkzl=dkzl;}
public void setDkxz(String dkxz)
{
	this.dkxz=dkxz;}
public void setDkyt(String dkyt)
{
	this.dkyt=dkyt;}
public void setDkfw(String dkfw)
{
	this.dkfw=dkfw;}
public void setDkdyp(String dkdyp)
{
	this.dkdyp=dkdyp;}
public void setDypje(float dypje)
{
	this.dypje=dypje;}
public void setDbrid(int dbrid)
{
	this.dbrid=dbrid;}
public void setDkje(float dkje)
{
	this.dkje=dkje;}
public void setZcglid(int zcglid)
{
	this.zcglid=zcglid;}
public void setSqrq(String sqrq)
{
	this.sqrq=sqrq;}
public void setSprq(String sprq)
{
	this.sprq=sprq;}
public void setFdbz(int fdbz)
{
	this.fdbz=fdbz;}
public void setSprid(int sprid)
{
	this.sprid=sprid;}
public void setDkzh(String dkzh)
{
	this.dkzh=dkzh;}
public void setDkhth(String dkhth)
{
	this.dkhth=dkhth;}
public void setDkhtje(float dkhtje)
{
	this.dkhtje=dkhtje;}
public void setDkhtll(float dkhtll)
{
	this.dkhtll=dkhtll;}
public void setHkfs(String hkfs)
{
	this.hkfs=hkfs;}
public void setMqhkje(float mqhkje)
{
	this.mqhkje=mqhkje;}
public void setDcxdyid(int dcxdyid)
{
	this.dcxdyid=dcxdyid;}




public int getDk_sqh()
{
	return dk_sqh;}
public int getDkkhid()
{
	return dkkhid;}
public String getDkzl()
{
	return dkzl;}
public String getDkxz()
{
	return dkxz;}
public String getDkyt()
{
	return dkyt;}
public String getDkfw()
{
	return dkfw;}
public String getDkdyp()
{
	return dkdyp;}
public float getDypje()
{
	return dypje;}
public int getDbrid()
{
	return dbrid;}
public float getDkje()
{
	return dkje;}
public int getZcglid()
{
	return zcglid;}
public String getSqrq()
{
	return sqrq;}
public String getSprq()
{
	return sprq;}
public int getFdbz()
{
	return fdbz;}
public int getSprid()
{
	return sprid;}
public String getDkzh()
{
	return dkzh;}
public String getDkhth()
{
	return dkhth;}
public float getDkhtje()
{
	return dkhtje;}
public float getDkhtll()
{
	return dkhtll;}
public String getHkfs()
{
	return hkfs;}
public float getMqhkje()
{
	return mqhkje;}
public int getDcxdyid()
{
	return dcxdyid;}
}