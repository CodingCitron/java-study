public class Main {

    // public: 접근 제어자 - public은 누구나 이 메소드에 접근할 수 있다는 의미
    // class: 클래스 블록을 만드는 키워드
    // static: 메소드에 static이 지정되어 있는 경우 이 메소드는 인스턴스 생성없이 실행 가능
    // static 키워드를 사용한 변수는 클래스가 메모리에 올라갈 때 자동으로 생성이 된다.
    // 인스턴스 생성 없이 바로 사용 가능하기 때문에 프로그램 내에서 공통으로 사용되는 데이터들을 관리할 때 이용
    // 값 을 변경해 줄 경우 클래스 이름을 앞에 사용

    // void 메소드의 린턴 값이 없음 (void: 사전적으로 텅 빈이라는 뜻)
    // return: 실행중인 메소드를 종료하고 호출한 곳으로 되돌아간다. - 반환값이 void가 아닐 경우 반드시 return문 필요
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}