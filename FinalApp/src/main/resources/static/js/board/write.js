{   // 서머노트 api 처리
    // 바닐라 js 의 DOM 처리 : document.querySelector('선택자');
    // JQuery : $('선택자');

    $('#post-content').summernote({
        placeholder: 'Hello stand alone ui',
        tabsize: 2,
        height: 500,
        width: 700,
        toolbar: [
            ['style', ['style']],
            ['font', ['bold', 'underline', 'clear']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['table', ['table']],
            ['insert', ['link', 'picture']],
            ['view', ['fullscreen', 'codeview', 'help']]
        ]
    });
}