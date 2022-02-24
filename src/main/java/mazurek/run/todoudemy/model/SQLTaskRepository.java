package mazurek.run.todoudemy.model;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SQLTaskRepository   extends JpaRepository<Task,Integer> {
    @Override
    @Query(nativeQuery=true,value="select count(1)>1 from tasks where id=:id")
    boolean existsById(@Param("id") Integer id);

    @Override
    @Query(nativeQuery=true,value="select * from tasks")
    List<Task> findAll();
}
