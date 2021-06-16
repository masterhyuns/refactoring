public class NewReleasePrice extends Price{
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    /**
     * 가격 책정 메서드
     * switch 문에서 타 객체의 속성을 사용하는것은 안좋다.
     * @return
     */
    @Override
    public double getCharge(int dayRented) {
        // 누적 대여로 일당 3
        return dayRented * 3;
    }

    @Override
    public int getFrequentRenterPoints(int dayRented) {
        return dayRented > 1 ? 2 : 1;
    }
}
