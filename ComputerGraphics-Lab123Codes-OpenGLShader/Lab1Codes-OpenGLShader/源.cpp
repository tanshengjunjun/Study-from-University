#define GLEW_STATIC
#include<iostream>
#include<fstream>
#include <glew.h>
#include<glfw/glfw3.h>
#include<time.h>
#include <glm/glm.hpp>
#include <glm/gtc/matrix_transform.hpp>
#include <glm/gtc/type_ptr.hpp>
#include<soil/SOIL.h>
#include "openglUtils.h"

using namespace std;
using namespace glm;


const int NumTriangles = 12;
const int NumPoints = 3 * NumTriangles;
const int TexSize = 64;
GLuint textures[2];

vec3 points[NumPoints];
vec3 cubeColors[NumPoints];
vec2 texCoords[NumPoints];

GLubyte image[TexSize][TexSize][3];
GLubyte image2[TexSize][TexSize][3];

int index =0;


#define X_AXIS 0
#define Y_AXIS 1
#define Z_AXIS 2

int myAxis = Y_AXIS;  //初始绕y轴转动

vec3 vertices[8] = {

	vec3(-0.5,-0.5,0.5), //左下高
	vec3(-0.5,0.5,0.5),  //左上高
	vec3(0.5,0.5,0.5),  //右上高
	vec3(0.5,-0.5,0.5),  //右下高
	vec3(-0.5,-0.5,-0.5),  //左下低
	vec3(-0.5,0.5,-0.5),  //左上低
	vec3(0.5,0.5,-0.5),  //右上低
	vec3(0.5,-0.5,-0.5)  //右下低
	
	};

vec3 colors[8] = {
	vec3(0.0,0.0,0.0),
	vec3(1.0,0.0,0.0),
	vec3(1.0,1.0,0.0),
	vec3(0.0,1.0,0.0),
	vec3(0.0,0.0,1.0),
	vec3(1.0,0.0,1.0),
	vec3(0.0,1.0,1.0),
	vec3(1.0,1.0,1.0)

};

void quad(int a,int b,int c,int d)
{
	points[index] = vertices[a];cubeColors[index]=colors[a];texCoords[index]=vec2(0.0,0.0); index++;
	points[index] = vertices[b];cubeColors[index]=colors[a];texCoords[index]=vec2(0.0,1.0);index++;
	points[index] = vertices[c];cubeColors[index]=colors[a];texCoords[index]=vec2(1.0,1.0);index++;
	points[index] = vertices[a];cubeColors[index]=colors[a];texCoords[index]=vec2(0.0,0.0);index++;
	points[index] = vertices[c];cubeColors[index]=colors[a];texCoords[index]=vec2(1.0,1.0);index++;
	points[index] = vertices[d];cubeColors[index]=colors[a];texCoords[index]=vec2(1.0,0.0);index++;
}

void cube(){

    quad(1,0,3,2);
	quad(2,3,7,6);
	quad(3,0,4,7);
	quad(6,5,1,2);
	quad(4,5,6,7);
	quad(5,4,0,1);
	
}

void createImage()
{
	for(int i=0;i<TexSize;i++)
		for(int j=0;j<TexSize;j++)
		{
			GLubyte c = (((i & 0x8) == 0)^((j & 0x8) ==0 ))*255;
			for(int k=0;k<3;k++)
			{
				image[i][j][k] = c;
				image2[i][j][k] = c;
			}
			image2[i][j][1] = 0;
		}
}

mat4 getModelMat(mat4 model,int key)
{
	switch (key)
	{
	case X_AXIS:
		return glm::rotate(model,-(float) glfwGetTime(),glm::vec3(1.0f,0.0f,0.0f));
		break;
	case Y_AXIS:
		return glm::rotate(model,-(float) glfwGetTime(),glm::vec3(0.0f,1.0f,0.0f));
		break;
	case Z_AXIS:
		return glm::rotate(model,-(float) glfwGetTime(),glm::vec3(0.0f,0.0f,1.0f));
		break;
	default:
		break;
	}
	
}

