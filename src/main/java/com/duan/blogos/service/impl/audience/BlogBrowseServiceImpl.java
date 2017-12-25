package com.duan.blogos.service.impl.audience;

import com.duan.blogos.dao.blog.BlogCategoryDao;
import com.duan.blogos.dao.blog.BlogDao;
import com.duan.blogos.dao.blog.BlogLabelDao;
import com.duan.blogos.dto.blog.BlogCommentDTO;
import com.duan.blogos.dto.blog.BlogMainContentDTO;
import com.duan.blogos.entity.blog.Blog;
import com.duan.blogos.entity.blog.BlogCategory;
import com.duan.blogos.entity.blog.BlogLabel;
import com.duan.blogos.entity.blog.BlogStatistics;
import com.duan.blogos.manager.DbPropertiesManager;
import com.duan.blogos.result.ResultBean;
import com.duan.blogos.service.audience.BlogBrowseService;
import com.duan.blogos.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2017/12/19.
 *
 * @author DuanJiaNing
 */
@Service
public class BlogBrowseServiceImpl implements BlogBrowseService {

    @Autowired
    private BlogDao blogDao;

    @Autowired
    private BlogCategoryDao categoryDao;

    @Autowired
    private BlogLabelDao labelDao;

    @Autowired
    private DbPropertiesManager dbPropertiesManager;

    @Override
    public ResultBean<BlogMainContentDTO> getBlogMainContent(int blogId) {

        //查询数据
        Blog blog = blogDao.getBlogById(blogId);
        if (blog == null) return null;
        String ch = dbPropertiesManager.getStringFiledSplitCharacterForNumber();
        int[] cids = StringUtils.intStringDistinctToArray(blog.getCategoryIds(), ch);
        int[] lids = StringUtils.intStringDistinctToArray(blog.getLabelIds(), ch);
        List<BlogCategory> categories = cids == null ? null : categoryDao.listCategoryById(cids);
        List<BlogLabel> labels = lids == null ? null : labelDao.listLabelById(lids);

        //填充数据
        BlogMainContentDTO dto = new BlogMainContentDTO();
        dto.setCategories(categories == null ? null : categories.toArray(new BlogCategory[categories.size()]));
        dto.setLabels(labels == null ? null : labels.toArray(new BlogLabel[labels.size()]));
        dto.setId(blog.getId());
        dto.setKeyWords(StringUtils.stringToStringArray(blog.getKeyWords(),
                dbPropertiesManager.getStringFiledSplitCharacterForString()));
        dto.setNearestModifyDate(blog.getNearestModifyDate());
        dto.setReleaseDate(blog.getReleaseDate());
        dto.setStatus(blog.getState());
        dto.setSummary(blog.getSummary());
        dto.setTitle(blog.getTitle());
        dto.setWordCount(blog.getWordCount());
        dto.setContent(blog.getContent());

        return new ResultBean<>(dto);
    }

    @Override
    public ResultBean<BlogStatistics> getBlogStatistics(int blogId) {
        return null;
    }

    @Override
    public ResultBean<List<BlogCommentDTO>> listBlogComment(int blogId, int offset, int rows) {
        return null;
    }

    @Override
    public ResultBean<Integer> insertComment(String content, int spokesmanId, int listenerId, int blogId) {
        return null;
    }

    @Override
    public ResultBean<Integer> insertShareCountIncrement(int blogId) {
        return null;
    }

    @Override
    public ResultBean<Integer> insertAdmire(int blogId, int paierId, int earnerId, float money) {
        return null;
    }

    @Override
    public ResultBean<Integer> insertCollect(int blogId, int cllocterId, String reason, int categoryId) {
        return null;
    }

    @Override
    public ResultBean<Integer> insertComplain(int blogId, int complainerId, String reason) {
        return null;
    }
}