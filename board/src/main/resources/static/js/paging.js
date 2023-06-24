function makePages(page, size, total) {
    let result = "";

    // 페이징 시작 번호
    const startNum = (Math.ceil(Page/10) * 10) - 9;
    
    // 시작 번호가 1이면 이전 버튼 노출 안 되게
    startNum == 1 ? "" : result += `<li class="page-item"><a class="page-link" href="#">&laquo;</a></li>`;

    // 페이지 번호 변수
    let tmp = startNum;

    // 페이징 버튼 동적 생성
    while (true) {
        if(tmp * 10 > total) {
            break;
        }
        
        tmp++;
    }

    // 다음 버튼 노출 여부
    total % (size * 10) == 1 ? `<li class="page-item"><a class="page-link" href="#">&raquo;</a></li>` : "";

    return result;

}