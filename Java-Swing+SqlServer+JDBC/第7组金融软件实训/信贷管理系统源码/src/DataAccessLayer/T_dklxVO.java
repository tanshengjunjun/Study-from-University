package DataAccessLayer;
import java.util.*;

public class T_dklxVO{
private int lx_id;
private int flx_id;
private String lxbz;
private String dk_zh;
private float dk_ye;
private String fxzhrq;
private String fxksrq;
private String lxdqrq;
private String lxjxrq;
private String lxclrq;
private float ll;
private float lxe;
private String lxclbz;
public T_dklxVO(){
	lx_id=1;
	flx_id=1;
	lxbz="1";
	dk_zh="1234";
	dk_ye=123;
	fxzhrq="123";
	fxksrq="123";
	lxdqrq="123";
	lxjxrq="123";
	lxclrq="123";
	ll=123;
	lxe=123;
	lxclbz="123";
}
public T_dklxVO(int lx_id
, int flx_id
, String lxbz
, String dk_zh
, float dk_ye
, String fxzhrq
, String fxksrq
, String lxdqrq
, String lxjxrq
, String lxclrq
, float ll
, float lxe
, String lxclbz)
{//TODO 生成最初的数据等
	this.lx_id=lx_id;
	this.flx_id=flx_id;
	this.lxbz=lxbz;
	this.dk_zh=dk_zh;
	this.dk_ye=dk_ye;
	this.dk_ye=dk_ye;
	this.fxzhrq=fxzhrq;
	this.fxksrq=fxksrq;
	this.lxdqrq=lxdqrq;
	this.lxjxrq=lxjxrq;
	this.lxclrq=lxclrq;
	this.ll=ll;
	this.lxe=lxe;
	this.lxclbz=lxclbz;
}
public int getLx_id()
{
	return lx_id;}
public int getFlx_id()
{
	return flx_id;}
public String getLxbz()
{
	return lxbz;}
public String getDk_zh()
{
	return dk_zh;}
public float getDk_ye()
{
	return dk_ye;}
public String getFxzhrq()
{
	return fxzhrq;}
public String getFxksrq()
{
	return fxksrq;}
public String getLxdqrq()
{
	return lxdqrq;}
public String getLxjxrq()
{
	return lxjxrq;}
public String getLxclrq()
{
	return lxclrq;}
public float getLl()
{
	return ll;}
public float getLxe()
{
	return lxe;}
public String getLxclbz()
{
	return lxclbz;}


public  void setLx_id(int lx_id)
{
	this.lx_id=lx_id;}
public void setFlx_id(int flx_id)
{
	this.flx_id=flx_id;}
public void setLxbz(String lxbz)
{
	this.lxbz=lxbz;}
public void setDk_zh(String dk_zh)
{
	this.dk_zh=dk_zh;}
public void setDk_ye(float dk_ye)
{
	this.dk_ye=dk_ye;}
public void setFxzhrq(String fxzhrq)
{
	this.fxzhrq=fxzhrq;}
public void setFxksrq(String fxksrq)
{
	this.fxksrq=fxksrq;}
public void setLxdqrq(String lxdqrq)
{
	this.lxdqrq=lxdqrq;}
public void setLxjxrq(String lxjxrq)
{
	this.lxjxrq=lxjxrq;}
public void setLxclrq(String lxclrq)
{
	this.lxclrq=lxclrq;}
public void setLl(float ll)
{
	this.ll=ll;}
public void setLxe(float lxe)
{
	this.lxe=lxe;}
public void setLxclbz(String lxclbz)
{
	this.lxclbz=lxclbz;}
} 