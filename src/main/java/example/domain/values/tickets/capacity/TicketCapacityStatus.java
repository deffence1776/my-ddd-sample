package example.domain.values.tickets.capacity;

public enum TicketCapacityStatus {
    空席あり,残りわずか,満席;

    public boolean hasRoom() {
        return this.equals(空席あり)||this.equals(残りわずか);
    }

    public String message(){
        switch (this){
            case 満席:return "既に満席です。";
            case 残りわずか: return "残りわずかです。";
            case 空席あり: return "空席がございます。";
            default:return "";
        }
    }
}
