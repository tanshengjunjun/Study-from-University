#include"openglUtils.h"

using namespace std;

char* readShaderSource(const char *path,GLint &len){
	FILE *fp = fopen(path,"rb");

	if(fp==nullptr)
	  return nullptr;

	fseek(fp,0,SEEK_END);
	int size =  ftell(fp);
	len = size;
	fseek(fp,0,SEEK_SET);
	char *buf = new char[size+1];
	//���ϵĴ��������⣬��������ֵ������ԭ������ftell()����ֵ��fread()����ֵ��fread����ʵ�ʵõ����ַ�������������ı��ļ���\r\n��ȡ������\n����ͻᵼ�¶�ȡ���ַ���С��ʵ���ı��ļ��еĳ��ȡ�����rbȡ��rʱ�����ö�����ģʽʱ��ftell()��fread()���ص�ֵ��ͬ
	//memset(buf,0,len+1);

	fread(buf,1,size,fp);	
	buf[size + 1] = '\0';
	cout<<buf;
	fclose(fp);

	return buf;
}

void compileCheck(GLuint shader,char name[]){
  GLint success;
  GLchar infoLog[512];
  glGetShaderiv(shader, GL_COMPILE_STATUS, &success);
  if(!success)
  {
    glGetShaderInfoLog(shader, 512, NULL, infoLog);
    std::cout << "ERROR::SHADER::"<<name<<"::COMPILATION_FAILED\n" << infoLog << std::endl;
	delete []infoLog;
  }
  
}

void linkCheck(GLuint program){
  GLint success;
  GLchar infoLog[512];
  glGetProgramiv(program, GL_COMPILE_STATUS, &success);
  if(!success)
  {
    glGetProgramInfoLog(program, 512, NULL, infoLog);
    std::cout << "ERROR::LINK::VERTEX::LINK_FAILED\n" << infoLog << std::endl;
	delete []infoLog;
  }

}
