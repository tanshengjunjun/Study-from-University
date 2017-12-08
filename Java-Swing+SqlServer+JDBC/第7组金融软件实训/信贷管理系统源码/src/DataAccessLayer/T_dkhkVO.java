package DataAccessLayer;
import java.util.*;

public class T_dkhkVO{
private int hk_id;	
private String dk_zh;
private String dk_hm;
private Date hk_rq;
private float hk_je;
private float hk_syje;
private String hk_czyid;

public T_dkhkVO()
{//TODO 生成最初的数据等
	}
public int getHk_id()
{
	return hk_id;}
public String getDk_zh()
{
	return dk_zh;}
public String getDk_hm()
{
	return dk_hm;}
public Date getHk_rq()
{
	return hk_rq;}
public double getHk_je()
{
	return hk_je;}
public double getHk_syje()
{
	return hk_syje;}
public String getHk_czyid()
{
	return hk_czyid;}


public void setHk_id(int hk_id)
{
	this.hk_id=hk_id;}
public void setDk_zh(String dk_zh)
{
	this.dk_zh=dk_zh;}
public void setDk_hm(String dk_hm)
{
	this.dk_hm=dk_hm;}
public void setHk_rq(Date hk_rq)
{
	this.hk_rq=hk_rq;}
public void setHk_je(float hk_je)
{
	this.hk_je=hk_je;}
public void setHk_syje(float hk_syje)
{
	this.hk_syje=hk_syje;}
public void setHk_czyid(String hk_czyid)
{
	this.hk_czyid=hk_czyid;}
}