package F12.newsfeedproject.domain.user.constant;

import lombok.Getter;

@Getter
public enum UserRole {
  USER("user"), ADMIN("admin");

  private final String authority;

  UserRole(String authority) {
    this.authority = authority;
  }
}
