import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name; // 고객명
    private List<Rental> rentals = new ArrayList<>(); // 렌탈 내역

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg){
        this.rentals.add(arg);
    }

    public String getName(){
        return name;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    /**
     * 내역을 생성하는 메서드
     * @return
     */
    public String statement(){
        double totalAmount = 0; // 누적 대여료
        int frequentRenterPoints = 0; // 적립 포인트

        String result = getName() + "고객님의 대여 기록 \n";
        for (Rental rental : this.rentals) {
            // 적립 포인트를 1 증가
            frequentRenterPoints++;
            // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
            if((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDayRented() > 1){
                frequentRenterPoints++;
            }
            // 이번에 대여하는 비디오 정보와 대여료를 출력
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "\n";
            // 현재까지 누적된 총 대여료
            totalAmount += rental.getCharge();
        }
        result += "누적 대여료: " + String.valueOf(totalAmount) + "\n";
        result += "적립 포인트: " + String.valueOf(frequentRenterPoints);

        return result;
    }
}
