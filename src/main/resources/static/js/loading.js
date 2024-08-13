const Loading = (() => {
    const back_layer = document.createElement('div');
    const loading = document.createElement("div");
    back_layer.classList.add('loading-box-container');
    back_layer.append(loading);
    loading.classList.add('loader');

    document.body.append(back_layer);

    window.onpageshow = function(event){
        if(event.persisted || (window.performance && window.performance.navigation.type == 2)){
            Loading.stop();
        }
    }

    return {
        start: () => back_layer.classList.add('show'),
        stop: () => back_layer.classList.remove('show'),
    }
})();

const CommonMessage = ((sec) => {
    const root = document.createElement('section');
    root.classList.add('notification');

    document.body.append(root);

    return {
        notification: (title,messageText) => {
            const notificationBox = document.createElement('div');
            const titleBox = document.createElement('h3');
            const contentBox = document.createElement('p');

            notificationBox.append(titleBox);
            notificationBox.append(contentBox);

            notificationBox.classList.add('notification-box');
            titleBox.classList.add('notification-title');
            contentBox.classList.add('notification-content');

            titleBox.textContent = title;
            contentBox.textContent = messageText;

            root.append(notificationBox);
            setTimeout(() => {
                notificationBox.classList.add('notification-close');
                setTimeout(() => notificationBox.remove(), 100);
            },(sec || 1) * 1000);
        },
    }
})(3);

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
