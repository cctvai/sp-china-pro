package com.example.person.service.imple;

import com.example.person.entity.ComFile;
import com.example.person.mapper.ComFileMapper;
import com.example.person.service.ComFileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * ComFileServiceImpl
 * Created by yec on 2019/7/29.
 */
@Service
public class ComFileServiceImpl implements ComFileService {
	@Resource
	private ComFileMapper comFileMapper;

	@Override
	public List<ComFile> selectByCondition(ComFile comFile) throws Exception {
		return comFileMapper.selectByCondition(comFile);
	}

	@Override
	public ComFile save(ComFile comFile) throws Exception {
		comFileMapper.insert(comFile);
		return comFile;
	}

	@Override
	public ComFile update(ComFile comFile) throws Exception {
		comFileMapper.updateByPrimaryKey(comFile);
		return comFile;
	}

	@Override
	public ComFile selectByPrimaryKey(String id) {
		return comFileMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return comFileMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int deleteByTypeAndParentId(Integer type, String parentId) {
		return comFileMapper.deleteByTypeAndParentId(type, parentId);
	}

	@Override
	public void saveParentFiles(Integer type, String parentId, List<ComFile> files) throws Exception {
		deleteByTypeAndParentId(type, parentId);

		Date date = new Date();
		for (ComFile file : files) {
			file.setType(Long.valueOf(type));
			file.setParentId(parentId);
			file.setLrrq(date);

			save(file);
		}
	}

	@Override
	public List<ComFile> listParentFiles(Integer type, String parentId) {
		return comFileMapper.listParentFiles(type, parentId);
	}
}
