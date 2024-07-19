{ // 버튼 처리
    let $backBtn = document.querySelector('.btn-back');

    $backBtn.addEventListener('click', () => {
       window.history.back();
    });

    let $removeBtn = document.querySelector('.btn-remove');

    // () => {} 은 this 를 사용 불가
    // 익명함수를 써야 this 를 사용 가능
    $removeBtn.addEventListener('click', function () {
        let boardId =  this.dataset.id;
        location.href = `/board/remove?boardId=${boardId}`
    });

    let $modifyBtn = document.querySelector('.btn-modify');

    $modifyBtn.addEventListener('click', function ()  {
        let boardId =  this.dataset.id;
        location.href = `/board/modify?boardId=${boardId}`
    });

}