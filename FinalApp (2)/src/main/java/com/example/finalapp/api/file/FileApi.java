package com.example.finalapp.api.file;

import com.example.finalapp.dto.board.file.FileListDTO;
import com.example.finalapp.service.board.FileService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FileApi {
    private final FileService fileService;

    @Value("${file.dir}")
    private String fileDir;

    @GetMapping("/boards/{boardId}/files")
    public List<FileListDTO> imgList(@PathVariable("boardId") Long boardId){
        return fileService.findList(boardId);
    }

//    로컬 PC에 있는 파일 데이터를 바이트 배열로 복사하여 전송해주는 메서드
    @GetMapping("/display")
    public byte[] display(String fileName) throws IOException {
        File file = new File(fileDir, fileName);
        byte[] bytes = FileCopyUtils.copyToByteArray(file);
        return bytes;
    }

    @GetMapping("/download")
//    HttpServletResponse 와 동일하게 ResponseEntity객체는 응답을 나타내는 객체이다.
//    스프링에서 지원하는 응답객체이며, 기존의 응답 객체보다 간편하게 설정할 수 있다는 장점이 있다.
    public ResponseEntity<Resource> download(String fileName) throws UnsupportedEncodingException {
//        Resource객체는 말 그대로 자원을 나타내는 객체이다. 스프링에서 지원하는 타입이다.
//        우리는 파일이라는 리소스를 다운로드 처리하기 위해 사용하고 있으며, File객체 보다
//        많은 종류의 리소스를 다룰 수 있고 스프링과의 호환성이 좋다.
//        Resource는 인터페이스이므로 객체를 만들 때는 자식클래스를 사용한다.

        Resource resource = new FileSystemResource(fileDir + fileName);

        String downloadName = resource.getFilename();
        int idx = downloadName.indexOf("_") + 1;
        downloadName = downloadName.substring(idx);
        downloadName = URLEncoder.encode(downloadName, "utf-8");


        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "attachment;filename=" + downloadName);
//        httpHeaders.setContentDisposition(ContentDisposition.attachment().build());

        ResponseEntity<Resource> responseEntity = new ResponseEntity<>(resource, httpHeaders, HttpStatus.OK);

        return responseEntity;
    }


}












