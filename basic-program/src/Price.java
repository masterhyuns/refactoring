public abstract class Price {
    abstract int getPriceCode();
    abstract double getCharge(int dayRented);

    /**
     * 최신물 대여시 추가 적릭급 지급
     * @return
     */
    public int getFrequentRenterPoints(int dayRented) {
        return 1;
    }
}
