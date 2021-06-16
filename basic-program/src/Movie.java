public class Movie {
    public static final int CHILDRENS = 2; // 아동작
    public static final int REGULAR = 0;    // 고전작
    public static final int NEW_RELEASE = 1; // 신작
    private String title; // 제목
    private Price price; // 대여코드


    public Movie(String title, int priceCode){
        this.title = title;
        setPriceCode(priceCode);
    }
    public String getTitle() {
        return title;
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode){
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDRENS:
                price = new ChildrenPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("가격 코드가 잘못되었습니다.");
        }
    }

    double getCharge(int dayRented){
        return price.getCharge(dayRented);
    }
    int getFrequentRenterPoints(int dayRented){
        return price.getFrequentRenterPoints(dayRented);
    }

}
