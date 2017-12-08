#version 330 core

in vec3 color1;
in vec2 texCoord1;

out vec4 fColor;

uniform sampler2D mytexture; 



void main()
{
  fColor =  vec4(color1,1.0) * texture2D(mytexture,texCoord1);
}