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
	//书上的代码有问题，会有垃圾值。乱码原因在于ftell()返回值比fread()返回值大。fread返回实际得到的字符数，正常情况文本文件中\r\n读取后变成了\n，这就会导致读取的字符串小于实际文本文件中的长度。当用rb取代r时，即用二进制模式时，ftell()和fread()返回的值相同
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
