# 학생 CRUD API
고등학교 학생 관리 서비스

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