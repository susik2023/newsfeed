package F12.newsfeedproject.domain.board.entity;

import F12.newsfeedproject.domain.common.Timestamped;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends Timestamped {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long boardId;

  @Column(nullable = false)
  private String boardTitle;

  @Column(nullable = false)
  private String boardContent;

  public void update(Board updateBoard) {
    boardTitle = updateBoard.getBoardTitle();
    boardContent = updateBoard.getBoardContent();
  }
}
