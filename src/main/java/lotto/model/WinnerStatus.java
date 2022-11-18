package lotto.model;

public enum WinnerStatus {
    _5th("3개", 5000, 0),
    _4th("4개", 50000, 0),
    _3rd("5개", 1500000, 0),
    _2nd("5개 일치, 보너스 볼", 30000000, 0),
    _1st("6개", 2000000000, 0),
    ;

    private final String label;
    private final int price;

    private int amount;
    WinnerStatus(String label, int price, int amount) {
        this.label = label;
        this.price = price;
        this.amount = amount;
    }

    public String getLabel() {
        return label;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return this.amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTotal(){
        return this.amount * this.price;
    }

//    private static final Map<String, Day> BY_LABEL =
//            Stream.of(values()).collect(Collectors.toMap(Day::label, Function.identity()));
//
//    private static final Map<Integer, Day> BY_NUMBER =
//            Stream.of(values()).collect(Collectors.toMap(Day::number, Function.identity()));
//
//    public static Day valueOfLabel(String label) {
//        return BY_LABEL.get(label);
//    }
//
//    public static Day valueOfNumber(int number) {
//        return BY_NUMBER.get(number);
//    }
}
