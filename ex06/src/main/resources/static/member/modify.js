{   // 삭제하기 버튼 처리
    let $removeBtn = document.querySelector('#remove-btn');
    let $formObj = document.querySelector('form');

    $removeBtn.addEventListener('click', () => {
        console.dir($formObj);
        $formObj.action = `/member/remove`;
        $formObj.submit();
    });
}