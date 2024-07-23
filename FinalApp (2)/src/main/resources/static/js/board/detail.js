{ // 버튼 처리
    let $backBtn = document.querySelector('.btn-back');

    $backBtn.addEventListener('click', () => {
        window.history.back();
    });

    let $removeBtn = document.querySelector('.btn-remove');

    $removeBtn.addEventListener('click', function () {
        let boardId = this.dataset.id;

        location.href = `/board/remove?boardId=${boardId}`;
    });

    let $modifyBtn = document.querySelector('.btn-modify');

    $modifyBtn.addEventListener('click', function () {
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





















