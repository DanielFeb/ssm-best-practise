package indi.daniel.archessm.domain.shared.repository.ufw;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface DelayCommit {
    DelayPropagation propagation() default DelayPropagation.IMMEDIATE;
}
