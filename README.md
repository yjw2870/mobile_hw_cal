# 2019년 2학기 모바일프로그래밍 과제

전자공학부 20153061 유재원

## [테스트 환경]
1. 안드로이드 스튜디오 SDK (Tools -> SDK Manager로 확인)
   - SDK 플랫폼 : Android 10.0(Q) ~ Android 6.0(Marshmallow) 
   - Android SDK Build-Tools
   - Android Emulator : 29.0.11
   - Android SDK Platform-Tools : 29.0.4
   - Android SDK Tools : 26.1.1
   - Intel x86 Emulator Accelerator (HXAM Installer) : 7.5.2
2. JDK-1.8.0 (명령어창(cmd)에서 c:\ java -version으로 확인)
   java version "1.8.0_221"
   Java(TM) SE Runtime Environment (build 1.8.0_221-b11)
   Java HotSpot(TM) 64-Bit Server VM (build 25.221-b11, mixed mode)
3. 안드로이드 스튜디오 실행 환경
   - Windows 10 Home, 64비트 운영체제(x64 기반 프로세서)
   
   
## 구현내용
### 1. 첫번째 화면 (Relative Layout 사용)
- 앱 접속 페이지, 회원 ID/비밀번호(EditView), 로그인/회원가입(Button)
- ID, PW 입력란(EditText)에서 Enter키를 입력시 로그인버튼 클릭으로 동작
- 로그인버튼 클릭시 사용자정보가 저장된 파일을 읽어 로그인 정보 확인
- ID, 비밀번호 입력 시 기존에 가입한 회원 ID, 비밀번호 체크 오류 시 에러 메시지 출력
- ID, 비밀번호 입력이 정상이고 로그인 버튼 클릭 시 세번째 페이지 이동 

### 2. 두번째 화면 (Linear Layout 사용)
- 회원가입 페이지, 첫번째 페이지에서 회원가입 버튼 클릭 시 출력
- ID(EditView), 비밀번호(EditView, 자릿수/특수키 등 규칙 체크) 입력받아 공백(space)를 제거하여 저장
- ID 중복확인 버튼 클릭시 사용자 정보 파일을 읽어 동일한 ID 존재여부 확인
- ID를 입력하지 않은 상태에서는 중복확인버튼 클릭불가
- PW를 입력하는 것을 실시간으로 확인하여 조건에 맞게 입력하였는지 실시간으로 확인가능
- PW를 재입력하는 EditText를 만들어 앞서 입력한 PW와 다를경우 일치 하지 않음을 실시간으로 확인가능
- 이름/전화번호/주소(EditView) 입력받아 공백(space)를 제거하여 저장
- 개인정보 사용 동의 간략 약관(TextView), 동의 여부(Radio Button, Decline/Accept)
- 동의 여부에서 동의하지 않을 경우 회원가입 불가
- 회원정보는 ID, PW, 이름, 전화번호, 주소를 공백(space)로 구분하여 파일에 한줄로 저장하고 첫번째 페이지로 이동

### 3. 세번째 화면 (Linear Layout, Grid Layout사용)
- 첫번째 페이지에서 ID, 비밀번호 입력 시 정상이고 로그인 버튼 클릭 시 화면 출력
- 계산기 화면으로 구성
- GridLayout을 이용하여 숫자버튼과 계산버튼 구현
- 숫자버튼을 클릭하므로써 입력된 숫자가 결과창에 표시됨
- 연산버튼을 클릭시 결과창에 입력되어있던 값과 연산기호가 위창으로 출력
- FIFO방식으로 먼저 입력된 연산이 수행되며 진행중인 계산은 위창에 출력되고 현재까지 진행된 결과값은 결과창에 출력
- '='버튼을 클릭할시 위 창에 값은 사라지고 결과창에만 결과값이 출력
- 'Clear'버튼을 클릭시 계산기 초기화
