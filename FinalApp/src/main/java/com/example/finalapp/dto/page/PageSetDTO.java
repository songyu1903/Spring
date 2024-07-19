package com.example.finalapp.dto.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class PageSetDTO {
    // 페이지 세트당 표시될 수
    private int pageCount;
    // 페이지 세트의 시작 숫자
    private int startPage;
    // 페이지 세트의 마지막 숫자
    private int endPage;
    // 실제 가장 마지막 페이지 숫자
    private int realEnd;
    // 이전 버튼 표시 여부
    private boolean prev;
    // 다음 버튼 표시 여부
    private boolean next;
    // 전체 게시글 수
    private int total;
    // 화면에서 전달받은 page, amount 저장하는 객체
    private PageRequestDTO pageRequestDTO;


    public PageSetDTO(int total, PageRequestDTO pageRequestDTO) {
        this(pageRequestDTO, total, 5);
    }

    public PageSetDTO(PageRequestDTO pageRequestDTO, int total, int pageCount) {
        this.pageRequestDTO = pageRequestDTO;
        this.total = total;
        this.pageCount = pageCount;

//        현재 페이지를 기준으로 세트의 마지막 번호, 시작번호를 계산한다.
//        Math : 수학 공식 메서드
//        ceil() : 올림 처리
        this.endPage = (int)(Math.ceil(pageRequestDTO.getPage() / (double)pageCount)) * pageCount;

        this.startPage = endPage - pageCount + 1;

//        게시글 전체 개수로 실제 마지막 페이지를 구한다.
        this.realEnd = (int)Math.ceil((double)total / pageRequestDTO.getAmount());

//        세트의 마지막 번호보다 실제 마지막 페이지가 작다면?
        if(realEnd < endPage) {
//            세트의 마지막 번호를 실제 마지막 페이지로 변경해라
            this.endPage = realEnd == 0 ? 1 : realEnd;
        }

        this.prev = startPage > 1;
        this.next = endPage < realEnd;
    }

}
