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
})()
