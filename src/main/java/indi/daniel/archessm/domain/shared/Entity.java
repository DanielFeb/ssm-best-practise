package indi.daniel.archessm.domain.shared;

/**
 * An entity, as explained in the DDD book.
 *  
 */
public interface Entity<T extends Entity, ID extends Identity> {
  ID id();

  /**
   * Entities compare by identity, not by attributes.
   *
   * @param other The other entity.
   * @return true if the identities are the same, regardless of other attributes.
   */
  default boolean sameIdentityAs(T other) {
    return this.id().sameValueAs(other.id());
  }

}
