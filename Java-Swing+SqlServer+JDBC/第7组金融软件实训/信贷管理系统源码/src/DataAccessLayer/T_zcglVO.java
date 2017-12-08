package DataAccessLayer;
import java.util.*;

public class T_zcglVO{
private int zcgl_id;
private Date zcgl_pgrq;
private int dksqid;
private float zcgl_pgje;//金额类型已改
private String zcgl_pggs;
private String zcgl_cfdd;

public T_zcglVO()
{//TODO 生成最初的数据等
	}
public int getZcgl_id()
{
	return zcgl_id;}
public Date getZcgl_pgrq()
{
	return zcgl_pgrq;}
public int getDksqid()
{
	return dksqid;}
public double getZcgl_pgje()
{
	return zcgl_pgje;}
public String getZcgl_pggs()
{
	return zcgl_pggs;}
public String getZcgl_cfdd()
{
	return zcgl_cfdd;}

public void setZcgl_id(int zcgl_id)
{
	this.zcgl_id=zcgl_id;}
public void setZcgl_pgrq(Date zcgl_pgrq)
{
	this.zcgl_pgrq=zcgl_pgrq;}
public void setDksqid(int dksqid)
{
	this.dksqid=dksqid;}
public void setZcgl_pgje(float zcgl_pgje)
{
	this.zcgl_pgje=zcgl_pgje;}
public void setZcgl_Pggs(String zcgl_pggs)
{
	this.zcgl_pggs=zcgl_pggs;}
public void setZcgl_cfdd(String zcgl_cfdd)
{
	this.zcgl_cfdd=zcgl_cfdd;}
}