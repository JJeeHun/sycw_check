const Loading = (() => {
    const back_layer = document.createElement('div');
    const loading = document.createElement("div");
    back_layer.classList.add('loading-box-container');
    back_layer.append(loading);
    loading.classList.add('loader');

    document.body.append(back_layer);
    return {
        start: () => back_layer.classList.add('show'),
        stop: () => back_layer.classList.remove('show'),
    }
})();

const getCenter = (popupWidth,popupHeight) => {
    // 현재 모니터 설정 정보를 가져옵니다.
    const screenX = window.screenX !== undefined ? window.screenX : window.screenLeft;
    const screenY = window.screenY !== undefined ? window.screenY : window.screenTop;
    const outerWidth = window.outerWidth !== undefined ? window.outerWidth : document.documentElement.clientWidth;
    const outerHeight = window.outerHeight !== undefined ? window.outerHeight : document.documentElement.clientHeight;

    // 새 창을 열기 위한 위치를 계산합니다.
    const left = screenX + (outerWidth - popupWidth) / 2;
    const top = screenY + (outerHeight - popupHeight) / 2;
    return {left, top}
}
