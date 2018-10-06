package com.duan.blogos.service.service.blog;

/**
 * Created on 2017/12/26.
 * 读者对博文可进行的操作服务
 * <p>
 * 1. 评论
 * 2. 分享
 * 3. 赞赏
 * 4. 收藏
 * 5. 投诉
 *
 * @author DuanJiaNing
 */
public interface OperateService {

    /**
     * 博文分享次数加一
     *
     * @param blogId   博文id
     * @param sharerId 分享者id
     * @return 博文被分享的次数
     */
    Integer insertShare(Long blogId, Long sharerId);

    /**
     * 新增投诉记录，同时博文投诉次数加一
     *
     * @param blogId     博文id
     * @param complainId 投诉者id
     * @param content    投诉内容
     * @return 新纪录id
     */
    Long insertComplain(Long blogId, Long complainId, String content);

    /**
     * 新增博文收藏记录，同时博文收藏次数加一
     *
     * @param blogId      博文id
     * @param collectorId 收藏者id
     * @param reason      收藏理由
     * @param categoryId  收藏到收藏者自己的哪一个类别
     * @return 新纪录id
     */
    Long insertCollect(Long blogId, Long collectorId, String reason, Long categoryId);

    /**
     * 取消文章收藏，同时文章收藏数减一
     *
     * @param bloggerId 收藏者id
     * @param blogId    收藏的博文id
     * @return 删除成功返回true
     */
    boolean deleteCollect(Long bloggerId, Long blogId);

    /**
     * 新增喜欢记录，同时文章喜欢数加一
     *
     * @param blogId  博文id
     * @param likerId 给出喜欢的人的id，为游客时传-1
     * @return 博文喜欢数
     */
    Integer insertLike(Long blogId, Long likerId);

    /**
     * 取消喜欢，同时博文喜欢数减一
     *
     * @param likerId 喜欢者id
     * @param blogId  博文id
     * @return 删除成功返回true
     */
    boolean deleteLike(Long likerId, Long blogId);

}