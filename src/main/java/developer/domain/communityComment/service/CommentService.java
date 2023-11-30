package developer.domain.communityComment.service;


import developer.domain.communityComment.entity.Comment;
import developer.domain.communityComment.repository.CommentRepository;
import developer.global.exception.BusinessLogicException;
import developer.global.exception.ExceptionCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment createComment(Comment comment){

        return commentRepository.save(comment);
    }
    public Comment updateComment(Comment comment) {

        Comment findComment = findVerifiedComment(comment.getCommentId());

        Optional.ofNullable(comment.getContent())
                .ifPresent(text->findComment.setContent(text));

        return commentRepository.save(findComment);
    }

    public void deleteComment(long commentId) {

        Comment comment	= commentRepository.findById(commentId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.COMMENT_NOT_FOUND));

        commentRepository.delete(comment);
    }
    public Page<Comment> findComments(Pageable pageable){

        return commentRepository.findAll(pageable);
    }

    public Comment findComment(Long commentId) {
        return findVerifiedComment(commentId);
    }

    public Comment findVerifiedComment(long c_id) {
        Optional<Comment> optionalBoard =
                commentRepository.findById(c_id);

        return optionalBoard.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.COMMENT_NOT_FOUND));
    }


}
