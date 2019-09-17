package example.domain.concerns.searchHolding.beans;

import java.util.List;

/**
 * 演目開催グループ
 */
public class ProgramHoldingBeans {
    List<ProgramHoldingBean> list;

    public ProgramHoldingBeans(List<ProgramHoldingBean> list) {
        this.list = list;
    }

    public List<ProgramHoldingBean> getList() {
        return list;
    }
}
