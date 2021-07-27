package com.example.demo.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author qzp
 * @Description: 定时任务(测试)
 * @date 2021/7/27 14:33
 */
@Component
@Slf4j
public class ScheduledTask {

    /**
     * 五秒执行一次
     */
    @Async("scheduledPoolTaskExecutor")
    @Scheduled(fixedRate = 5000)
    public void getCurrentDate() {
        log.info("Scheduled定时任务执行，当前时间： {}", LocalDateTime.now());
    }
}
