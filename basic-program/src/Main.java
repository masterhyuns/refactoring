import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        Movie movie1 = new Movie("신작무비1", Movie.NEW_RELEASE);
        Movie movie2 = new Movie("신작무비2", Movie.NEW_RELEASE);
        Movie movie3 = new Movie("고전무비1", Movie.REGULAR);
        Movie movie4 = new Movie("고전무비2", Movie.REGULAR);
        Movie movie5 = new Movie("아동무비1", Movie.CHILDRENS);
        Movie movie6 = new Movie("아동무비2", Movie.CHILDRENS);

        Customer customer = new Customer("홍길동");
        List<Rental> rentals = new ArrayList<>();
        rentals.add(new Rental(movie1, 3));
        rentals.add(new Rental(movie2, 2));
        rentals.add(new Rental(movie3, 3));
        rentals.add(new Rental(movie4, 4));
        rentals.add(new Rental(movie5, 1));
        rentals.add(new Rental(movie6, 1));

        customer.setRentals(rentals);
        System.out.println("#####################");
        System.out.println(customer.statement());
        System.out.println("#####################");

        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = afterTime - beforeTime; //두 시간에 차 계산
        System.out.println("시간차이(m) : "+secDiffTime);

    }
}
