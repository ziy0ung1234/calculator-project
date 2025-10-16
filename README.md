# 계산기 만들기
## branch level1
- 양의정수 각2개, 사칙 연산 기호 1개 입력
  - 양의정수는 각각 하나씩 입력, int 타입으로 변수에 저장
  - 사칙연산 기호는 char 타입으로 변수 저장
- 연산 진행
    - switch문을 사용해 각 연산자에 맞게 진행
    - 나눗셈 연산에서 두번째정수에 0이 입력될 경우 오류 출력
- exit 문자열 입력 전까지 계산 진행
  - 각각의 인풋값 입력단계에서도 exit 입력시 연산 끝낼 수 있도록 로직 작성
  - 각각의 계산이 종료될때도 exit 입력할 수 있도록 작성
## branch level2
- 기능으로 클래스 분리
- Calculator 클래스
  - 사칙연산 수행
  - 인풋값 입력시 검증 메소드
  - 결과값 반환, 연산 결과 리스트는 ArrayDeque로저장
  - 연산결과 저장 필드는 접근제어자 private 사용
- CalculatorApp 클래스
  - 연산부분 제거
  - 연산 결과값은 getter 메소드로 출력
  - 연산 결과값은 각연산의 메소드에서 저장
  - 계산기 종료 전 가장 앞에 입력된 값 제거하고 출력
## branch level3
- 객체지향 특징(추상화, 캡슐화, 상속, 다형성) 에 위배되지 않도록 설계
  - 기존 Calculator 클래스에서 연산, 결과조회, 저장 다함 -> 클래스 분리
- OperatorType (enum) 클래스 - enum 매핑
  - 내부 getOperator 호출시 전달받은 연산기호와 맞는 enum 상수 리턴
  - 속성 필드 private로 연산을 위한 getter 메소드
- Operators 클래스 - 연산 기능
  - 속성은 전역으로 사용하고싶어서 public 설정
  - 람다식으로 필드 초기화
  - 두개의 double 값을 받아 double로 반환한다는 규칙의 내부 인터페이스 추가
  - 속성 초기화할때 기존 enum 맵핑에 사용했던 람다식 넣어줌
- ArithmeticCalculator 클래스 - 결과 조회/저장
  - 기존 연산을 enum의 apply 메서드에서 수행
  - 기존 ArrayDeque ArrayList로 수정 ( Lv2 가장 오래된값 삭제하는 메소드 동시에 제거)
  - 실수까지 계산 가능하도록 제네릭 Number 로 변경
- ArithmeticCalculatorApp 클래스 - 입출력
  -filterResults를 호출해 간접 접근으로 사용자가 입력한 값보다 큰 결과 리스트 가져옴