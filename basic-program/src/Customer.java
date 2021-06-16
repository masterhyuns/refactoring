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

    /**
     * 내역을 생성하는 메서드
     * @return
     */
    public String statement(){
        double totalAmount = 0; // 누적 대여료
        int frequentRenterPoints = 0; // 적립 포인트

        String result = getName() + "고객님의 대여 기록 \n";
        for (Rental rental : this.rentals) {
            double thisAmount = 0;
            thisAmount = amountFor(rental);
            // 적립 포인트를 1 증가
            frequentRenterPoints++;
            // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
            if((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDayRented() > 1){
                frequentRenterPoints++;
            }
            // 이번에 대여하는 비디오 정보와 대여료를 출력
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            // 현재까지 누적된 총 대여료
            totalAmount += thisAmount;
        }
        result += "누적 대여료: " + String.valueOf(totalAmount) + "\n";
        result += "적립 포인트: " + String.valueOf(frequentRenterPoints);
        return result;
    }

    private double amountFor(Rental rental) {
        double result = 0;
        switch (rental.getMovie().getPriceCode()){
            case Movie.REGULAR: // 고전작일경우
                result += 2; // 누적대여료 +2
                if(rental.getDayRented() > 2){ // 대여일수가 3일 이상일때
                    // 추가대여일수에 대한 누적 대여료 계산
                    result += (rental.getDayRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE: // 신작일 경우
                // 누적 대여로 일당 3
                result += rental.getDayRented() * 3;
                break;
            case Movie.CHILDRENS: // 아동작일 경우
                result += 1.5; // 누적 대여로 +1.5
                if(rental.getDayRented() > 3){// 대여일수가 4일 이상일때
                    // 추가대여일수에 대한 누적 대여료 계산
                    result += (rental.getDayRented() - 3) * 1.5;
                }
                break;
        }
        return result;
    }
}
