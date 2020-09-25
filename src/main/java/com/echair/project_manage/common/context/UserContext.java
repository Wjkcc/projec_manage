package com.echair.project_manage.common.context;

import com.echair.project_manage.common.pojo.vo.UserVO;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: wjk
 * @date: 2020/9/2 14:44
 **/
@Component
public class UserContext {
    private static final InheritableThreadLocal<UserVO> threadLocal;
    static {
        threadLocal = new InheritableThreadLocal<>();
    }

    /**
     * 获取当前用户
     * @return
     */
    public static UserVO getCurrentUser() {
        return threadLocal.get();
    }

    public static void setUser(UserVO user) {
        threadLocal.set(user);
    }

    public static void remove() {
        threadLocal.remove();
    }
}
