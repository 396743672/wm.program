package org.github.ycg000344.weiming.server.gateway.zuul.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.github.ycg000344.weiming.server.gateway.zuul.rpc.LogFeign;
import org.github.ycg000344.weiming.server.gateway.zuul.vo.BaseLog;

import lombok.extern.slf4j.Slf4j;

/** 
 * ClassName: LogThread <br/> 
 * Description: TODO <br/><br/>  
 * Date: 2018年7月10日 下午5:19:28 <br/><br/>  
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 */  
@Slf4j
public class LogThread extends Thread {
    private static LogThread dblog = null;
    private static BlockingQueue<BaseLog> logInfoQueue = new LinkedBlockingQueue<BaseLog>(1024);
    private LogFeign logService;

    public LogFeign getLogService() {
        return logService;
    }

    public LogThread setLogService(LogFeign logService) {
        if(this.logService==null) {
            this.logService = logService;
        }
        return this;
    }

    public static synchronized LogThread getInstance() {
        if (dblog == null) {
            dblog = new LogThread();
        }
        return dblog;
    }

    private LogThread() {
        super("CLogOracleWriterThread");
    }

    public void offerQueue(BaseLog logInfo) {
        try {
            logInfoQueue.offer(logInfo);
        } catch (Exception e) {
            log.error("日志写入失败", e);
        }
    }

    @Override
    public void run() {
        List<BaseLog> bufferedLogList = new ArrayList<BaseLog>(); // 缓冲队列
        while (true) {
            try {
                bufferedLogList.add(logInfoQueue.take());
                logInfoQueue.drainTo(bufferedLogList);
                if (bufferedLogList != null && bufferedLogList.size() > 0) {
                    // 写入日志
                    for(BaseLog log:bufferedLogList){
                        logService.add(log);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                // 防止缓冲队列填充数据出现异常时不断刷屏
                try {
                    Thread.sleep(1000);
                } catch (Exception eee) {
                }
            } finally {
                if (bufferedLogList != null && bufferedLogList.size() > 0) {
                    try {
                        bufferedLogList.clear();
                    } catch (Exception e) {
                    }
                }
            }
        }
    }
}