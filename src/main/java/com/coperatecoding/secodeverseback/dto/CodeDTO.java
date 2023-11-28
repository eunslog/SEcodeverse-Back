package com.coperatecoding.secodeverseback.dto;

import com.coperatecoding.secodeverseback.domain.CodeLanguage;
import com.coperatecoding.secodeverseback.domain.CodeStatus;
import com.coperatecoding.secodeverseback.domain.Language;
import com.coperatecoding.secodeverseback.domain.User;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.sql.Time;

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
    public static class addCodeRequest{
        private int codeStatus;
        private String content;
        private String compileTime;
        private Long memory;
        private Integer accuracy;


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
}
