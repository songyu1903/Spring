{   // 댓글 처리
    let $writeBtn = document.querySelector('#write-btn');
    let $content = document.querySelector('#content');

    $writeBtn.addEventListener('click', (e) => {
        console.log('click');
        let content = $content.value;

        console.log(content)

        let target = e.target;
        let boardId = target.dataset.id;

        console.log(boardId);

        let bodyData = {content: content};

        fetch(`/v1/boards/${boardId}/comments`, {
            method: 'POST',
            headers: {'Content-Type': 'application/json'}, //Content-Type : 우리가 보내는 데이터의 타입
            body: JSON.stringify(bodyData) //stringify() : JS객체를 JSON형태로 변환
        }).then(resp => resp)
            .then(resp => {
                getCommentList(displayComment);
                $content.value = '';
            })
    });
}

getCommentList(displayComment);

function getCommentList(callback) {
    let $writeBtn = document.querySelector('#write-btn');
    let boardId = $writeBtn.dataset.id

    fetch(`/v1/boards/${boardId}/comments`)
        .then(resp => resp.json())
        .then(list => {
            console.log(list)
            console.log(list[0])
            console.log(list[0].content)
            callback(list)
        });
}

function displayComment(list) {
    let tags = '';

    list.forEach(comment => {
        tags += `
                <div class="comment-row">
                    <div>작성자 : <span>${comment.loginId}</span></div>
                    <div>${comment.content}</div>
                </div>
                `;
    });

    let $commentsBox = document.querySelector('.comments-box');

    $commentsBox.innerHTML = tags;
}








