rem path - 특정 프로그램(javac.exe, java.exe)를 설치된 경로에 상관없이 사용하기위해 path설정

rem xxx_home - 프로그램끼리 경로를 참조하기 위해 설정하는 path
set dev_home=c:\dev
set java_home=%dev_home%\Java\jdk1.8.0_191
set eclipse_home=%dev_home%\eclipse

set path=%java_home%\bin;%eclipse_home%