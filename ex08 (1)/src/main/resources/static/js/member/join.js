{
    console.log("join.js @@@@@@");

    let $checkIdBtn = document.querySelector('#check-id');

    $checkIdBtn.addEventListener('click', function () {
        
        // fetch api 
        // JS에서 HTTP 요청을 만들어 보낼 수 있는 기능을 제공해주는 라이브러리
        // fetch()를 이용하여 요청을 만들어 보낼 수 있으며
        // 응답을 then() 을 통해 받을 수 있다.
        
        // fetch('url', {요청 정보})
        fetch(`/v1/member/test`, {method: 'GET'})
            // then(resp => {....}) : then은 응답을 받아 arrow 함수의 매개변수로 전달한다.
            // 주로 resp.text(), resp.json() 을 사용한다.
            // text() : 받아온 응답 데이터를 텍스트 형태로 변환
            // json() : 받아온 응답 데이터를 json 형태로 변환
            // 첫 번째 then()은 받아온 응답 데이터를 변환하여 넘겨주는 역할을 한다.
            .then(resp => resp.text())
            // 두 번째 then()은 위에서 변환한 데이터를 받아 처리하는 역할을 한다.
            .then(text => {
                console.log(text);
                let $inputMsg = document.querySelector('.input-msg');

                $inputMsg.innerText = text;
            });
    });
}

{
    let $loginIdInput = document.querySelector('#loginId');

    $loginIdInput.addEventListener('change', function (){
        console.log('change @@@@@');

        let loginId = this.value;
        console.log(loginId);

        fetch(`/v1/members/login-id?loginId=${loginId}`, {
            method : 'get'
        }).then(resp => resp.text())
            .then(text => {
                console.log(text);

                let result = '';
                if(text == 0){
                    result = '사용 가능한 아이디입니다.';
                } else{
                    result = '중복된 아이디입니다.'
                }

                let $inputMsg = document.querySelector('.input-msg');
                $inputMsg.innerText = result;

            });
    });
}














