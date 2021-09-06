# MapshotKakaoServer
맵샷 카카오 지도 서버

## 개발 환경, 기술 스택
* Java, Spring Boot
* Kakao Web API
* Heroku
* Selenium, Chrome Driver
* Thymeleaf, JavaScript

## 프로젝트 개요
### Kakao Web API
* Mapshot 서비스의 출력 결과를 카카오 지도로도 가능하게 해달라는 요청이 많았음.
* CORS 정책으로 재가공 어려움, Proxy 서버 제작

### Heroku
* Vworld와 달리 카카오는 해외 서버 접속 문제가 없어서 사용
* 무료, 간편한 사용, https 도메인 제공이 큰 이점으로 작용

### Selenium
* 카카오 웹 api는 기본적으로 자바스크립트로 동작
* 화면 로딩이 끝나면 img 태그들의 src들을 파싱해서 다시 이미지를 불러온 후 리턴할 계획이었음
* 하지만 api로 이미지를 요청하는 것이 아닌, 다이렉트 소스로 부르는 것은 규정 위반
* 그래서 동적 웹페이지 크롤링에 특화된 Selenium 사용
* 내 페이지를 크롤링 해서 전체화면 캡쳐 후, 그 이미지를 리턴하는 방식으로 사용

## 결과물 샘플
![화면 캡처 2021-09-06 231713](https://user-images.githubusercontent.com/59993347/132230684-2593b6a0-58e3-4402-add1-9a8e1451ccc6.png)

## 기록사항
#### Heroku 서버 설정
* Procfile 없으면 배포 에러 남
```
web: java -Dserver.port=$PORT $JAVA_OPTS -jar build/libs/MapshotKakaoServer-0.0.1-SNAPSHOT.jar
```

* 한글 폰트 깨짐, 폰트 추가 필요
* 서버 요청 없으면 잠들음, 깨우는 시간 꽤걸림
    - [kaffeine](https://kaffeine.herokuapp.com/) 서비스로 해결
    - 주기적으로 내 서버에 접속해서 잠드는걸 방지해 주는 서비스


