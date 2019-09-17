package example.domain.values.programs;

public enum RunningStatus {
    上演前("上演前です。",false)
    ,上演中("現在上演中です。",false)
    ,上演終了("上演は終了しました。",true);

    String msg;
    boolean isFinished;

    RunningStatus(String msg, boolean isFinished) {
        this.msg = msg;
        this.isFinished = isFinished;
    }

    public boolean isFinished(){
        return isFinished;
    }

    public String message(){
        return  msg;
    }
}
