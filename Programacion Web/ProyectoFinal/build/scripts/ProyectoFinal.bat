@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  ProyectoFinal startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and PROYECTO_FINAL_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\app-1.0-SNAPSHOT.jar;%APP_HOME%\lib\javalin-openapi-4.6.4.jar;%APP_HOME%\lib\javalin-4.6.4.jar;%APP_HOME%\lib\slf4j-simple-1.7.36.jar;%APP_HOME%\lib\jsoup-1.14.3.jar;%APP_HOME%\lib\jackson-module-kotlin-2.13.3.jar;%APP_HOME%\lib\swagger-parser-2.0.27.jar;%APP_HOME%\lib\swagger-parser-v2-converter-2.0.27.jar;%APP_HOME%\lib\swagger-parser-v3-2.0.27.jar;%APP_HOME%\lib\swagger-parser-core-2.0.27.jar;%APP_HOME%\lib\kotlin-openapi3-dsl-1.0.0.jar;%APP_HOME%\lib\swagger-core-2.1.10.jar;%APP_HOME%\lib\swagger-models-2.1.10.jar;%APP_HOME%\lib\jackson-module-jsonSchema-2.13.3.jar;%APP_HOME%\lib\swagger-compat-spec-parser-1.0.55.jar;%APP_HOME%\lib\swagger-parser-1.0.55.jar;%APP_HOME%\lib\swagger-core-1.6.2.jar;%APP_HOME%\lib\swagger-models-1.6.2.jar;%APP_HOME%\lib\jackson-datatype-jsr310-2.13.3.jar;%APP_HOME%\lib\jackson-annotations-2.13.3.jar;%APP_HOME%\lib\jackson-datatype-json-org-2.13.3.jar;%APP_HOME%\lib\openapi-parser-4.0.4.jar;%APP_HOME%\lib\jsonoverlay-4.0.4.jar;%APP_HOME%\lib\jackson-dataformat-yaml-2.13.3.jar;%APP_HOME%\lib\jackson-core-2.13.3.jar;%APP_HOME%\lib\json-patch-1.13.jar;%APP_HOME%\lib\json-schema-validator-2.2.14.jar;%APP_HOME%\lib\json-schema-core-1.2.14.jar;%APP_HOME%\lib\jackson-coreutils-equivalence-1.0.jar;%APP_HOME%\lib\jackson-coreutils-2.0.jar;%APP_HOME%\lib\jackson-databind-2.13.3.jar;%APP_HOME%\lib\freemarker-2.3.31.jar;%APP_HOME%\lib\thymeleaf-3.0.15.RELEASE.jar;%APP_HOME%\lib\velocity-engine-core-2.3.jar;%APP_HOME%\lib\jetty-http-spi-11.0.9.jar;%APP_HOME%\lib\jaxws-tools-4.0.0.jar;%APP_HOME%\lib\jaxws-eclipselink-plugin-4.0.0.jar;%APP_HOME%\lib\sdo-eclipselink-plugin-4.0.0.jar;%APP_HOME%\lib\jaxws-rt-4.0.0.jar;%APP_HOME%\lib\release-documentation-4.0.0-docbook.zip;%APP_HOME%\lib\samples-4.0.0.zip;%APP_HOME%\lib\jakarta.xml.ws-api-4.0.0.jar;%APP_HOME%\lib\h2-2.1.214.jar;%APP_HOME%\lib\jasypt-1.9.3.jar;%APP_HOME%\lib\hibernate-entitymanager-5.6.10.Final.jar;%APP_HOME%\lib\postgresql-42.3.6.jar;%APP_HOME%\lib\unirest-java-3.13.10.jar;%APP_HOME%\lib\grpc-netty-shaded-1.48.0.jar;%APP_HOME%\lib\grpc-core-1.48.0.jar;%APP_HOME%\lib\gson-2.9.0.jar;%APP_HOME%\lib\jjwt-impl-0.11.5.jar;%APP_HOME%\lib\jjwt-api-0.11.5.jar;%APP_HOME%\lib\grpc-protobuf-1.48.0.jar;%APP_HOME%\lib\grpc-stub-1.48.0.jar;%APP_HOME%\lib\proto-google-common-protos-2.9.0.jar;%APP_HOME%\lib\protobuf-java-3.21.4.jar;%APP_HOME%\lib\javax.annotation-api-1.3.2.jar;%APP_HOME%\lib\slf4j-api-1.7.36.jar;%APP_HOME%\lib\jetty-webapp-9.4.48.v20220622.jar;%APP_HOME%\lib\websocket-server-9.4.48.v20220622.jar;%APP_HOME%\lib\jetty-servlet-9.4.48.v20220622.jar;%APP_HOME%\lib\jetty-security-9.4.48.v20220622.jar;%APP_HOME%\lib\jetty-server-9.4.48.v20220622.jar;%APP_HOME%\lib\kotlin-stdlib-jdk8-1.5.32.jar;%APP_HOME%\lib\redoc-2.0.0-rc.45.jar;%APP_HOME%\lib\swagger-ui-4.10.3.jar;%APP_HOME%\lib\classgraph-4.8.102.jar;%APP_HOME%\lib\ognl-3.1.26.jar;%APP_HOME%\lib\attoparser-2.0.5.RELEASE.jar;%APP_HOME%\lib\unbescape-1.1.6.RELEASE.jar;%APP_HOME%\lib\commons-lang3-3.11.jar;%APP_HOME%\lib\jakarta.ws.rs-api-3.0.0.jar;%APP_HOME%\lib\hibernate-core-6.1.1.Final.jar;%APP_HOME%\lib\jaxb-jxc-4.0.0.jar;%APP_HOME%\lib\jaxb-impl-4.0.0.jar;%APP_HOME%\lib\jaxb-xjc-4.0.0.jar;%APP_HOME%\lib\jaxb-core-4.0.0.jar;%APP_HOME%\lib\org.eclipse.persistence.moxy-4.0.0-M3.jar;%APP_HOME%\lib\jaxb-runtime-3.0.2.jar;%APP_HOME%\lib\jaxb-core-3.0.2.jar;%APP_HOME%\lib\jakarta.xml.bind-api-4.0.0.jar;%APP_HOME%\lib\saaj-impl-3.0.0.jar;%APP_HOME%\lib\jakarta.xml.soap-api-3.0.0.jar;%APP_HOME%\lib\ha-api-3.1.13.jar;%APP_HOME%\lib\gmbal-api-only-4.0.3.jar;%APP_HOME%\lib\management-api-3.2.3.jar;%APP_HOME%\lib\streambuffer-2.1.0.jar;%APP_HOME%\lib\stax-ex-2.1.0.jar;%APP_HOME%\lib\mimepull-1.10.0.jar;%APP_HOME%\lib\FastInfoset-2.1.0.jar;%APP_HOME%\lib\angus-mail-1.0.0.jar;%APP_HOME%\lib\jakarta.mail-api-2.1.0.jar;%APP_HOME%\lib\angus-activation-1.0.0.jar;%APP_HOME%\lib\woodstox-core-6.2.8.jar;%APP_HOME%\lib\stax2-api-4.2.1.jar;%APP_HOME%\lib\jakarta.activation-api-2.1.0.jar;%APP_HOME%\lib\jakarta.annotation-api-2.1.1.jar;%APP_HOME%\lib\jboss-logging-3.4.3.Final.jar;%APP_HOME%\lib\hibernate-commons-annotations-6.0.2.Final.jar;%APP_HOME%\lib\javax.persistence-api-2.2.jar;%APP_HOME%\lib\byte-buddy-1.12.9.jar;%APP_HOME%\lib\jboss-transaction-api_1.2_spec-1.1.1.Final.jar;%APP_HOME%\lib\grpc-protobuf-lite-1.48.0.jar;%APP_HOME%\lib\grpc-api-1.48.0.jar;%APP_HOME%\lib\uri-template-0.10.jar;%APP_HOME%\lib\guava-31.1-android.jar;%APP_HOME%\lib\checker-qual-3.12.0.jar;%APP_HOME%\lib\error_prone_annotations-2.14.0.jar;%APP_HOME%\lib\perfmark-api-0.25.0.jar;%APP_HOME%\lib\msg-simple-1.2.jar;%APP_HOME%\lib\btf-1.3.jar;%APP_HOME%\lib\jsr305-3.0.2.jar;%APP_HOME%\lib\httpmime-4.5.13.jar;%APP_HOME%\lib\httpclient-4.5.13.jar;%APP_HOME%\lib\httpcore-nio-4.4.13.jar;%APP_HOME%\lib\httpasyncclient-4.1.5.jar;%APP_HOME%\lib\commons-codec-1.15.jar;%APP_HOME%\lib\kotlin-stdlib-jdk7-1.5.32.jar;%APP_HOME%\lib\kotlin-reflect-1.5.30.jar;%APP_HOME%\lib\kotlin-stdlib-1.5.32.jar;%APP_HOME%\lib\commons-io-2.6.jar;%APP_HOME%\lib\javassist-3.20.0-GA.jar;%APP_HOME%\lib\org.eclipse.persistence.sdo-4.0.0-M3.jar;%APP_HOME%\lib\jakarta.persistence-api-3.0.0.jar;%APP_HOME%\lib\jakarta.transaction-api-2.0.0.jar;%APP_HOME%\lib\jandex-2.4.2.Final.jar;%APP_HOME%\lib\classmate-1.5.1.jar;%APP_HOME%\lib\jakarta.inject-api-2.0.0.jar;%APP_HOME%\lib\antlr4-runtime-4.10.jar;%APP_HOME%\lib\failureaccess-1.0.1.jar;%APP_HOME%\lib\listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar;%APP_HOME%\lib\j2objc-annotations-1.3.jar;%APP_HOME%\lib\annotations-4.1.1.4.jar;%APP_HOME%\lib\animal-sniffer-annotations-1.21.jar;%APP_HOME%\lib\grpc-context-1.48.0.jar;%APP_HOME%\lib\httpcore-4.4.13.jar;%APP_HOME%\lib\commons-logging-1.2.jar;%APP_HOME%\lib\annotations-13.0.jar;%APP_HOME%\lib\kotlin-stdlib-common-1.5.32.jar;%APP_HOME%\lib\websocket-servlet-9.4.48.v20220622.jar;%APP_HOME%\lib\javax.servlet-api-3.1.0.jar;%APP_HOME%\lib\websocket-client-9.4.48.v20220622.jar;%APP_HOME%\lib\jetty-client-9.4.48.v20220622.jar;%APP_HOME%\lib\jetty-http-9.4.48.v20220622.jar;%APP_HOME%\lib\websocket-common-9.4.48.v20220622.jar;%APP_HOME%\lib\jetty-io-9.4.48.v20220622.jar;%APP_HOME%\lib\jetty-xml-9.4.48.v20220622.jar;%APP_HOME%\lib\javax.mail-api-1.6.1.jar;%APP_HOME%\lib\javax.mail-1.6.1.jar;%APP_HOME%\lib\org.eclipse.persistence.asm-9.2.0.jar;%APP_HOME%\lib\org.eclipse.persistence.core-4.0.0-M3.jar;%APP_HOME%\lib\jakarta.activation-2.0.1.jar;%APP_HOME%\lib\validation-api-1.1.0.Final.jar;%APP_HOME%\lib\json-20190722.jar;%APP_HOME%\lib\jetty-util-ajax-9.4.48.v20220622.jar;%APP_HOME%\lib\jetty-util-9.4.48.v20220622.jar;%APP_HOME%\lib\websocket-api-9.4.48.v20220622.jar;%APP_HOME%\lib\swagger-annotations-2.1.10.jar;%APP_HOME%\lib\jakarta.validation-api-2.0.2.jar;%APP_HOME%\lib\snakeyaml-1.30.jar;%APP_HOME%\lib\activation-1.1.jar;%APP_HOME%\lib\txw2-3.0.2.jar;%APP_HOME%\lib\istack-commons-runtime-4.0.1.jar;%APP_HOME%\lib\swagger-annotations-1.6.2.jar;%APP_HOME%\lib\mailapi-1.6.2.jar;%APP_HOME%\lib\joda-time-2.10.5.jar;%APP_HOME%\lib\libphonenumber-8.11.1.jar;%APP_HOME%\lib\jopt-simple-5.0.4.jar;%APP_HOME%\lib\rhino-1.7.7.2.jar


@rem Execute ProyectoFinal
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %PROYECTO_FINAL_OPTS%  -classpath "%CLASSPATH%" Proyecto.main %*

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable PROYECTO_FINAL_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%PROYECTO_FINAL_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
