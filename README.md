# Lifrary

팀프로젝트 github주소  :[팀작업 github바로가기](https://github.com/shohye/Lifrary)  
프로젝트 주소 :  [프로젝트 바로가기](http://tkdguq93.cafe24.com)
<hr/>


* 프로젝트명  
 전국민 독서량 증진과 도서관 방문율을 향상시키는 **도서관통합관리시스템( Lifrary )**  
 ※ Lifrary란?  
 - Life + library로, 생활속의 도서관을 의미하는 합성어입니다.
#
* 개발 기간  
> 2019-10-24 ~ 2019-11-01  
&ensp;&ensp;프로젝트 주제 선정 및 사전조사

> 2019-11-02 ~ 2019-12-01  
&ensp;&ensp;프로젝트 설계(기능정의, 테이블 구상)  
&ensp;&ensp;설계자료 취합, 수정 및 보완  
&ensp;&ensp;ERD 작업 및 메서드, 패키지 정리

> 2019-12-02 ~ 2019-12-03  
&ensp;&ensp;서버 설정  
&ensp;&ensp;개발환경 설정  
&ensp;&ensp;Hosting 설정

> 2019-12-03 ~ 2020-01-09  
&ensp;&ensp;기능 구현(개인 분담 프로그래밍)

> 2019-12-30 ~ 2020-01-09  
&ensp;&ensp;테스트, 오류 수정 및 보완

> 2020-01-10 ~ 2020-01-13  
&ensp;&ensp;결과 보고서 작성

#
*  개발 목표  
&ensp;&ensp;1. 개인 독서 공간 제공과 목표량 및 포인트 제도를 도입하여 지속적인 독서량 증진과 도서관 방문을 늘리게 한다.  
&ensp;&ensp;2. 도서관리 단순화와 일괄된 도서관페이지 관리 시스템으로 효율적이고 통일된 관리를 목표로 한다.  
&ensp;&ensp;3. 전국 도서관간의 데이터를 공유하여 다양한 통계와 자료를 제공할 수 있다.  

# 
* 기대 효과  
&ensp;&ensp;1. 나만의 독서공간을 마련하여 독서 상황을 기록할 수 있으며, 포인트 제도를 도입하여  도서관사이트를 지속적으로 이용하게 할 수 있다.  
&ensp;&ensp;2. 도서정보 반입과 도서관에 따른 청구기호 생성 등 간편한 도서 등록 시스템으로 빠른 작업이 가능하며, 적은 인원으로도 도서관리를 할 수 있다.  
&ensp;&ensp;3. 다양한 문화행사, 강좌 제공 및 편리한 공공시설 예약시스템으로 이용자가 증가하는것을 기대할 수 있다.  

#
* 내가 맡은 구현 기능  
![Alt text](lifrary/src/main/resources/static/portfolioStatic/images/implement.PNG)

#
* 개발 과정
&ensp;&ensp; 시스템구조도작성, 기능정의, 프로세스정의 및 Data사전, 상세자료입력, 테이블스키마, ERD작성, Query문장테스트, UI설계, 네이밍규칙, 구현, 배포

#
* 프로젝트 기능  
> 1. 로그인/로그아웃 관리  
&ensp;&ensp; 도서관 페이지 : 회원 로그인 기능  
&ensp;&ensp; 도서관 관리자 페이지 : 사서/관리자 로그인 기능  

> 2. 회원관리(회원관리, 등급, 권한)  
&ensp;&ensp; 도서관 페이지 : 회원 정보 수정/탈퇴  
&ensp;&ensp; 도서관 관리자 페이지 : 회원정보 (수정, 삭제),  등급/권한(등록,수정,삭제), 등급/권한이력리스트  

> 3. 사서관리(사서관리, 사서이용자관리)  
&ensp;&ensp; 도서관 관리자 페이지 : 사서-사서정보 (수정,삭제)  
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&ensp;&ensp;관리자 - 사서권한 (등록,수정,삭제)  

> 4. 포인트관리  
&ensp;&ensp; 도서관 페이지 : 포인트 이력, 포인트 사용  
&ensp;&ensp; 도서관 관리자 페이지 : 포인트 설정(등록, 수정, 삭제), 포인트 이력  

> 5. 도서관리(수서, 소장도서)  
&ensp;&ensp; 도서관 페이지 : 도서조회  
&ensp;&ensp; 도서관 관리자 페이지 : 도서반입, 도서관리(추가,수정,삭제), 장서점검  

> 6. 대출/예약/반납 관리  
&ensp;&ensp; 도서관 페이지 : 도서예약  
&ensp;&ensp; 도서관 관리자 페이지 : 대출,예약,반납 기록관리, 포인트부여  

> 7. 공공시설 관리  
&ensp;&ensp; 도서관 페이지 : 시설예약,연장  
&ensp;&ensp; 도서관 관리자 페이지 : 시설관리(추가,수정,삭제), 이용자 이용관리  

> 8. 독서기록 관리  
&ensp;&ensp; 도서관 페이지 : 독후감, 독서기록, 서재  

> 9. 관내 행사 관리  
&ensp;&ensp; 도서관 페이지 : 행사 참여신청,행사 참여 확인/취소처리  
&ensp;&ensp; 도서관 관리자 페이지 : 행사 등록/수정, 행사 참여자 리스트 확인  

> 10. 공공시설 예약 관리  
&ensp;&ensp; 도서관 페이지 : 공공시설 예약, 취소, 예약 확인  
&ensp;&ensp; 도서관 관리자 페이지 : 공공시설 등록, 수정, 삭제,사용중인 회원 리스트 확인  

> 11. 게시판  
&ensp;&ensp; 도서관 페이지 : 문의하기 등록  
&ensp;&ensp; 도서관 관리자 페이지 : 문의답변, 공지사항, 추천도서 등록  
