/*
이 파일은 모듈을 만들어 두는 용도로 사용할 것이다.
JS의 함수 , 클래스 모듈화 시켜 저장하는 공간이다.
함수를 부품처럼 만들어두고 사용은 다른 파일에서 할 것이다.
 */

// 내보내기
export function getList(boardId, callback){

    fetch(`/boards/${boardId}/comments`, {
        method : 'GET'
    }).then(resp => {
        if (!resp.ok) {
            throw new Error('응답 오류');
        }
        return resp.json()
    }).then(list => {
            callback(list)
        }).catch(error => {
            console.log('문제 발생 : ' , error)
    });
}

export function addComment(boardId, commentObj, callback) {
    fetch(`/boards/${boardId}/comments`, {
        method : 'POST',
        headers : {
            'Content-Type' : 'application/json'
        },
        body : JSON.stringify(commentObj)  // JS 객체를 JSON으로 형변환 해준다.
    }).then(resp => {
        if (!resp.ok) {
            throw new Error('응답 오류');
        }
        return resp;
    }).then(result => {
        callback();
    }).catch(error => {
        console.log('문제 발생 : ' , error)
    });
}