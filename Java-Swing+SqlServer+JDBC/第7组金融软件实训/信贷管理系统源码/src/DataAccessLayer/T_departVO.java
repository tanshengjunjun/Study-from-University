package DataAccessLayer;


public class T_departVO{
private int dpt_id;
private String dpt_cod;
private String dpt_name;
private String dpt_addr;
private String dpt_tele;
private int dpt_man;
private String dpt_memo;

public T_departVO()
{//TODO 生成最初的数据等
	}
public int getDpt_id()
{
	return dpt_id;}
public String getDpt_cod()
{
	return dpt_cod;}
public String getDpt_name()
{
	return dpt_name;}
public String getDpt_addr()
{
	return dpt_addr;}
public String getDpt_tele()
{
	return dpt_tele;}
public int getDpt_man()
{
	return dpt_man;}
public String getDpt_memo()
{
	return dpt_memo;}


public void setDpt_id(int dpt_id)
{
	this.dpt_id=dpt_id;}
public void setDpt_cod(String dpt_cod)
{
	this.dpt_cod=dpt_cod;}
public void  setDpt_name(String dpt_name)
{
	this.dpt_name=dpt_name;}
public void  setDpt_addr(String dpt_addr)
{
	this.dpt_addr=dpt_addr;}
public void  setDpt_tele(String dpt_tele)
{
	this.dpt_tele=dpt_tele;}
public void  setDpt_man(int dpt_man)
{
	this.dpt_man=dpt_man;}
public void  setDpt_memo(String dpt_memo)
{
	this.dpt_memo=dpt_memo;}
}