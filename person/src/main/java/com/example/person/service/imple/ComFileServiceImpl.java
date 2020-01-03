package com.example.person.service.imple;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.person.dto.ComFileInDTO;
import com.example.person.dto.ComFileOutDTO;
import com.example.person.entity.ComFile;
import com.example.person.mapper.ComFileMapper;
import com.example.person.service.ComFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * ComFileServiceImpl
 * Created by yec on 2019/7/29.
 */
@Slf4j
@Service
public class ComFileServiceImpl implements ComFileService {
	@Resource
	private ComFileMapper comFileMapper;

	@Override
	public List<ComFileOutDTO> selectByCondition(ComFileInDTO inDTO) throws Exception {
		return comFileMapper.selectByCondition(inDTO);
	}

	@Override
	public int selectByConditionTotal(ComFileInDTO inDTO) throws Exception {
		return comFileMapper.selectByConditionTotal(inDTO);
	}

	@Override
	public ComFile save(ComFile comFile) throws Exception {
		comFile.setId(IdWorker.getId()+"");
        log.info( "savesavesave=111= "+  comFile );
		comFileMapper.insert(comFile);
		log.info( "savesavesave=222= "+  comFile );
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
			save(file);
		}
	}

	@Override
	public List<ComFile> listParentFiles(Integer type, String parentId) {
		return comFileMapper.listParentFiles(type, parentId);
	}
}
