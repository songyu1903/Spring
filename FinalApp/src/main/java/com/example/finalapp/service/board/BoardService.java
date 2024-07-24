package com.example.finalapp.service.board;

import com.example.finalapp.dto.board.BoardDetailDTO;
import com.example.finalapp.dto.board.BoardListDTO;
import com.example.finalapp.dto.board.BoardModifyDTO;
import com.example.finalapp.dto.board.BoardWriteDTO;
import com.example.finalapp.dto.board.file.FileWriteDTO;
import com.example.finalapp.dto.page.PageRequestDTO;
import com.example.finalapp.mapper.board.BoardMapper;
import com.example.finalapp.mapper.board.FileMapper;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;
    private final FileMapper fileMapper;

    @Value("${file.dir}")
    private String fileDir;

    public void addBoard(BoardWriteDTO boardWriteDTO){
        boardMapper.insertBoard(boardWriteDTO);
    }

    public void removeBoard(Long boardId){
        boardMapper.deleteBoard(boardId);
    }

    public void updateBoard(BoardModifyDTO boardModifyDTO){
        boardMapper.updateBoard(boardModifyDTO);
    }

    public BoardDetailDTO findBoard(Long boardId){
        return boardMapper.selectBoard(boardId)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 게시물 정보"));
    }

    public List<BoardListDTO> findBoardList(){
        return boardMapper.selectList();
    }

    public List<BoardListDTO> findListWithPage(PageRequestDTO pageRequestDTO){
        return boardMapper.selectListWithPage(pageRequestDTO);
    }
    public int findTotal(){
        return boardMapper.selectTotal();
    }

    // 파일 처리
    public void addBoardWithFiles(BoardWriteDTO boardWriteDTO, List<MultipartFile> files) throws  IOException{
        boardMapper.insertBoard(boardWriteDTO);

        for(MultipartFile file : files){
            FileWriteDTO fileWriteDTO = saveFile(file, boardWriteDTO.getBoardId());
            fileMapper.insertFile(fileWriteDTO);
        }
    }
    // 파일 저장 처리
    private FileWriteDTO saveFile(MultipartFile file, Long boardId) throws IOException {
        // 사용자가 업로드한 실제 파일 이름(확장자 포함)
        String originalFilename = file.getOriginalFilename();
        // 파일 이름 앞에 붙여줄 uuid 생성(파일 이름 중복이 나오지 않게 처리하기 위함)
        UUID uuid = UUID.randomUUID();
        // uuid와 파일 이름을 합쳐준다.
        String systemFilename = uuid.toString() + "_" + originalFilename;

        // 상위경로 fileDir : "C:/upload/"
        // 하위걍로 getUploadPath() : "2024/07/22"
        // 상위 경로와 하위 경로를 연결하여 하나의 파일 객체로 생성한다.
        File uploadFullPath = new File(fileDir, getUploadPath());

        // exists() : 실제 경로와 파일이 존재하는지 여부를 boolean 으로 반환
        if(!uploadFullPath.exists()){
            // mkdirs() : File 객체가 가진 경로를 생성해줌(폴더 만들어줌)
            uploadFullPath.mkdirs();
        }

        File uploadFile = new File(uploadFullPath, systemFilename);

        // 매개변수로 받은 파일을 우리가 만든 경로와 이름으로 저장한다.
        file.transferTo(uploadFile);

        // 모든 정보를 가진 FileWriteDTO 를 만들어 반환
        return FileWriteDTO.builder()
                .name(originalFilename)
                .uuid(uuid.toString())
                .uploadPath(getUploadPath())
                .boardId(boardId)
                .build();
    }
    // 파일이 저장되는 하위 경로를 현재 날짜로 설정할 것이기 때문에 현재 날짜를 포메팅하여 반환한다.
    private String getUploadPath(){

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String format = now.format(formatter);
        return null;
    }
}
