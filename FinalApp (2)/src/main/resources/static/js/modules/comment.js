/*
이 파일은 모듈을 만들어 두는 용도로 사용할 것이다.
JS의 함수, 클래스 모듈화 시켜 저장하는 공간이다.
함수를 부품처럼 만들어두고 사용은 다른 파일에서 할 것이다.
 */

export function getList(boardId, page , callback) {
    fetch(`/boards/${boardId}/comments?page=${page}`, {
        method: 'GET'
    }).then(resp => {
        if (!resp.ok) {
            throw new Error('응답 오류');
        }

        return resp.json();
    }).then(obj => {
        callback(obj)
    }).catch(error => {
        console.error("문제 발생 : ", error)
    });
}

export function addComment(boardId, commentObj, callback) {
    fetch(`/boards/${boardId}/comments`, {
        method: 'POST',
        headers : {
            'Content-Type' : 'application/json'
        },
        body : JSON.stringify(commentObj) //JS객체를 JSON으로 형변환 해준다.
    }).then(resp => {
        if (!resp.ok) {
            throw new Error('응답 오류');
        }

        return resp;
    }).then(result => {
        callback();
    }).catch(error => {
        console.error("문제 발생 : ", error)
    });
}

// 댓글 삭제
export function removeComment(commentId, callback){
    fetch(`/comments/${commentId}`, {
        method : 'DELETE'
    }).then(resp => {
        if (!resp.ok) {
            throw new Error('응답 오류');
        }
        return resp;
    }).then(result => {
        callback();
    }).catch(error => {
        console.error("문제 발생 : ", error)
    });

}

// 댓글 수정
export function modifyComment(commentId, commentObj, callback) {
    fetch(`/comments/${commentId}`, {
        method : 'PATCH',
        headers : {
            'Content-Type' : 'application/json'
        },
        body : JSON.stringify(commentObj)
    }).then(resp => {
        if (!resp.ok) {
            throw new Error('응답 오류');
        }
        return resp;
    }).then(result => {
        callback();
    }).catch(error => {
        console.error("문제 발생 : ", error)
    });
}

// 댓글 작성일자
export function timeForToday(value){
    // 현재 날짜와 시간
    let today = new Date();
    let timeValue = new Date(value);

    // getTime()은 1970/01/01을 기준으로 지금까지 몇 ms가 지났는지 알려준다.
    // 몇 분이 지났는지 저장한다.
    let betweenTime = Math.floor( (today.getTime() - timeValue.getTime()) / 1000 / 60 );

    if(betweenTime < 1){return '방금 전';}
    if(betweenTime < 60) {
        return `${betweenTime}분 전`
    }
    let betweenTimeHour = Math.floor(betweenTime / 60);

    if(betweenTime < 24){ return `${betweenTimeHour} 시간 전`}

    let betweenTimeDay = Math.floor(betweenTimeHour / 24);

    if(betweenTimeDay < 365){
        return `${betweenTimeDay} 일 전`
    }
    return `${Math.floor(betweenTimeDay / 365)} 년 전`;
    
}

