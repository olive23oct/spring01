# Spring framework

## 설정 정보
- Spring 4.2.5
- java 1.8
- servlet 3.1
- H2 Database (v 1.4.199)
- dbcp 2.1.1

## 기본 세팅
1. legacy project 생성

2. encoding 설정 
- window - >preferences - encoding 검색 
- workspace, HTML, CSS, JSP, java Class UTF-8 설정

3. pom 설정
- java 1.8 / Dynamic Web Module 3.1
- 프로젝트 properties -> Project Facets 버전 수정
- Sevlet dependency 
```xml
<dependency>
	<groupId>javax.servlet</groupId>
	<artifactId>javax.servlet-api</artifactId>
    	<version>3.1.0</version>
    	<scope>provided</scope>
</dependency>
	
```
- web.xml - 3.1 버전으로 수정

4. Tomcat연결

5. DB연결
- JDBC, dbcp 라이브러리 추가
```xml
<!-- dbcp -->
<dependency>
	<groupId>org.apache.commons</groupId>
	<artifactId>commons-dbcp2</artifactId>
	<version>2.1.1</version>
</dependency>

<!-- H2 db -->
<dependency>
	<groupId>com.h2database</groupId>
	<artifactId>h2</artifactId>
	<version>1.4.199</version>
	<scope>test</scope>
</dependency>
```
- serlvet-context에 DB설정
```xml
<bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource">
        <property name="driverClassName" value="${h2driver}"/>
        <property name="url" value="${h2url}"/>
        <property name="username" value="${h2username}"/>
        <property name="password" value="${h2password}"/>
</bean>
<context:property-placeholder location="/WEB-INF/spring/appServlet/db.properties"/>	
```
- DB Server에 관한 정보를 담은 properties 파일 설정

```xml
<!-- properties 읽어오기(3가지 방법) -->
<!-- 1. PropertyPlaceholderConfigurer -->
<bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
        <property name="location" value="/WEB-INF/spring/appServlet/db.properties"/>
        <property name="fileEncoding" value="UTF-8" />
</bean>

<!-- 2. context:property-placeholder -->
<context:property-placeholder location="/WEB-INF/spring/appServlet/db.properties"/>	

<!-- 3. util:properties -->
<util:properties id="dbinfo" location="/WEB-INF/spring/appServlet/db.properties"/>
```
	
6. encoding fillter 설정
- web.xml 설정
```xml
<!-- fillter -->
<filter> 
	<filter-name>encodingFilter</filter-name> 
	<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class> 
	<init-param> 
		<param-name>encoding</param-name> 
		<param-value>UTF-8</param-value> 
	</init-param> 
</filter>
	
<filter-mapping>
	<filter-name>encodingFilter</filter-name>
	<url-pattern>/＊</url-pattern>
</filter-mapping>
```

7. mybatis 연동
```xml
<!-- Mybatis -->
<dependency>
	<groupId>org.mybatis</groupId>
	<artifactId>mybatis</artifactId>
	<version>3.4.6</version>
</dependency>
	
<!-- Mybatis-spring -->
<dependency>
	<groupId>org.mybatis</groupId>
	<artifactId>mybatis-spring</artifactId>
	<version>1.3.2</version>
</dependency>
```
- SqlSessionFactory 객체 : DB 서버와 mybatis 연결

