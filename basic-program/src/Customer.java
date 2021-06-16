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
        String result = getName() + "고객님의 대여 기록 \n";
        for (Rental rental : this.rentals) {
            // 이번에 대여하는 비디오 정보와 대여료를 출력
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "\n";
        }
        result += "누적 대여료: " + String.valueOf(getTotalCharge()) + "\n";
        result += "적립 포인트: " + String.valueOf(getTotalFrequentRenterPoints());

        return result;
    }

    /**
     * html 내역을 생성하는 메서드
     * @return
     */
    public String htmlStatement(){
        String result = "<h1><em>" + getName() + "고객님의 대여 기록</em><h1> \n";
        for (Rental rental : this.rentals) {
            // 모은 대여 비디오 정보와 대여료를 출력
            result += "\t" + rental.getMovie().getTitle() + ": " + String.valueOf(rental.getCharge()) + "<br>\n";
        }
        result += "<p>누적 대여료: <em>" + String.valueOf(getTotalCharge()) + "</em></p>\n";
        result += "<p>적립 포인트: <em>" + String.valueOf(getTotalFrequentRenterPoints()) + "</em></p>";

        return result;
    }

    private double getTotalFrequentRenterPoints() {
        int result = 0;
        for (Rental rental : this.rentals) {
            result += rental.getFrequentRenterPoints();
        }
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        for (Rental rental : this.rentals) {
            result += rental.getCharge();
        }
        return result;
    }


}
