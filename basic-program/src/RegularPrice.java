public class RegularPrice extends Price{
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

    /**
     * 가격 책정 메서드
     * switch 문에서 타 객체의 속성을 사용하는것은 안좋다.
     * @return
     */
    @Override
    public double getCharge(int dayRented) {
        double result = 2;
        if(dayRented > 2){ // 대여일수가 3일 이상일때
            // 추가대여일수에 대한 누적 대여료 계산
            result += (dayRented - 2) * 1.5;
        }
        return result;
    }
}
