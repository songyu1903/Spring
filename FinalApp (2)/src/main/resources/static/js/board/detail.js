import * as comm from '../modules/comment.js';

{ // 버튼 처리
    let $backBtn = document.querySelector('.btn-back');

    $backBtn.addEventListener('click', () => {
        window.history.back();
    });

    let $removeBtn = document.querySelector('.btn-remove');

    $removeBtn?.addEventListener('click', function () {
        let boardId = this.dataset.id;

        location.href = `/board/remove?boardId=${boardId}`;
    });

    let $modifyBtn = document.querySelector('.btn-modify');

    $modifyBtn?.addEventListener('click', function () {
        let boardId = this.dataset.id;

        location.href = `/board/modify?boardId=${boardId}`;
    });
}

{   // 첨부 이미지 출력 처리

    displayImg();

    function displayImg() {
        let boardId = document.querySelector('.btn-back').dataset.id;

        fetch(`/boards/${boardId}/files`)
            .then(resp => resp.json())
            .then(list => {
                console.log(list)

                let tags = '';

                list.forEach(dto => {
                    let fileName = dto.uploadPath + '/' + dto.uuid + '_' + dto.name;
                    tags += `<a href="/download?fileName=${fileName}">
                                <img src="/display?fileName=${fileName}" />
                            </a>`;
                });

                let $postImages = document.querySelector('.post-images');
                $postImages.innerHTML = tags;
            });
    }
}


{   // 댓글 처리
    let boardId = document.querySelector('.btn-back').dataset.id;

    let $replyListWrap = document.querySelector('.reply-list-wrap');

    $replyListWrap.addEventListener('click', function (e) {
        if(e.target.classList.contains('reply-btns')){
            console.log('click!!!!!!!')
            // closest('선택자') : 조상 요소 중 선택자와 일치하는 요소를 찾는다.
            // 선택자와 일치하는 요소가 여러개인 경우 가장 가까운 요소를 찾아온다.
            // querySelector('선택자') : 자손 요소 중 선택자와 일치하는 요소를 찾는다.
            let $btnBox = e.target.closest('.reply').querySelector('.reply-btns__box');
            $btnBox.classList.remove('none');
        }

        let $btnBox = document.querySelector('.reply-btns__box');
        $btnBox.classList.remove('none');

    });

    // ------------------------------------------------------


    document.body.addEventListener('click' , function (e) {
        if(e.target.classList.contains('reply-btns')){
            return ;
        }
        let $list = document.querySelectorAll('.reply-btns__box');

        $list.forEach(ele => {
           ele.classList.add('none');
        });
    });




    let $replyBtn = document.querySelector('.btn-reply');

    $replyBtn.addEventListener('click' , function (){
       let content = document.querySelector('#reply-content').value

        let commentObj = {
           content : content
        }
        console.log(content);

        comm.addComment(boardId, commentObj, function () {
            document.querySelector('#reply-content').value = '';

            comm.getList(boardId, showComment);
        });
    });

    // 수정 / 삭제 버튼처리
    $replyListWrap.addEventListener('click' , function (e) {
        let clsList = e.target.classList
        if(clsList.contains('reply-remove-btn')){
            console.log('삭제 버튼')
        }else if(e.target.classList.contains('reply-modify-btn')){
            console.log('수정 버튼')
        }
    })


    comm.getList(boardId, showComment);

    function showComment(list) {
        let tags = '';

        list.forEach(comment => {
            // console.log(comment)
            // console.log(comment.content)

            tags += `
            <div class="reply">
              <div class="reply-box">
                <div class="reply-box__writer">${comment.loginId}</div>
                <div class="reply-box__content">${comment.content}</div>
              </div>
              <div class="reply-btn-box">
                <span class="reply-btns"></span>
                <div class="reply-btns__box none">
                  <div class="reply-remove-btn">삭제</div>
                  <div class="reply-modify-btn">수정</div>
                </div>
              </div>
            </div>
            `;
        });

        document.querySelector('.reply-list-wrap').innerHTML = tags;
    }
}


















