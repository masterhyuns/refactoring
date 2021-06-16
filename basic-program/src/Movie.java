public class Movie {
    public static final int CHILDRENS = 2; // 아동작
    public static final int REGULAR = 0;    // 고전작
    public static final int NEW_RELEASE = 1; // 신작
    private String title; // 제목
    private int priceCode; // 대여코드


    public Movie(String title, int priceCode){
        this.title = title;
        this.priceCode = priceCode;
    }
    public String getTitle() {
        return title;
    }
    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }

    /**
     * 가격 책정 메서드
     * switch 문에서 타 객체의 속성을 사용하는것은 안좋다.
     * @return
     */
    public double getCharge(int dayRented) {
        double result = 0;
        switch (getPriceCode()){
            case Movie.REGULAR: // 고전작일경우
                result += 2; // 누적대여료 +2
                if(dayRented > 2){ // 대여일수가 3일 이상일때
                    // 추가대여일수에 대한 누적 대여료 계산
                    result += (dayRented - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE: // 신작일 경우
                // 누적 대여로 일당 3
                result += dayRented * 3;
                break;
            case Movie.CHILDRENS: // 아동작일 경우
                result += 1.5; // 누적 대여로 +1.5
                if(dayRented > 3){// 대여일수가 4일 이상일때
                    // 추가대여일수에 대한 누적 대여료 계산
                    result += (dayRented - 3) * 1.5;
                }
                break;
        }
        return result;
    }

    /**
     * 최신물 대여시 추가 적릭급 지급
     * @return
     */
    public int getFrequentRenterPoints(int dayRented) {
        // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
        if((getPriceCode() == Movie.NEW_RELEASE) && dayRented > 1){
            return 2;
        }
        return 1;
    }
}
