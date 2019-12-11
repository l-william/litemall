/**
 * 广告自动下线的工具类
 * @author xingzhou
 * @date 2019/12/11 20:47
 * @version 1.0
 */

package xmu.oomall.util;


import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;

import static xmu.oomall.util.CronDateUtil.getCron;

//通过setCron 方法修改任务开始时间
@Component("myScheduled")
public class AutoOffLine implements SchedulingConfigurer {
    //默认的任务开始时间
    private String cron = "0 11 11 11 11 2050";

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        // TODO Auto-generated method stub
        taskRegistrar.addTriggerTask(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("执行任务");
            }

        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                return new CronTrigger(cron).nextExecutionTime(triggerContext);
            }
        });
    }
    public void setCron(Date date) {
        String cron=getCron(date);
        this.cron = cron;
    }
}