void key_callback(GLFWwindow* window, int key, int scancode, int action, int mods)
{
	if (action != GLFW_PRESS)  
        return;  
    switch (key)  
        {  
        case GLFW_KEY_Q:
		case GLFW_KEY_ESCAPE:
			exit(EXIT_SUCCESS);
			break;
		case GLFW_KEY_1:
			glBindTexture(GL_TEXTURE_2D,textures[0]);
			break;
		case GLFW_KEY_2:
			glBindTexture(GL_TEXTURE_2D,textures[1]);
            break;  
        default:  
            break;  
        }  
}

void mouse_button_callback(GLFWwindow* window, int button, int action, int mods)  
{  
    if (action == GLFW_PRESS) switch(button)  
            {  
            case GLFW_MOUSE_BUTTON_LEFT:  
				myAxis = X_AXIS;
                break;  
            case GLFW_MOUSE_BUTTON_MIDDLE:  
				myAxis = Y_AXIS;
                break;  
            case GLFW_MOUSE_BUTTON_RIGHT:  
				myAxis = Z_AXIS;
                break;  
            default:  
                return;  
            }  
    return;  
}  

int main()
{
	glfwInit();
    glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
    glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
    glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
    glfwWindowHint(GLFW_RESIZABLE, GL_FALSE);

	GLFWwindow* window = glfwCreateWindow(1000,800,"cooma's window",nullptr,nullptr);
	if(window == nullptr) 
	{
		std::cout<<"fail to create glfw window!"<<std::endl;
		glfwTerminate();
		return -1;
	}
	glfwMakeContextCurrent(window);

	glewExperimental = GL_TRUE;
	if(glewInit()!=GLEW_OK)
	{
		std::cout<<"failed to initialize glew!";
		return -1;

	}
	int width,hight;
	glfwGetFramebufferSize(window,&width,&hight);
	glViewport(0,0,width,hight);


	GLuint vertexShader;
	vertexShader = glCreateShader(GL_VERTEX_SHADER);
	GLint vlen;
	char *vertexShaderSource = readShaderSource("vShader.glsl",vlen);
	
	glShaderSource(vertexShader,1,&vertexShaderSource,&vlen);
	glCompileShader(vertexShader);
	compileCheck(vertexShader,"vertex");

	GLuint fragmentShader;
	fragmentShader = glCreateShader(GL_FRAGMENT_SHADER);
	GLint flen;
	char *fragmentShaderSource = readShaderSource("fShader.glsl",flen);
	glShaderSource(fragmentShader,1,&fragmentShaderSource,&flen);
	glCompileShader(fragmentShader);
    compileCheck(fragmentShader,"fragment");

	
	GLuint program;
	program = glCreateProgram();

	glAttachShader(program,vertexShader);
	glAttachShader(program,fragmentShader);

	glLinkProgram(program);

	linkCheck(program);

	glUseProgram(program);
	glDeleteShader(vertexShader);
	glDeleteShader(fragmentShader);


    createImage();
	cube();
	

	glGenTextures(2,textures);

	glBindTexture(GL_TEXTURE_2D,textures[0]);
	glTexImage2D(GL_TEXTURE_2D,0,GL_RGB,TexSize,TexSize,0,GL_RGB,GL_UNSIGNED_BYTE,image);

	//i意味着int，f意味着float。要设置的数值如果是整数类型的，就用i，否则用f
	glTexParameteri(GL_TEXTURE_2D,GL_TEXTURE_WRAP_S,GL_REPEAT);  
	glTexParameteri(GL_TEXTURE_2D,GL_TEXTURE_WRAP_T,GL_REPEAT);
	glTexParameteri(GL_TEXTURE_2D,GL_TEXTURE_MIN_FILTER,GL_LINEAR);
	glTexParameteri(GL_TEXTURE_2D,GL_TEXTURE_MAG_FILTER,GL_LINEAR);

	glBindTexture(GL_TEXTURE_2D,textures[1]);
	glTexImage2D(GL_TEXTURE_2D,0,GL_RGB,TexSize,TexSize,0,GL_RGB,GL_UNSIGNED_BYTE,image2);

	//i意味着int，f意味着float。要设置的数值如果是整数类型的，就用i，否则用f
	glTexParameteri(GL_TEXTURE_2D,GL_TEXTURE_WRAP_S,GL_REPEAT);  
	glTexParameteri(GL_TEXTURE_2D,GL_TEXTURE_WRAP_T,GL_REPEAT);
	glTexParameteri(GL_TEXTURE_2D,GL_TEXTURE_MIN_FILTER,GL_LINEAR);
	glTexParameteri(GL_TEXTURE_2D,GL_TEXTURE_MAG_FILTER,GL_LINEAR);

	glActiveTexture(GL_TEXTURE0);
	glBindTexture(GL_TEXTURE_2D,textures[0]);

	GLuint VAO;
	glGenVertexArrays(1,&VAO);
	glBindVertexArray(VAO);
	GLuint VBO;
	glGenBuffers(1,&VBO);

	glBindBuffer(GL_ARRAY_BUFFER,VBO);
	glBufferData(GL_ARRAY_BUFFER,sizeof(points)+sizeof(cubeColors)+sizeof(texCoords),NULL,GL_STATIC_DRAW);
	glBufferSubData(GL_ARRAY_BUFFER,0,sizeof(points),points);
	glBufferSubData(GL_ARRAY_BUFFER,sizeof(points),sizeof(cubeColors),cubeColors);
	glBufferSubData(GL_ARRAY_BUFFER,sizeof(points)+sizeof(cubeColors),sizeof(texCoords),texCoords);

	//参数从左至右：第几个分量，组件数量，类型，每两个分量之间的距离，第一个组建的偏移量
	glVertexAttribPointer(0,3,GL_FLOAT,GL_FALSE,sizeof(vec3),(GLvoid *)0);  
	glVertexAttribPointer(1,3,GL_FLOAT,GL_FALSE,sizeof(vec3),(GLvoid *)sizeof(points));  
	glVertexAttribPointer(2,2,GL_FLOAT,GL_FALSE,sizeof(vec2),(GLvoid *)(sizeof(points)+sizeof(cubeColors)));  
	
	glEnableVertexAttribArray(0);
	glEnableVertexAttribArray(1);
	glEnableVertexAttribArray(2);


	glBindVertexArray(0);

	glEnable(GL_DEPTH_TEST);

	glfwSetKeyCallback(window, key_callback);  
	glfwSetMouseButtonCallback(window,mouse_button_callback);

	glBindTexture(GL_TEXTURE_2D,textures[0]);

	while(!glfwWindowShouldClose(window))
	{ 
	  glfwPollEvents();
	  
	  glm::mat4 model;
	  glm::mat4 view;
	  glm::mat4 projection;
	  
	  vec3 eye(1.0,1.0,-1.0);
	  vec3 center(0.0,0.0,0.0);
	  vec3 up(1.0,1.0,1.0);
//	  view = lookAt(eye,center,up);

	  model = getModelMat(model,myAxis);
//	  model = glm::rotate(model,-0.0f,glm::vec3(0.0f,1.0f,0.0f));
	  view = glm::translate(view,glm::vec3(0.0f,0.0f,-1.0f));	  //projection = glm::perspective(90.0f,(GLfloat)WIDTH /(GLfloat)HEIGHT,0.1f,10.0f);
	  projection = glm::ortho(-2.0,2.0,-2.0,2.0,0.1,10.0);
	  GLuint modelLoc = glGetUniformLocation(program,"model");  //声明uniform变量，与shader进行通信。只要保证此处变量名与glsl中一致即可。
	  GLint viewLoc = glGetUniformLocation(program, "view");
	  GLint projLoc = glGetUniformLocation(program, "projection"); 

	  glUniformMatrix4fv(modelLoc, 1, GL_FALSE, glm::value_ptr(model));
      glUniformMatrix4fv(viewLoc, 1, GL_FALSE, glm::value_ptr(view));
      glUniformMatrix4fv(projLoc, 1, GL_FALSE, glm::value_ptr(projection)); 

  
	  glClearColor(1,1,1,1);
	  glClear(GL_COLOR_BUFFER_BIT);
	  glUseProgram(program);
	  glBindVertexArray(VAO);

	  glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);  //清空深度信息

	  glDrawArrays(GL_TRIANGLES,0,NumPoints);

	  glBindVertexArray(0);

      glfwSwapBuffers(window);
    }

	glDeleteVertexArrays(1, &VAO);
    glDeleteBuffers(1, &VBO);
	glfwTerminate();
    return 0;
}

