package com.example.student .entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class ApiResponse<T> {
  private final Status status;

  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private Metadata metadata;

  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private List<T> results;


  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private Object data;

  // 정상응답 생성자
  public ApiResponse(List<T> results) {
    this.status = new Status(2000, "OK");
    this.metadata = new Metadata(results.size());
    this.results = results;
  }

  // 에러응답 생성자

  public ApiResponse(int code, String message, Object data) {
    this.status = new Status(code, message);
    this.data = data;
  }


  // 내부 ->외부 접근 방지, 메모리 관리
  @Getter
  @AllArgsConstructor
  private static class Status {
    private int code;
    private String message;
  }

  @Getter
  @AllArgsConstructor
  private static class Metadata {
    private int resultCount = 0;
  }


}