package DataAccessLayer;

public class T_roleVO{
private int rol_id;
private String rol_type;
private String rol_qx;
private String rol_name;
private String rol_memo;

public T_roleVO()
{//TODO 生成最初的数据等
	}
public int getRol_id()
{
	return rol_id;}
public String getRol_type()
{
	return rol_type;}
public String getRol_qx()
{
	return rol_qx;}
public String getRol_name()
{
	return rol_name;}
public String getRol_memo()
{
	return rol_memo;}


public void setRol_id(int rol_id)
{
	this.rol_id=rol_id;}
public void setRol_type(String rol_type)
{
	this.rol_type=rol_type;}
public void setRol_qx(String rol_qx)
{
	this.rol_qx=rol_qx;}
public void setRol_name(String rol_name)
{
	this.rol_name=rol_name;}
public void setRol_memo(String rol_memo)
{
	this.rol_memo=rol_memo;}
}