package com.example.finalapp.schedule;

import com.example.finalapp.service.board.FileService;
import com.example.finalapp.vo.file.FileVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class FileSchedule {
    private final FileService fileService;

    @Value("${file.dir}")
    private String fileDir;

    /*
    cron 표현식
    7 개의 정보를 표현한다.
    초 분 시 일 월 요일 년도(년도는 생략 가능)

    * : 와일드 카드 (매 번)
    / : 증가 표현 0/15 == 0부터 15마다 (0, 15, 30, 45, ....)

     */
    @Scheduled(cron = "0/10 * * * * *")
    public void checkFiles() throws IOException {
        log.info("check files 실행@@@@");

//        어제 파일 리스트를 뽑아온다.
        List<FileVO> oldList = fileService.findOldList();

//        어제 파일들의 전체 경로를 List<Path>타입으로 저장한다.
        List<Path> fileListPath = oldList.stream()
                // fileDir : C:/upload/
                // uploadPath : 2024/07/25
                // Paths.get()에 여러 문자열을 ,로 넣어주면 알아서 / 처리를 하여 붙여준다.
                .map(vo -> Paths.get(fileDir, vo.getUploadPath(), vo.getUuid() + "_" + vo.getName()))
                .collect(Collectors.toList());

//        어제 썸네일 파일들의 전체 경로를 fileListPath에 추가한다.
        oldList.stream()
                .map(vo -> Paths.get(fileDir, vo.getUploadPath(), "th_" + vo.getUuid() + "_" + vo.getName()))
                .collect(Collectors.toList())
                .forEach(path -> fileListPath.add(path));

//        어제 파일들이 들어있는 폴더 경로를 저장한다.
        File directory = Paths.get(fileDir, getUploadPathOldFile()).toFile();

        File[] files = directory.listFiles(file -> !fileListPath.contains(file.toPath()));

        if (files == null) {
            return ;
        }

        for (File file : files) {
            log.info("파일 삭제 : {}", file.getPath());
            file.delete();
        }


    }

    private String getUploadPathOldFile(){
        LocalDate localDate = LocalDate.now();
        LocalDate oldDay = localDate.plusDays(-1);

        return oldDay.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }
}











