package hello.core.singleton;

public class SingletonService {

    // static 영역에 객체 instance를 미리 하나 생성해서 올려둔다.
    // 이 객체 인스턴스가 필요하면 오직 getInstance() 메서드를 통해서만 조회할 수 있다.
    // static 영역은 클래스 레벨에 올라가기 때문에 딱 하나만 존재하게 된다.
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }
    // 생성자를 private로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다.
    private SingletonService() {
    }

    public  void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
