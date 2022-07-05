package com.redasp.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.redasp.pma.dto.ProjectStage;
import com.redasp.pma.entities.Employee;
import com.redasp.pma.entities.Project;

public interface IProjectRepository extends PagingAndSortingRepository<Project,Long> {
    
	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery=true, value="select stage as label , count(*) as value from project group by stage")
	public List<ProjectStage> getProjectStatus(); 
	
	public Project findByProjectId(long theId);
}
