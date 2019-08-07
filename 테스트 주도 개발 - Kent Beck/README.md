## 테스트 주도 개발 - 켄트 벡

![image](https://user-images.githubusercontent.com/25674959/62582146-5d5ee600-b8e6-11e9-9cb1-c2095915a967.png)

&nbsp;
&nbsp;

#### 2019/ 08/ 07
> 켄트 벡 TDD 의 1부에 화폐 예제가 나온다.  
처음 TDD 책을 접했을 때 타이핑 안하고 읽기만 했었는데,  
Money 클래스를 리팩토링하던 과정이 기억이 안나서 코드를 따라서 쳐보려고 한다.

&nbsp;
&nbsp;

### 요구사항 (기능)

1. $5 + 10CHF = $10 (환율이 2:1일 경우)
2. ~~$5 * 2 = $10~~
3. ~~amount를 private로 만들기~~
4. ~~Doller 부작용 (side effect)?~~
5. Money 반올림?
6. ~~equals()~~
7. hashCode()