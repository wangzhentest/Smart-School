import { ref, onMounted, onUnmounted } from 'vue';

export function useTimer(interval, callback) {
    const count = ref(0);
    let timerId;

    const startTimer = () => {
        timerId = setInterval(() => {
            count.value++;
            callback();
        }, interval);
    };

    const stopTimer = () => {
        clearInterval(timerId);
    };

    // 在组件挂载时启动定时器
    onMounted(() => {
        startTimer();
    });

    // 在组件卸载时停止定时器
    onUnmounted(() => {
        stopTimer();
    });

    return {
        count
    };
}
