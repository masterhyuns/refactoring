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
}
