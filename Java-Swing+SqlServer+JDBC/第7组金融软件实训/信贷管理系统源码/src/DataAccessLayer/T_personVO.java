package DataAccessLayer;

public class T_personVO{
private int per_id;
private char per_cod;
private char per_name;
private int per_sex;
private String per_addr;
private String per_tele;
private String idcrd;
private String per_mobi;
private int per_role;
private String per_memo;
public T_personVO()
{//TODO 生成最初的数据等
	}
public int getPer_id()
{
	return per_id;}
public char getPer_cod()
{
	return per_cod;}
public char getPer_name()
{
	return per_name;}
public int getPer_sex()
{
	return per_sex;}
public String getPer_addr()
{
	return per_addr;}
public String getPer_tele()
{
	return per_tele;}
public String getIdcrd()
{
	return idcrd;}
public String getPer_mobi()
{
	return per_mobi;}
public int getPer_role()
{
	return per_role;}
public String getPer_memo()
{
	return per_memo;}

public void setPer_id(int per_id)
{
	this.per_id=per_id;}
public void setPer_cod(char per_cod)
{
	this.per_cod=per_cod;}
public void setPer_name(char per_name)
{
	this.per_name=per_name;}
public void setPer_sex(int per_sex)
{
	this.per_sex=per_sex;}
public void setPer_addr(String per_addr)
{
	this.per_addr=per_addr;}
public void setPer_tele(String per_tele)
{
	this.per_tele=per_tele;}
public void setIdcrd(String idcrd)
{
	this.idcrd=idcrd;}
public void setPer_mobi(String per_mobi)
{
	this.per_mobi=per_mobi;}
public void setPer_role(int per_role)
{
	this.per_role=per_role;}
public void setPer_memo(String per_memo)
{
	this.per_memo=per_memo;}
}