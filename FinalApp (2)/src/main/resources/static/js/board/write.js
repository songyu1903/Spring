{   // 서머노트 처리
    // 바닐라 JS의 DOM 처리 : document.querySelector('선택자');
    // JQuery : $('선택자');

    $('#post-content').summernote({
        placeholder: 'Hello stand alone ui',
        tabsize: 2,
        height: 500,
        width : 700,
        toolbar: [
            ['style', ['style']],
            ['font', ['bold', 'underline']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['table', ['table']],
            ['insert', ['link', 'picture']],
            ['view', ['fullscreen', 'codeview', 'help']]
        ]
    });
}

{   // 파일 첨부 처리
    let $input = document.querySelector('#post-image');
    let $imgList = document.querySelectorAll('.img-list');

    $input.addEventListener('change', function () {
        console.log('change@@@@');

        let newFiles= checkLength(this.files, 4);
        $input.files = newFiles;

        console.log($input.files)

        appendImg(newFiles);

    });

    $imgList.forEach(ele => {
        ele.addEventListener('click', function () {
            let name = this.dataset.name;
            // console.log(name)

            removeImg(name);
            appendImg($input.files);
        });
    });


    function removeImg(name) {
        let files = $input.files;
        let dt = new DataTransfer();

        for(let i=0; i<files.length; i++){
            if(files[i].name !== name) {
                dt.items.add(files[i]);
            }
        }

        $input.files = dt.files;
    }


    // 이미지 미리보기 처리 함수
    function appendImg(files) {
        for (let i=0; i<4; i++) {
            if (i < files.length){
                let src = URL.createObjectURL(files[i]);

                $imgList[i].style.backgroundImage = `url(${src})`;
                $imgList[i].style.backgroundSize = 'cover';
                $imgList[i].setAttribute('data-name', files[i].name)
                $imgList[i].classList.add('x-box')
            } else {
                $imgList[i].style.backgroundImage = `url(data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIzNiIgaGVpZ2h0PSIzNiI+PGcgZmlsbD0ibm9uZSIgZmlsbC1ydWxlPSJldmVub2RkIj48ZyBzdHJva2U9IiNCNUI1QjUiIHN0cm9rZS13aWR0aD0iMS41IiB0cmFuc2Zvcm09InRyYW5zbGF0ZSg0IDQpIj48cmVjdCB3aWR0aD0iMjgiIGhlaWdodD0iMjgiIHJ4PSIzLjUiLz48Y2lyY2xlIGN4PSI4LjU1NiIgY3k9IjguNTU2IiByPSIyLjMzMyIvPjxwYXRoIGQ9Ik0yOCAxOC42NjdsLTcuNzc3LTcuNzc4TDMuMTExIDI4Ii8+PC9nPjxwYXRoIGQ9Ik0wIDBoMzZ2MzZIMHoiLz48L2c+PC9zdmc+)`;
                $imgList[i].style.backgroundSize = null;
                $imgList[i].removeAttribute('data-name');
                $imgList[i].classList.remove('x-box');
            }
        }
    }


//     파일 길이 체크 함수
    function checkLength(files, size) {
        if (files.length > size) {
            alert(`파일은 최대 ${size}개까지만 첨부 가능합니다.`)
            // 최대 첨부 파일 수를 넘으면 비어있는 files 객체를 반환한다.
            return new DataTransfer().files;
        }
        return files;
    }
}












