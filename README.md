# 학생 CRUD API
고등학교 학생 관리 서비스

## Json Response?
Json이란 JavaScript Object Notaion 으로 객체를 표현하는 방법입니다.

Json은 xml과 마찬가지로 서버와 클라이언트 간의 데이터 송수신에 자주 사용됩니다.

Spring 프레임워크 에서는 Jackson 라이브러리를 통해 자바 객체와 Json을 변환합니다. (Object Mapper 역시 Jackson과 의존 관계)

Jackson은 기본적으로 메서드를 이용하여 자바 객체를 다룹니다. (getter, setter)

그렇기에 인스턴스 변수의 접근 제한자가 private등 이어도 getter/setter만 있으면 사용할 수 있습니다.



response를 application/json으로 하기 위한 간단한 방법으로는 아래와 같은 방법을 사용할 수 있습니다.
1. 직접 servletResponse를 조작한다. (Jackson, SimpleJson등 사용)
2. 컨트롤러 메서드의 반환 타입을 @ResponseBody, ResponseEntity<>등을 객체로 합니다. (권장)

## API
>학생 생성 API

URL : http://localhost:8080/v1/student/register [POST]

Require
- 교사 권한

Request Body

| key         | value       | info         |
|-------------|-------------|--------------|
| studentCode | String *Req | 학번 ex) 3311  |
| name        | String *Req | 이름 ex) 이찬혁   |

Response Body

String : 성공 여부

---

>학생 검색 API

URL : http://localhost:8080/v1/student/get [GET]

Require

- 교사 권한
- 학생 권한


Request Param

- studentCode [String *Req]

Response Body

| key         | value   | info          |
|-------------|---------|---------------|
| idx         | Long    | idx ex) 1..   |
| studentCode | String  | 학번 ex) 3311   |
| name        | String  | 이름 ex) 이찬혁    |

---

>학생 업데이트 API

URL : http://localhost:8080/v1/student/update [PUT]

Require

- 교사 권한

Request Body

| key         | value       | info            |
|-------------|-------------|-----------------|
| idx         | Long *Req   | idx ex) 1..     |
| studentCode | String *Req | 변경할 학번 ex) 3311 |
| name        | String *Req | 변경할 이름 ex) 이찬혁  |

Response Body

String : 성공 여부

---

>학생 삭제 API

URL : http://localhost:8080/v1/student/delete [DELETE]

Require

- 교사 권한

Request Param

- studentCode [String *Req]

Response Body

String : 성공 여부

---

## Authorization
> 인증 방법

Request Headers에 Authorization를 Key로 같은 value가 권한 정보,<br>
암호화 되어있지 않고 별도로 권한을 받을 방법이 없음

요청에 권한 정보를 추가하려면..
- Headers에 Authorization 추가
- Value는 아래 표에 명시된 권한 입력
- 요청

| value   | info                  |
|---------|-----------------------|
| student | 학생 권한, 읽기 가능          |
| teacher | 교사 권한, 읽기/생성/편집/삭제 가능 |

## Start Server
1. gradle 리로드
2. JDK 설치, Java 17 권장
2. key.yaml 파일 생성 및 편집
3. DB 및 Table 생성
4. 시작

key.yaml 구조

``` yaml
# src/main/resources/key.yaml

key:
    datasource:
        url: {데이터베이스 URL 입력}
        username: {사용자 명 입력}
        password: {비밀번호 입력}
```