# Action Plan ๐
 
์ค๋์ ๋ชฉํ๋ฅผ ์ธ์ฐ๊ณ , ๋ค๋ฅธ ์ฌ๋๋ค๊ณผ ๊ณต์ ํ๋ฉฐ ์ฑ์ฅํ์ธ์!   
~~[http://hyeonju.shop]()~~ (AWS ๋น์ฉ๋ฌธ์ ๋ก ์๋ฒ๋ฅผ ๋ด๋ ธ์ต๋๋ค. 2021-07-25)

<br>

## 1. ์ ์ ๊ธฐ๊ฐ & ํ์ ์๊ฐ
- 2021๋ 7์ 9์ผ ~ 7์ 15์ผ
- 5์ธ 1์กฐ ํํ๋ก์ ํธ
	+ ๋ฐฑ์๋ (Spring) : ์ต๋ฏผ์, ๊น๋ฏผ์ฑ, ์ต์๊ท
	+ ํ๋ก ํธ์๋ (React) : ์ดํ์ฃผ, ์ ์ํ

<br>

## 2. ์ฌ์ฉ ๊ธฐ์ 
`Back-end`
- Java 8
- SpringBoot 2.5.2
- Gradle 7.0.2
- JPA
- MySQL 8.0

`Front-end`
-  React ([React Repository์ด๋](https://github.com/ActionPlan23/ActionPlanFront))

`deploy`
- AWS EC2 (Ubuntu 18.04 LTS)
- AWS RDS (MySQL 8.0)

<br>

## 3. ์คํํ๋ฉด

<img src="https://user-images.githubusercontent.com/70243735/125789215-b4ed27a2-9fc9-496a-a0cd-3c85ec01f45c.gif">

์์ธํ ์์ : https://youtu.be/-e2-VfU-984

<br>

## 4. ํ์ ๊ณผ์ 
- ํ๋ก์ ํธ ๊ด๋ฆฌ : [Projects์์ ํ์ธ](https://github.com/ActionPlan23/ActionPlanBack/projects/1)
- ์ค๊ณ
	+ Figma๋ฅผ ์ด์ฉํ์ฌ ์์ด์ดํ๋ ์ ๊ณต๋ ์ค๊ณ : [Wiki์์ ํ์ธ](https://github.com/ActionPlan23/ActionPlanBack/wiki/%EC%99%80%EC%9D%B4%EC%96%B4%ED%94%84%EB%A0%88%EC%9E%84-%EC%84%A4%EA%B3%84-%F0%9F%94%A8)
	+ ๋ธ์์ ์ด์ฉํ์ฌ API ๊ณต๋ ์ค๊ณ

- ๊ตฌํ   
	: ๋ชจ๋  ์์์ ๋ค์๊ณผ ๊ฐ์ ๊ณผ์ ์ ๊ฑฐ์ณค์ต๋๋ค.
	
	<img src="https://user-images.githubusercontent.com/70243735/125791537-1a050dcf-27ab-473f-9b87-332d9f98e4fe.png" width="700px">
	
	- Pull Request    
		: [PullRequest ํญ์์ ํ์ธํ๊ธฐ](https://github.com/ActionPlan23/ActionPlanBack/pulls?q=is%3Apr+is%3Aclosed)   
	- Code Review
		<details>
		<summary> ์ฝ๋๋ฆฌ๋ทฐ ๊ฐ๋ตํ๊ฒ ์ฟ๋ณด๊ธฐ :pushpin: </summary>

		<img src="https://user-images.githubusercontent.com/70243735/125799801-ad53c8e8-3442-4bae-b927-7121edf1fcc1.png" width ="700px">
	
		<img src="https://user-images.githubusercontent.com/70243735/125800048-579af209-9038-4bb9-a8ad-43e33c2ec8b7.png" width ="700px">
	

		</details>
	- Merge   
		: ๋ชจ๋  PR์ ๋ชจ๋  ํ์๋ค์ ์น์ธ์ ๊ฑฐ์น ํ์ Mergeํ์์ต๋๋ค.
	  

<br>

## 5. API ์ค๊ณ

<details>
   <summary> Plan API ์ค๊ณ:pushpin: </summary>
	
   <img src="https://user-images.githubusercontent.com/70243735/125796108-b92f6c12-b1de-4c49-b466-7313a58b7736.png" width ="700px">
	
</details>

<details>
   <summary> Reply API ์ค๊ณ:pushpin: </summary>
	
   <img src="https://user-images.githubusercontent.com/70243735/125797065-6bc32c0b-a625-4f68-b091-f69f856b638e.png" width="700px">
	
</details>

<details>
   <summary> MainPage API ์ค๊ณ:pushpin: </summary>
	
   <img src="https://user-images.githubusercontent.com/70243735/125797062-cfb04af1-9bee-4e5a-b805-f5afc15c99c0.png" width="700px">
	
</details>


<br>

## 6. ํต์ฌ ํธ๋ฌ๋ธ ์ํ
- Plan๊ณผ Reply์ ์ฐ๊ด๊ด๊ณ   
  : Git์ Issue์ Pull Request, Commit Message๋ฅผ ์ ๊ทน์ ์ผ๋ก ํ์ฉํ์ฌ ํ์๋ค๊ณผ ํจ๊ป ํด๊ฒฐํด๋๊ฐ์ต๋๋ค.   
- 1์ฐจ ์ํ) ์๋ฐฉํฅ
  : [๊ด๋ จ PRํ์ธํ๊ธฐ](https://github.com/ActionPlan23/ActionPlanBack/pull/6)
- 2์ฐจ ์ํ) ์๋ฐฉํฅ+EAGER
  : [๊ด๋ จ commit ํ์ธํ๊ธฐ](https://github.com/ActionPlan23/ActionPlanBack/commit/d5544cec9a6dbc0c2b06d375850406eae7e434df)
- 3์ฐจ ์ํ) ๋จ๋ฐฉํฅ
  : [๊ด๋ จ PRํ์ธํ๊ธฐ](https://github.com/ActionPlan23/ActionPlanBack/pull/13)
- 4์ฐจ ์ํ) ๋จ๋ฐฉํฅ + LAZY
  : [๊ด๋ จ PRํ์ธํ๊ธฐ](https://github.com/ActionPlan23/ActionPlanBack/pull/19)
- ์ญ์  ์ด์) ์ฐ๊ด๊ด๊ณ์ ์ญ์  ์ด์ ๋ฐ์ ๋ฐ ํด๊ฒฐ 
  : [๊ด๋ จ Issue์์ ํ์ธํ๊ธฐ](https://github.com/ActionPlan23/ActionPlanBack/issues/18) 

- ํต์ฌ ํธ๋ฌ๋ธ ์ํ ์ ๋ฆฌ ๋ฐ ํ๊ณ    
  : https://doing7.tistory.com/115   
  : ์ ํฌ ํ์ "**๋ ์ข์ ์ค๊ณ๋ฅผ ์ํด ํจ๊ป ๊ณ ๋ฏผ**"ํ์ต๋๋ค.   
  : ๊ฐ ์ํ ๋ฐ์์๋ง๋ค ์ด๋ค ์๊ฐ์ ๊ฐ์ง๊ณ , ์ด๋ป๊ฒ ํด๊ฒฐํด๋๊ฐ๋์ง์ ๋ํด ์์ธํ ํฌ์คํํ์์ต๋๋ค.   
