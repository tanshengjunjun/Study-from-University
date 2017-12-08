#ifndef OPENGL_UTILS
#define OPENGL_UTILS

#include<iostream>
#include<fstream>
#include <glew.h>

char* readShaderSource(const char *path,GLint &len);
void compileCheck(GLuint shader,char name[]);
void linkCheck(GLuint program);

#endif