public class Rental {
    private Movie movie; // 영화
    private int dayRented; // 대여일수

    public Rental(Movie movie, int dayRented){
        this.movie = movie;
        this.dayRented = dayRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDayRented() {
        return dayRented;
    }

    public double getCharge() {
        double result = 0;
        switch (getMovie().getPriceCode()){
            case Movie.REGULAR: // 고전작일경우
                result += 2; // 누적대여료 +2
                if(getDayRented() > 2){ // 대여일수가 3일 이상일때
                    // 추가대여일수에 대한 누적 대여료 계산
                    result += (getDayRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE: // 신작일 경우
                // 누적 대여로 일당 3
                result += getDayRented() * 3;
                break;
            case Movie.CHILDRENS: // 아동작일 경우
                result += 1.5; // 누적 대여로 +1.5
                if(getDayRented() > 3){// 대여일수가 4일 이상일때
                    // 추가대여일수에 대한 누적 대여료 계산
                    result += (getDayRented() - 3) * 1.5;
                }
                break;
        }
        return result;
    }

    /**
     * 최신물 대여시 추가 적릭급 지급
     * @return
     */
    public int getFrequentRenterPoints() {
        // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
        if((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDayRented() > 1){
            return 2;
        }
        return 1;
    }
}
