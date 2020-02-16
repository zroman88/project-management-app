package com.romz.pma.dao;

import com.romz.pma.ProjectManagementApplication;
import com.romz.pma.entities.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author roman - Project project-management
 */
@ContextConfiguration(classes = ProjectManagementApplication.class)
//@RunWith(SpringRunner.class)
@DataJpaTest
@SqlGroup({@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:schema.sql", "classpath:data.sql"}),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = {"classpath:drop.sql"})})
public class ProjectRepositoryIntegrationTest {
    @Autowired
    IProjectRepository projectRepo;

    @Test
    public void ifNewProjectSaved_thenSuccess() {
        Project project = new Project("New Test Project", "COMPLETE", "An exciting test project....not");
        projectRepo.save(project);

        assertEquals(5, projectRepo.findAll().size());
    }
}
