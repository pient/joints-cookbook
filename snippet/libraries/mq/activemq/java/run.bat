@ECHO off

REM start compile java class, please set up PATH ACTIVEMQ_HOME at first
REM eg. run server start
REM     run compile Receiver
REM     run start Receiver 

@echo off

ECHO start compile java class, please set up PATH ACTIVEMQ_HOME at first

@ECHO off

SET OPERATION=%1
SET TARGET=%2
SET CLASSPATH="%ACTIVEMQ_HOME%/*;"

ECHO ACTIVEMQ_HOME: %ACTIVEMQ_HOME%

ECHO JAVA_HOME: %JAVA_HOME%

ECHO OPERATION: %OPERATION%

REM start server
IF %OPERATION% EQU server (
  ECHO start server... 

  %ACTIVEMQ_HOME%/bin/activemq %TARGET%
)

REM compile files
IF %OPERATION% EQU compile (
  ECHO start compiling... 

  IF [%TAEGET%] EQU [] (
    ECHO compiling *.java 
    javac -encoding UNICODE -cp %CLASSPATH% *.java
  ) else (
    ECHO compiling %TARGET%.java 
    javac -encoding UNICODE -cp %CLASSPATH% %TARGET%.java
  )
)

REM run file
IF %OPERATION% EQU start (
  ECHO start runing...

  IF [%TARGET%] EQU [] (
    ECHO pleace supply the run target argument
  ) else (
    java -cp %CLASSPATH% %TARGET%
  )
)

