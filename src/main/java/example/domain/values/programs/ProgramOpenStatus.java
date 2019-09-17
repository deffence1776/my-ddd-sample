package example.domain.values.programs;

public enum ProgramOpenStatus {
    公開,非公開;

    public boolean isOpen(){
        return this.equals(公開);
    }
}
