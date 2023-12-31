package developer.domain.community.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

public class CommunityDto {

    @Getter
    @Setter
    public static class Post {
        private Long memberId;
        @NotBlank(message = "제목은 필수 입력 사항입니다.")
        @Size(max = 250, message = "제목은 250자를 넘을 수 없습니다.")
        private String title;
        @NotBlank(message = "내용은 필수 입력 사항입니다.")
        private String body;
        @NotBlank
        private String imgURL;
        private String category;
        private List<String> tags;
    }

    @Getter @Setter
    public static class Patch {
        private Long memberId;
        @Size(max = 250, message = "제목은 250자를 넘을 수 없습니다.")
        private String title;
        private String body;
        private String imgURL;
        private String category;
        private List<String> tags;
    }

    @Getter @Setter
    @AllArgsConstructor
    public static class Response {
        private String userNickname;
        private Long communityId;
        private String title;
        private String body;
        private String imgURL;
        private String category;
        private List<String> tags;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
    }


}
