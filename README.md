
# [F12조] 뉴스피드 프로젝트
## 요구사항
- [ ]  **사용자 인증 기능**
    - 회원가입 기능
    - 로그인 및 로그아웃 기능
        - JWT 활용
        - 사용자는 자신의 계정으로 서비스에 로그인하고 로그아웃 가능
- [ ]  **계정 관리**
    - 프로필 수정 기능
        - 이름, 한 줄 소개와 같은 기본적인 정보 수정
- [ ]  **게시물 CRUD 기능**
    - 게시물 작성, 조회, 수정, 삭제 기능
        - 게시물 조회를 제외한 나머지 기능들은 전부 인가(Authorization) 개념이 적용되어야 하며 이는 JWT와 같은 토큰으로 검증 가능.
        - 오로지 본인만 게시글 삭제 가능.
    
- [ ]  **뉴스 피드 기능**
    - 뉴스 피드 페이지(전체 조회 페이지)
        - 사용자가 다른 사용자의 게시물을 한 눈에 볼 수 있는 뉴스 피드 페이지가 있어야 합니다.

## ERD
![new-feed](https://github.com/F12-DevTools/news-feed-project/assets/40788498/7d0b6ede-af0b-4a7d-a7b6-46c85b4b83b2)


## API 명세서
![image](https://github.com/F12-DevTools/news-feed-project/assets/40788498/90c1f984-84bd-41f1-b365-d290b7c3abe2)
![image](https://github.com/F12-DevTools/news-feed-project/assets/40788498/d434f0b0-6eab-438b-ae66-a4daa1737aa5)
![image](https://github.com/F12-DevTools/news-feed-project/assets/40788498/9e22d97a-1e9a-4f42-88d1-a2d7b6174c99)
![image](https://github.com/F12-DevTools/news-feed-project/assets/40788498/806afeb5-4958-4693-a86e-98b5f2c86aae)
![image](https://github.com/F12-DevTools/news-feed-project/assets/40788498/250f7afa-f42f-4447-bafc-7ee65e1b84d9)
