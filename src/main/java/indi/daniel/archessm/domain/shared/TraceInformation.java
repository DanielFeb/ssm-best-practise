package indi.daniel.archessm.domain.shared;

import indi.daniel.archessm.common.ApplicationConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.joda.time.DateTime;

import java.util.Date;

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
