package developer.domain.communityComment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import developer.domain.community.entity.Community;
import developer.domain.member.entity.Member;
import developer.global.audit.Auditable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Comment extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentId;
    @Column(nullable=false)
    private String content;

    @ManyToOne
    @JoinColumn(name="communityId")
    @JsonIgnore
    private Community community;


    @ManyToOne
    @JoinColumn(name = "memberId")
    @JsonIgnore
    private Member member;


    @Builder
    public Comment(long commentId, String content, Community community, Member member) {
        this.commentId = commentId;
        this.content = content;
        this.community = community;
        this.member = member;
    }

    public long getCommentId() {
        return commentId;
    }
}
