# Action Plan 👊
 
오늘의 목표를 세우고, 다른 사람들과 공유하며 성장하세요!   
http://hyeonju.shop

<br>

## 1. 제작 기간 & 팀원 소개
- 2021년 7월 9일 ~ 7월 15일
- 5인 1조 팀프로젝트
	+ 백엔드 (Spring) : 최민서, 김민성, 최왕규
	+ 프론트엔드 (React) : 이현주, 신은혜

<br>

## 2. 사용 기술
`Back-end`
- Java 8
- SpringBoot 2.5.2
- Gradle 7.0.2
- JPA
- MySQL 8.0

`Front-end`
-  React ([React Repository이동](https://github.com/ActionPlan23/ActionPlanFront))

`deploy`
- AWS EC2 (Ubuntu 18.04 LTS)
- AWS RDS (MySQL 8.0)

<br>

## 3. 실행화면

<img src="https://user-images.githubusercontent.com/70243735/125789215-b4ed27a2-9fc9-496a-a0cd-3c85ec01f45c.gif">

자세한 영상 : https://youtu.be/-e2-VfU-984

<br>

## 4. 협업 과정
- 프로젝트 관리 : [Projects에서 확인](https://github.com/ActionPlan23/ActionPlanBack/projects/1)
- 설계
	+ Figma를 이용하여 와이어프레임 공동 설계 : [Wiki에서 확인](https://github.com/ActionPlan23/ActionPlanBack/wiki/%EC%99%80%EC%9D%B4%EC%96%B4%ED%94%84%EB%A0%88%EC%9E%84-%EC%84%A4%EA%B3%84-%F0%9F%94%A8)
	+ 노션을 이용하여 API 공동 설계

- 구현   
	: 모든 작업은 다음과 같은 과정을 거쳤습니다.
	
	<img src="https://user-images.githubusercontent.com/70243735/125791537-1a050dcf-27ab-473f-9b87-332d9f98e4fe.png" width="700px">
	
	- Pull Request    
		: [PullRequest 탭에서 확인하기](https://github.com/ActionPlan23/ActionPlanBack/pulls?q=is%3Apr+is%3Aclosed)   
	- Code Review
		<details>
		<summary> 코드리뷰 간략하게 엿보기 :pushpin: </summary>

		<img src="https://user-images.githubusercontent.com/70243735/125799801-ad53c8e8-3442-4bae-b927-7121edf1fcc1.png" width ="700px">
	
		<img src="https://user-images.githubusercontent.com/70243735/125800048-579af209-9038-4bb9-a8ad-43e33c2ec8b7.png" width ="700px">
	

		</details>
	- Merge   
		: 모든 PR은 모든 팀원들의 승인을 거친 후에 Merge하였습니다.
	  

<br>

## 5. API 설계

<details>
   <summary> Plan API 설계:pushpin: </summary>
	
   <img src="https://user-images.githubusercontent.com/70243735/125796108-b92f6c12-b1de-4c49-b466-7313a58b7736.png" width ="700px">
	
</details>

<details>
   <summary> Reply API 설계:pushpin: </summary>
	
   <img src="https://user-images.githubusercontent.com/70243735/125797065-6bc32c0b-a625-4f68-b091-f69f856b638e.png" width="700px">
	
</details>

<details>
   <summary> MainPage API 설계:pushpin: </summary>
	
   <img src="https://user-images.githubusercontent.com/70243735/125797062-cfb04af1-9bee-4e5a-b805-f5afc15c99c0.png" width="700px">
	
</details>


<br>

## 6. 핵심 트러블 슈팅
- Plan과 Reply의 연관관계   
  : Git의 Issue와 Pull Request, Commit Message를 적극적으로 활용하여 팀원들과 함께 해결해나갔습니다.   
- 1차 슈팅) 양방향
  : [관련 PR확인하기](https://github.com/ActionPlan23/ActionPlanBack/pull/6)
- 2차 슈팅) 양방향+EAGER
  : [관련 commit 확인하기](https://github.com/ActionPlan23/ActionPlanBack/commit/d5544cec9a6dbc0c2b06d375850406eae7e434df)
- 3차 슈팅) 단방향
  : [관련 PR확인하기](https://github.com/ActionPlan23/ActionPlanBack/pull/13)
- 4차 슈팅) 단방향 + LAZY
  : [관련 PR확인하기](https://github.com/ActionPlan23/ActionPlanBack/pull/19)
- 삭제 이슈) 연관관계시 삭제 이슈 발생 및 해결 
  : [관련 Issue에서 확인하기](https://github.com/ActionPlan23/ActionPlanBack/issues/18) 

- 핵심 트러블 슈팅 정리 및 회고   
  : https://doing7.tistory.com/115   
  : 저희 팀은 "**더 좋은 설계를 위해 함께 고민**"했습니다.   
  : 각 슈팅 발생시마다 어떤 생각을 가지고, 어떻게 해결해나갔는지에 대해 자세히 포스팅하였습니다.   
