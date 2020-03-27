package indi.daniel.archessm.domain.shared.repository;

import indi.daniel.archessm.common.ApplicationConstants;
import indi.daniel.archessm.domain.shared.core.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.joda.time.DateTime;

@AllArgsConstructor
@Getter
public class TraceInformation implements ValueObject<TraceInformation> {

    private Long createBy;

    private DateTime createDate;

    private Long lastUpdateBy;

    private DateTime lastUpdateDate;

    public static final TraceInformation EMPTY_TRACE_INFORMATION =
            new TraceInformation(0L, ApplicationConstants.DEFAULT_DATETIME, 0L, ApplicationConstants.DEFAULT_DATETIME);
    @Override
    public boolean sameValueAs(TraceInformation other) {
        return this == other || (
                this.createBy.equals(other.createBy) &&
                this.createDate.equals(other.createDate) &&
                this.lastUpdateBy.equals(other.lastUpdateBy) &&
                this.lastUpdateDate.equals(other.lastUpdateDate)
        );
    }
}
