package org.knight.domain;

/**
 * 返回消息体
 * @author Wayss.
 * @date 2018/7/21.
 */
public class Message {
    /**
     * 是否成功
     */
    private boolean isSuccess;

    /**
     * 消息内容
     */
    private String message;

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
