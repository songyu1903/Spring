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
    let page = 1;
    let hasNext = true;

    $replyListWrap.addEventListener('click', function (e) {

        if (e.target.classList.contains('reply-btns')) {
            console.log('click@@@@@@@');
            // closest('선택자') : 조상 요소 중 선택자와 일치하는 요소를 찾는다.
            // 선택자와 일치하는 요소가 여러개인 경우 가장 가까운 요소를 찾아온다.
            // querySelector('선택자') : 자손 요소 중 선택자와 일치하는 요소를 찾는다.
            let $btnBox = e.target.closest('.reply').querySelector('.reply-btns__box');
            $btnBox.classList.remove('none');
        }


    });

    document.body.addEventListener('click', function (e) {
        if (e.target.classList.contains('reply-btns')) {
            return;
        }

        let $list = document.querySelectorAll('.reply-btns__box');

        $list.forEach(ele => {
            ele.classList.add('none');
        });
    });

    // --------------------------------------------------------------------------

    let $replyBtn = document.querySelector('.btn-reply');

    $replyBtn.addEventListener('click', function () {
        let content = document.querySelector('#reply-content').value;

        let commentObj = {
            content: content
        };

        comm.addComment(boardId, commentObj, function () {
            document.querySelector('#reply-content').value = '';

            comm.getList(boardId, page, showComment);
        });
    });

    // 수정/삭제 버튼 처리
    $replyListWrap.addEventListener('click', function (e) {
        let clsList = e.target.classList;

        if (clsList.contains('reply-remove-btn')) {
            console.log('삭제 버튼');
            let commentId = e.target.closest('.reply').dataset.id;
            comm.removeComment(commentId, function () {
                comm.getList(boardId, page, showComment);
            });

        } else if (clsList.contains('reply-modify-btn')) {
            console.log('수정 버튼');
            let $replyContent = e.target.closest('.reply').querySelector('.reply-box__content');
            let $modifyBox = document.createElement('div');
            $modifyBox.classList.add('modify-box');

            $modifyBox.innerHTML = `
                <textarea class="modify-content">${$replyContent.innerText}</textarea>
                <button type="button" class="modify-content-btn">수정 완료</button>
            `;

            $replyContent.replaceWith($modifyBox);
        }else if(clsList.contains('modify-content-btn')){
            console.log('수정 완료 버튼')
            let commentId = e.target.closest('.reply').dataset.id
            let content = e.target.closest('.reply').querySelector('.modify-content').value;

            let commentObj = {
                content : content
            }

            comm.modifyComment(commentId, commentObj, function (){
                comm.getList(boardId, page, showComment);
            });
        }
    }) ;

    window.addEventListener('scroll', function (){
        // console.dir(document.documentElement)
        if(!hasNext) { return ;}

        let {scrollTop , scrollHeight, clientHeight} = document.documentElement

        if(clientHeight + scrollTop >= scrollHeight - 10){
            console.log('바닥!')
            page++;
            comm.getList(boardId, page, showComment);
        }
    });


    comm.getList(boardId, page, showComment);

    function showComment(obj) {
        let tags = '';


        console.log(obj)
        hasNext = obj.hasNext;
        let list = obj.contentList;

        console.log(list)

        list.forEach(comment => {
            // console.log(comment)
            // console.log(comment.content)

            tags += `
            <div class="reply" data-id="${comment.commentId}">
              <div class="reply-box">
                <div class="reply-box__writer">${comment.loginId}</div>
                <div class="reply-box__content">${comment.content}</div>
              </div>
              
              <div class="reply-time">
              ${comm.timeForToday(comment.modifiedDate)};
              </div>
              
              <div class="reply-btn-box">`;

            if (comment.memberId == sessionMemberId) {
                tags += `
                    <span class="reply-btns"></span>
                    <div class="reply-btns__box none">
                      <div class="reply-remove-btn">삭제</div>
                      <div class="reply-modify-btn">수정</div>
                    </div>`;
            }

            tags += `</div>
            </div>
            `;
        });

        // document.querySelector('.reply-list-wrap').innerHTML = tags;

        document.querySelector('.reply-list-wrap').insertAdjacentHTML("beforeend", tags);
    }
}
















