package indi.daniel.archessm.infrastructures.repository.common;

import indi.daniel.archessm.domain.shared.repository.TraceInformation;
import org.joda.time.DateTime;

public interface Traceable {

    Long getCreateBy();

    void setCreateBy(Long createBy);

    DateTime getCreateDate();

    void setCreateDate(DateTime createDate);

    Long getLastUpdateBy();

    void setLastUpdateBy(Long lastUpdateBy);

    DateTime getLastUpdateDate();

    void setLastUpdateDate(DateTime lastUpdateDate);

    default void setTraceInformation(indi.daniel.archessm.domain.shared.repository.Traceable traceable) {
        setTraceInformation(traceable.getTraceInformation());
    }

    default void setTraceInformation(TraceInformation traceInformation) {
        this.setCreateBy(traceInformation.getCreateBy());
        this.setCreateDate(traceInformation.getCreateDate());
        this.setLastUpdateBy(traceInformation.getLastUpdateBy());
        this.setLastUpdateDate(traceInformation.getLastUpdateDate());
    }

    default TraceInformation getTraceInformation() {
        return new TraceInformation(this.getCreateBy(), this.getCreateDate(), this.getLastUpdateBy(), this.getLastUpdateDate());
    }
}
