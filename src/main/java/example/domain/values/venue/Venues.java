package example.domain.values.venue;

import java.util.List;

/**
 * 会場コレクション
 */
public class Venues {
    List<Venue> list;

    public Venues(List<Venue> list) {
        this.list = list;
    }

    public String showSimple(){
        if(list.isEmpty()){
            return "";
        }
        if(list.stream().distinct().count()>1) {
            return "-";
        }
        return list.get(0).toString();
    }
}
