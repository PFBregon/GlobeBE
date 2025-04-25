package dev.patriciafb.spring.teacher;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class TeacherServiceTest {

    private final TeacherRepository repository = Mockito.mock(TeacherRepository.class);
    private final TeacherService service = new TeacherService(repository);

    @Test
    void testDeleteById() {
        Long id = 1L;
        doNothing().when(repository).deleteById(id);

        service.deleteById(id);

        verify(repository, times(1)).deleteById(id);
    }

    @Test
    void testFindAll() {
        List<Teacher> teachers = Arrays.asList(new Teacher(), new Teacher());
        when(repository.findAll()).thenReturn(teachers);

        List<Teacher> result = service.findAll();

        assertEquals(teachers.size(), result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testSave() {
        Teacher teacher = new Teacher();
        when(repository.save(teacher)).thenReturn(teacher);

        Teacher result = service.save(teacher);

        assertNotNull(result);
        assertEquals(teacher, result);
        verify(repository, times(1)).save(teacher);
    }
}
