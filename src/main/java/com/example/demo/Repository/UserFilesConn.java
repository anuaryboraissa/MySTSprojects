package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entity.UserFiles;

public interface UserFilesConn extends JpaRepository<UserFiles, Long> {
	@Query("select f from UserFiles as f where f.user.Id= ?1")
	 List<UserFiles> findFilesById(long id);
	@Modifying
	@Query("delete from UserFiles as f where f.user.Id= ?1")
	void deleteFilesByUid(long uid);
	@Query("select new UserFiles(d.id,d.name,d.ModifiedFileName) from UserFiles d ORDER BY d.id DESC ")
	List<UserFiles> findAll();
}
