package org.whystudio.internship.service;

import org.whystudio.internship.entity.Notification;
import com.baomidou.mybatisplus.extension.service.IService;
import org.whystudio.internship.vo.JsonResult;

/**
 * <p>
 * 实习单位发布通知
 服务类
 * </p>
 *
 * @author mrruan
 * @since 2020-03-05
 */
public interface INotificationService extends IService<Notification> {

    JsonResult newsList(Integer page, Integer limit);

    JsonResult whichNews(Long id);
}
