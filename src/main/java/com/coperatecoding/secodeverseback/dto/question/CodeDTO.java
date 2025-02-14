package com.coperatecoding.secodeverseback.dto.question;

import com.coperatecoding.secodeverseback.domain.CodeStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

public class CodeDTO {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchCodeListRequest{
        private Long pk;
        private CodeStatus codeStatus;
        private Long questionPk;
        public static SearchCodeListRequest Codes(Long pk, CodeStatus CodeStatus, Long questionPk){
            return new SearchCodeListRequest(pk,CodeStatus,questionPk);
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class SearchCodeListResponse{
        private Long pk;
        private CodeStatus codeStatus;
        private Long questionPk;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddCodeRequest {
        private CodeStatus codeStatus;
        private String content;
        private String compileTime;
        private Double memory;
        private Double accuracy;
    }


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PageableCodeListRequest{
        private int cnt;
        private Long pk;
        private CodeStatus codeStatus;
        private Long questionPk;
        public static PageableCodeListRequest Codes(int cnt,Long pk, CodeStatus CodeStatus, Long questionPk){
            return new PageableCodeListRequest(cnt ,pk,CodeStatus,questionPk);
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class PageableCodeListResponse{
        private int cnt;
        private Long pk;
        private CodeStatus codeStatus;
        private Long questionPk;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class MyTrueQuestionResponseList {
        private int cnt;
        private List<CodeDTO.MyTrueQuestionResponse> list;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class MyTrueQuestionResponse {
        private LocalDateTime time; // 맞춘 날짜
        private int cnt; // 맞춘 개수
    }

}
