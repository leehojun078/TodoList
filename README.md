# ToToList
## 사용자의 계획들을 관리 할 수 있는 Web Application

### 구현 단계

 1. Define Domain Model (Post)

 2. CRUD Operation for Post Model
  - Create (admin)
  - Read   (everyone)
  - Update (admin)
  - Delete (admin)

 3. Form Validation & Errors reports


### 사용 스택

 1. front-end ( Html / CSS / JavaScript / Bootstrap)
 
 2. back-end (Spring)


 ### 개발 환경

 Windows OS (or Mac OS)
  Eclipse(IDE)
  Apache Tomcat(v8.5, WAS, port 8080) + MySQL(port 3306)
 
  GitHub을 통해 버전 관리 및 코드 공유


###  개발 폴더

 dev 폴더를 만들고 각종 툴을 다운로드한다.


### 개발 도구 버전 (19.05.20 기준)

 1. JDK : JDK 1.8(SE)
 2. IDE : Eclipse (Release 4.7.0 (Oxygen)) + STS Eclipse Plugin
 3. Apach Tomcat 8.5
 4. MySQL 5.7.21
 5. Text Editor : Atom


### 리눅스에서 실행 방법(배포)

 tomcat이 설치된 디렉토리에서 webapps 디렉토리에 프로젝트의 war파일을 복사 붙여넣기 후 tomcat을 실행한다.
tomcat을 실행하면 자동으로 프로젝트 이름과 동일한 폴더가 생성되고 war파일로 묶여 있던 패키지가 풀린다. 
그 후 웹브라우저에서 localhost:8080/toDoList/로 접속 한다.


### 실행 화면

  1. 초기화면
 
<img width="950" alt="home" src="https://user-images.githubusercontent.com/17565204/58004361-0aaf3280-7b1e-11e9-9fb6-6157205b0ffd.PNG">
 
 
  2. 게시글 목록 (everyone)

<img width="950" alt="posts" src="https://user-images.githubusercontent.com/17565204/58004468-40ecb200-7b1e-11e9-9768-cd9a2f30838c.PNG">


  3. 관리자 페이지
 
<img width="950" alt="inventory" src="https://user-images.githubusercontent.com/17565204/58004489-4b0eb080-7b1e-11e9-944d-1c26b39d20d5.PNG">


  4. 게시글 관리 페이지
  
<img width="950" alt="inventory" src="https://user-images.githubusercontent.com/17565204/58004489-4b0eb080-7b1e-11e9-944d-1c26b39d20d5.PNG">


  5. 입력 페이지 (validatioin)
   
<img width="950" alt="input" src="https://user-images.githubusercontent.com/17565204/58005111-e8b6af80-7b1f-11e9-8c0f-da21bc317d12.PNG">

  
  
### 배포에 관해

 War파일을 통한 tomcat 서버에 배포는 하였지만, AWS나 Heroku 서버에 배포를 하지 못하였다.
  
