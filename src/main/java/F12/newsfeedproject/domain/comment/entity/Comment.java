package F12.newsfeedproject.domain.comment.entity;

import F12.newsfeedproject.api.comment.dto.CommentRequestDTO;
import F12.newsfeedproject.domain.board.entity.Board;
import F12.newsfeedproject.domain.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long commentId;

  @Column(nullable = false)
  private String commentContent;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "board_id")
  private Board board;

  @Column
  private LocalDateTime createDate;

  public Comment(CommentRequestDTO dto) {
    this.commentContent = dto.getCommentContent();
    this.createDate = LocalDateTime.now();
  }

  public void setUser(User user) {
    this.user = user;
  }

//    public void setBoard(Board board) {
//        this.board = board;
//        board.getComments().add(this);
//    }

  // 서비스 메서드
  public void setCommentContent(String commentContent) {
    this.commentContent = commentContent;
  }
}
