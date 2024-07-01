{
    console.log('hi~!');
}

{   // 목록으로 버튼 처리
    let $listBtn = document.querySelector('#list-btn');

    $listBtn.addEventListener('click', () => {
        console.dir(window.location);

        window.location.href = '/member/list';
    });
}

{   // 수정하기 버튼 처리
    let $modifyBtn = document.querySelector('#modify-btn');

    $modifyBtn.addEventListener('click', function () {
        console.dir(this)
        let memberId = this.dataset.id;

        location.href = `/member/modify?memberId=${memberId}`;
    });
}






