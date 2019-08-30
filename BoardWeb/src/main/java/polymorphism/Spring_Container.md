## 스프링 컨테이너의 종류
- BeanFactory와 이를 상속한 ApplicationContext 컨테이너 제공

1. BeanFactory 
	- 스프링 설정 파일에 등록된 <bean> 객체를 생성하고 관리하는 가장 기본적인 컨테이너 기능
	- 클라이언트의 요청(lookup)에 의해서만 <bean> 객체가 생성 => 지연 로딩(Lazy Loading)

2. ApplicationContext 
	- <bean> 객체 관리 기능, 트랜잭션 관리, 메시지 기반의 다국어 처리 등 다양한 기능 지원
	- 컨테이너가 구동되는 시점에 <bean> 등록된 클래스들의 객체를 생성하는 즉시 로딩(pre-loading) 방식
	- 웹 애플리케이션 개발 지원
	- GenericXmlApplicationContext : 파일 시스템이나 클래스 경로에 있는 XML 설정 파일을
								  로딩하여 구동하는 컨테이너
	- XmlWebApplicationContext : 웹 기반의 스프링 애플리케이션을 개발할 때 사용하는 컨테이너	