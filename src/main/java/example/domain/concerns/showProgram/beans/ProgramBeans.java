package example.domain.concerns.searchProgram.beans;

import java.util.List;

public class ProgramBeans {
    List<ProgramBean> list;

    public ProgramBeans(List<ProgramBean> list) {
        this.list = list;
    }

    public List<ProgramBean> getList() {
        return list;
    }
}
